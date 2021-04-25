package com.codecool.hackernews.serialization;

import com.codecool.hackernews.models.News;
import com.google.gson.*;

import java.lang.reflect.Type;

public class NewsGsonSerializer implements JsonSerializer<News>, JsonDeserializer<News> {
    public static final String HACKER_NEWS_URL = "https://news.ycombinator.com/";

    @Override
    public JsonElement serialize(News news, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();

        result.addProperty("title", news.getTitle());
        result.addProperty("timeAgo", news.getTimeAgo());
        String author = news.getAuthor();
        if (author == null) {
            author = "";
        }
        result.addProperty("author", author);
        result.addProperty("url", news.getUrl());

        return result;
    }

    @Override
    public News deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        String url = jsonObject.get("url").getAsString();
        if (!url.startsWith("https")){
            url = HACKER_NEWS_URL + url;
        }
        JsonElement userElement = jsonObject.get("user");
        String user = (userElement.isJsonNull()) ? "" : userElement.getAsString();

        return new News(jsonObject.get("title").getAsString(),
                jsonObject.get("time_ago").getAsString(),
                user,
                url);
    }
}
