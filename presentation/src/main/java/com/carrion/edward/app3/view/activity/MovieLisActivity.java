package com.carrion.edward.app3.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.carrion.edward.app3.R;
import com.carrion.edward.app3.databinding.ActivityMainBinding;
import com.carrion.edward.app3.di.HasComponent;
import com.carrion.edward.app3.di.components.DaggerMovieComponent;
import com.carrion.edward.app3.di.components.MovieComponent;
import com.carrion.edward.app3.model.MovieModel;
import com.carrion.edward.app3.presenter.MovieListPresenter;
import com.carrion.edward.app3.view.MovieListView;
import com.carrion.edward.app3.view.adapter.MoviesAdapter;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
public class MovieLisActivity extends BaseActivity implements HasComponent<MovieComponent>, MovieListView {
    private MovieComponent movieComponent;

    @Inject
    MovieListPresenter movieListPresenter;

    @Inject
    MoviesAdapter moviesAdapter;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initializeInjector();
        movieComponent.inject(this);
        movieListPresenter.setView(this);
        movieListPresenter.initialize();

        binding.rvMovies.setHasFixedSize(true);
        binding.rvMovies.setAdapter(moviesAdapter);
    }

    private void initializeInjector() {
        this.movieComponent = DaggerMovieComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public MovieComponent getComponent() {
        return movieComponent;
    }

    @Override
    public void renderMovieList(List<MovieModel> movieList) {
        binding.rvMovies.setVisibility(View.VISIBLE);
        moviesAdapter.setMoviesList(movieList);
        moviesAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {
        binding.pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        binding.pb.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        showAlert(message);
    }

    @Override
    public Context context() {
        return getApplicationContext();
    }
}
