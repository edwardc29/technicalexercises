package com.carrion.edward.app3.mapper;

import com.carrion.edward.app3.di.PerActivity;
import com.carrion.edward.app3.model.MovieModel;
import com.carrion.edward.domain.Movie;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
@PerActivity
public class MovieModelDataMapper {

    @Inject
    public MovieModelDataMapper() {
    }

    private MovieModel transform(Movie movie) {
        if (movie == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final MovieModel movieModel = new MovieModel(movie.getId());
        movieModel.setTitle(movie.getTitle());
        movieModel.setPopularity(movie.getPopularity());

        return movieModel;
    }

    public List<MovieModel> transform(List<Movie> movieList) {
        List<MovieModel> movieModelsCollection;

        if (movieList != null && !movieList.isEmpty()) {
            movieModelsCollection = new ArrayList<>();
            for (Movie movie : movieList) {
                movieModelsCollection.add(transform(movie));
            }
        } else {
            movieModelsCollection = new ArrayList<>();
        }

        return movieModelsCollection;
    }
}
