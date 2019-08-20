package com.carrion.edward.app3.di.modules;

import android.app.Activity;

import com.carrion.edward.app3.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }
}
