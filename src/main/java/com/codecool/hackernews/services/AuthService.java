package com.codecool.hackernews.services;

import com.codecool.hackernews.models.User;

public class AuthService {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
