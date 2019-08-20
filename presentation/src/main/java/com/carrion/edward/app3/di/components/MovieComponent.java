package com.carrion.edward.app3.di.components;

import com.carrion.edward.app3.di.PerActivity;
import com.carrion.edward.app3.di.modules.ActivityModule;
import com.carrion.edward.app3.di.modules.MovieModule;
import com.carrion.edward.app3.view.activity.MovieLisActivity;

import dagger.Component;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, MovieModule.class})
public interface MovieComponent extends ActivityComponent {
    void inject(MovieLisActivity movieLisActivity);
}
