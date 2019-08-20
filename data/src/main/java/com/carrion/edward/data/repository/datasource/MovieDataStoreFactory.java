package com.carrion.edward.data.repository.datasource;

import android.content.Context;

import androidx.annotation.NonNull;

import com.carrion.edward.data.entity.mapper.MovieEntityJsonMapper;
import com.carrion.edward.data.net.RestApi;
import com.carrion.edward.data.net.RestApiImpl;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
@Singleton
public class MovieDataStoreFactory {

    private final Context context;

    @Inject
    MovieDataStoreFactory(@NonNull Context context) {
        this.context = context.getApplicationContext();
    }

    public MovieDataStore create(int userId) {
        MovieDataStore movieDataStore;

        //Validate if disk or cloud
        movieDataStore = createCloudDataStore();

        return movieDataStore;
    }

    public MovieDataStore createCloudDataStore() {
        final MovieEntityJsonMapper movieEntityJsonMapper = new MovieEntityJsonMapper();
        final RestApi restApi = new RestApiImpl(this.context, movieEntityJsonMapper);

        return new CloudMovieDataStore(restApi);
    }
}
