package com.codecool.hackernews.models;

public class News {
    private String title;
    private String timeAgo;
    private String author;
    private String url;

    public News(String title, String timeAgo, String author, String url) {
        this.title = title;
        this.timeAgo = timeAgo;
        this.author = author;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimeAgo() {
        return timeAgo;
    }

    public void setTimeAgo(String timeAgo) {
        this.timeAgo = timeAgo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
