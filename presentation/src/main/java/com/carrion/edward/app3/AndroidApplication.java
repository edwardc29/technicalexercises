package com.carrion.edward.app3;

import android.app.Application;

import com.carrion.edward.app3.di.components.ApplicationComponent;
import com.carrion.edward.app3.di.components.DaggerApplicationComponent;
import com.carrion.edward.app3.di.modules.ApplicationModule;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
public class AndroidApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
