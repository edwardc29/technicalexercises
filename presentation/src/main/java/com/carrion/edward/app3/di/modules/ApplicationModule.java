package com.carrion.edward.app3.di.modules;

import android.content.Context;

import com.carrion.edward.app3.AndroidApplication;
import com.carrion.edward.app3.UIThread;
import com.carrion.edward.data.executor.JobExecutor;
import com.carrion.edward.data.repository.MovieDataRepository;
import com.carrion.edward.domain.executor.PostExecutionThread;
import com.carrion.edward.domain.executor.ThreadExecutor;
import com.carrion.edward.domain.repository.MovieRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    MovieRepository provideMovieRepository(MovieDataRepository movieDataRepository) {
        return movieDataRepository;
    }

}
