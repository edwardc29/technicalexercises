package com.carrion.edward.app3.exception;

import android.content.Context;

import com.carrion.edward.app3.R;
import com.carrion.edward.data.exception.NetworkConnectionException;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
public class ErrorMessageFactory {

    private ErrorMessageFactory() {
        //empty
    }

    /**
     * Creates a String representing an error message.
     *
     * @param context Context needed to retrieve string resources.
     * @param exception An exception used as a condition to retrieve the correct error message.
     * @return {@link String} an error message.
     */
    public static String create(Context context, Exception exception) {
        String message = context.getString(R.string.exception_message_generic);

        if (exception instanceof NetworkConnectionException) {
            message = context.getString(R.string.exception_message_no_connection);
        }

        return message;
    }
}
