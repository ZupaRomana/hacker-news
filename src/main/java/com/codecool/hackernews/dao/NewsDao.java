package com.codecool.hackernews.dao;

import com.codecool.hackernews.models.News;

import java.util.List;

public interface NewsDao {
    List<News> read(int page);
}
