package com.codecool.hackernews.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet(name = "ApiServletBase")
public abstract class ApiServletBase extends HttpServlet {
    protected Integer page = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IllegalArgumentException {
        response.setContentType("application/json");
        readPageParam(request);
        if (page == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "page should be positive integer");
            throw new IllegalArgumentException();
        }
    }

    protected void readPageParam(HttpServletRequest request) {
        String pageParam = request.getParameter("page");
        int defaultPage = 1;
        if (pageParam == null) {
            page = defaultPage;
        } else {
            try {
                page = parseInt(pageParam);
                if (page < 1) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                page = null;
                System.out.println("BAD request:" + request.getRequestURI());
            }
        }
    }
}
