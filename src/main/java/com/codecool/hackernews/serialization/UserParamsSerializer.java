package com.codecool.hackernews.serialization;

import com.codecool.hackernews.models.User;

public class UserParamsSerializer {

    public User mapFromParams(String body) {
        String[] fields = body.split("&");
        return new User(fields[0].split("=")[1], fields[1].split("=")[1]);
    }
}
