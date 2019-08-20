package com.carrion.edward.app3.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Edward Carrion
 * @author https://github.com/edwardc29
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {}
