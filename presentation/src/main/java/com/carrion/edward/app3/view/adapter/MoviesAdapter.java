package com.carrion.edward.app3.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.carrion.edward.app3.R;
import com.carrion.edward.app3.databinding.ItemMovieBinding;
import com.carrion.edward.app3.model.MovieModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {
    private List<MovieModel> movieList;

    @Inject
    MoviesAdapter() {
        movieList = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemMovieBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_movie, parent, false);
        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, final int position) {
        holder.onBind(movieList.get(position));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setMoviesList(List<MovieModel> movieList) {
        this.movieList = movieList;
        this.notifyDataSetChanged();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        private final ItemMovieBinding binding;

        MovieViewHolder(ItemMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void onBind(MovieModel movieModel) {
            binding.setMovieModel(movieModel);
        }
    }
}
