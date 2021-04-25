package com.codecool.hackernews.controllers;

import com.codecool.hackernews.services.LoginService;
import com.codecool.hackernews.services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class ProductsServlet extends HttpServlet {
    private ProductService productService;

    @Override
    public void init() {
        productService = new ProductService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productService.handlePOST(request, response);
        doGet(request, response);
    }
}
