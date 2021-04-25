package com.codecool.hackernews.services;

import com.codecool.hackernews.serialization.UserParamsSerializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductService extends BaseService {

    public String getMainContent() {
        return "PRODUTS";
    }

    public void handlePOST(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String body = request.getReader().readLine();
//        authService.setUser(userSerializer.mapFromParams(body));
    }
}
