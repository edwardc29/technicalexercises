package com.carrion.edward.app3.di.components;

import android.content.Context;

import com.carrion.edward.app3.di.modules.ApplicationModule;
import com.carrion.edward.app3.view.activity.BaseActivity;
import com.carrion.edward.domain.executor.PostExecutionThread;
import com.carrion.edward.domain.executor.ThreadExecutor;
import com.carrion.edward.domain.repository.MovieRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    MovieRepository movieRepository();
}
