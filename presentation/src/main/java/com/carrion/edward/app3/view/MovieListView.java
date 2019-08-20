package com.carrion.edward.app3.view;

import com.carrion.edward.app3.model.MovieModel;

import java.util.List;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
public interface MovieListView extends LoadDataView {
    void renderMovieList(List<MovieModel> movieModelCollection);
}