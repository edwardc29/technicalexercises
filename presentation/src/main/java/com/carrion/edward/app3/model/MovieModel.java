package com.carrion.edward.app3.model;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
public class MovieModel {

    private final int id;
    private String title;
    private int popularity;

    public MovieModel(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
}
