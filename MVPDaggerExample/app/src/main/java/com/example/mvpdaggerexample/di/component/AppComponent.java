package com.example.mvpdaggerexample.di.component;

import android.app.Application;
import android.content.Context;

import com.example.mvpdaggerexample.InitApplication;
import com.example.mvpdaggerexample.di.module.AppModule;
import com.example.mvpdaggerexample.di.module.ContextModule;
import com.example.mvpdaggerexample.di.module.DataModule;
import com.example.mvpdaggerexample.model.Model;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, DataModule.class, ContextModule.class})
public interface AppComponent {

    Context getContext();

    Model getFindItemsIterator();
}
