package com.codecool.hackernews.controllers;

import com.codecool.hackernews.services.IndexService;
import com.codecool.hackernews.view.Layout;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "indexServlet", urlPatterns = {"", "/top", "/jobs", "/newest"}, loadOnStartup = 1)
public class IndexServlet extends HttpServlet {
    private IndexService indexService;

    @Override
    public void init() {
        indexService = new IndexService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        indexService.handleGET(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
