package com.codecool.hackernews.dao;

import com.codecool.hackernews.models.News;
import com.codecool.hackernews.serialization.NewsGsonSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoVendorApi implements NewsDao {
    private static final String API_BASE_URL = "https://api.hnpwa.com/v0/";
    private String endpoint = "top";

    private static NewsDaoVendorApi instance = null;

    private NewsDaoVendorApi(){
    }

    public static NewsDaoVendorApi getInstance(String endpoint){
        if (instance == null){
            instance = new NewsDaoVendorApi();
        }
        instance.setEndpoint(endpoint);
        return instance;
    }

    public String getEndpoint() {
        return endpoint;
    }

    private void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public List<News> read(int page) {
        List<News> newsList = new ArrayList<>();

        String newsJSON = getNewsJSONFromApi(page);

        Type newsListType = new TypeToken<List<News>>() {
        }.getType();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(News.class, new NewsGsonSerializer())
                .serializeNulls()
                .create();

        newsList = gson.fromJson(newsJSON, newsListType);

        return newsList;
    }

    private String getNewsJSONFromApi(int page) {
        StringBuffer responseContent = new StringBuffer();
        try {
            URL url = new URL(API_BASE_URL + endpoint + "/" + page + ".json");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    responseContent.append(inputLine);
                }
            }

            con.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseContent.toString();
    }
}
