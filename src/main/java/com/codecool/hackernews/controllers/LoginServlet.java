package com.codecool.hackernews.controllers;

import com.codecool.hackernews.services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private LoginService loginService;

    @Override
    public void init() {
        loginService = new LoginService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        loginService.handleGET(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        loginService.handlePOSTLogin(request, response);
        doGet(request, response);
    }
}
