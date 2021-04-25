package com.codecool.hackernews.services;

import com.codecool.hackernews.view.Layout;

public class StaticContentService {
    private final Layout layout = new Layout();

    protected String getTop() {
        String header = layout.getHeader();
        String navBar = layout.getNavBar();
        return header + navBar;
    }

    protected String getBottom() {
        return layout.getFooter();
    }
}
