package com.codecool.hackernews.view;

/**
 * Represents a layout class for the webpage
 */
public class Layout {
    private static final String title = "Michael Hackson news";
    public static final String JS_ROOT = "/static/js/";
    public static final String CSS_ROOT = "/static/css/";

    public String getHeader() {
        String header = "<html>\n" +
                "<head>\n" +
                "  <title>" + title + "</title>\n" +
                "  <link rel=\"stylesheet\" type=\"text/css\" href=\"" + CSS_ROOT + "site.css\" />" +
                "  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">" +
                "</head>\n" +
                "<body>\n" +
                "  <div class=\"content\">\n";

        return header;
    }

    public String getFooter() {
        String footer = "  </div>\n" +
                "  <footer>\n" +
                "    <p>Author: Attila Molnár</p>\n" +
                "    <p><a href=\"mailto:attila.molnar@codecool.com\">attila.molnar@codecool.com</a></p>\n" +
                "  </footer>\n" +
                "  <script src=\"https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js\"></script>" +
                "  <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\n" +
                "  <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\n" +
                "  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\" integrity=\"sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI\" crossorigin=\"anonymous\"></script>" +
                "  <script src='" + JS_ROOT + "main.js'></script>" +
                "</body></html>";

        return footer;
    }

    public String getNavBar() {
        String navigation = "<nav class=\"navbar navbar-expand-lg navbar-light bg-ligh\">\n" +
                "  <a class=\"navbar-brand\" href=\"#\">Hackson news</a>\n" +
                "  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
                "    <span class=\"navbar-toggler-icon\"></span>\n" +
                "  </button>" +
                "  <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">" +
                "    <ul class=\"navbar-nav mr-auto\">" +
                "      <li class=\"nav-item active\"><a class=\"nav-link\" href=\"/top?page=1\">Top news</a></li>\n" +
                "      <li class=\"nav-item\"><a class=\"nav-link\" href=\"/newest?page=1\">Newest</a></li>\n" +
                "      <li class=\"nav-item\"><a class=\"nav-link\" href=\"/jobs?page=1\">Jobs</a></li>\n" +
                "      <li class=\"nav-item\"><a class=\"nav-link\" href=\"/login\">Login</a></li>\n" +
                "      <li class=\"nav-item\"><a class=\"nav-link\" href=\"https://learn.code.cool/full-stack/#/\" target=\"_blank\">Curriculum</a></li>\n" +
                "    </ul>" +
                "  </div>" +
                "</nav>";

        return navigation;
    }
}
