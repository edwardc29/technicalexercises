package com.carrion.edward.data.repository.datasource;

import com.carrion.edward.data.entity.MovieResponseEntity;

import io.reactivex.Observable;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
public interface MovieDataStore {
    Observable<MovieResponseEntity> movieEntityList();
}
