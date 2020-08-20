package com.example.mvpdaggerexample.di.module;

import com.example.mvpdaggerexample.InitApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private InitApplication initApplication;

    public AppModule(InitApplication initApplication) {
        this.initApplication = initApplication;
    }

    @Provides
    @Singleton
    public  InitApplication provideInitApplication() {
        return initApplication;
    }
}
