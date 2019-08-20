package com.carrion.edward.app3.view.activity;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.carrion.edward.app3.AndroidApplication;
import com.carrion.edward.app3.di.components.ApplicationComponent;
import com.carrion.edward.app3.di.modules.ActivityModule;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
public class BaseActivity extends AppCompatActivity {
    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    protected void showAlert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);

        AlertDialog alertDialog = builder.create();

        if (!isFinishing()) {
            alertDialog.show();
        }
    }
}
