package com.carrion.edward.data.net;

import com.carrion.edward.data.entity.MovieResponseEntity;

import io.reactivex.Observable;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
public interface RestApi {
    Observable<MovieResponseEntity> movieEntityList();
}
