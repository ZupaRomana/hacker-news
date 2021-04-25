package com.codecool.hackernews.controllers;

import com.codecool.hackernews.dao.NewsDao;
import com.codecool.hackernews.dao.NewsDaoVendorApi;
import com.codecool.hackernews.models.News;
import com.codecool.hackernews.serialization.NewsGsonSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "jobsServlet", urlPatterns = {"/api/jobs"})
public class JobsServlet extends ApiServletBase {
    private final String endpoint = "jobs";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            super.doGet(request, response);
        } catch (IllegalArgumentException e) {
            return;
        }
        NewsDao newsDao = NewsDaoVendorApi.getInstance(endpoint);
        List<News> newsList = newsDao.read(page);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(News.class, new NewsGsonSerializer())
                .serializeNulls()
                .create();

        PrintWriter out = response.getWriter();
        out.println(gson.toJson(newsList));
    }
}
