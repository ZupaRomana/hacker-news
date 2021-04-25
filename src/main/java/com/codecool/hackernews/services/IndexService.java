package com.codecool.hackernews.services;

public class IndexService extends BaseService {
    public String getMainContent() {
        return "<div>" +
                "<button type='button' class='btn btn-dark' id='prev'>Prev</button>" +
                "<button type='button' class='btn btn-dark' id='next'>Next</button>" +
                "</div>" + "<div id=\"news\" class=\"d-flex align-content-center flex-wrap mb-3\"></div>";
    }
}
