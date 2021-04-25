package com.codecool.hackernews.services;

import com.codecool.hackernews.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class BaseService implements MainContent {
    protected final StaticContentService staticContentService = new StaticContentService();
    protected final AuthService authService = new AuthService();

    public void handleGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println(staticContentService.getTop());
        out.println(getUser());
        out.println(getMainContent());
        out.println(staticContentService.getBottom());
    }

    protected String getUser() {
        User user = authService.getUser();
        if (user != null) {
            return user.getUsername();
        }
        return "You are not logged";
    }
}
