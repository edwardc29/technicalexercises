package com.carrion.edward.app3.di.components;

import android.app.Activity;


import com.carrion.edward.app3.di.PerActivity;
import com.carrion.edward.app3.di.modules.ActivityModule;

import dagger.Component;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
