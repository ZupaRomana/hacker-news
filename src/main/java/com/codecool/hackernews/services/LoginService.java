package com.codecool.hackernews.services;

import com.codecool.hackernews.serialization.UserParamsSerializer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginService extends BaseService {
    private final UserParamsSerializer userSerializer = new UserParamsSerializer();

    public String getMainContent() {
        return "<div>" +
                "<form method='POST'>" +
                "<input type='text' id='username' name='username'>" +
                "<input type='password' id='password' name='password'>" +
                "<button type='submit'>SUBMIT</button>" +
                "</form>" +
                "</div>";
    }

    public void handlePOSTLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String body = request.getReader().readLine();
        authService.setUser(userSerializer.mapFromParams(body));
    }
}
