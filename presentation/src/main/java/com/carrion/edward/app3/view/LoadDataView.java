package com.carrion.edward.app3.view;

import android.content.Context;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
public interface LoadDataView {
    void showLoading();

    void hideLoading();

    void showError(String message);

    Context context();
}
