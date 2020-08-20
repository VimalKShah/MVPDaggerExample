package com.example.mvpdaggerexample.di.module;

import com.example.mvpdaggerexample.model.Model;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    public Model provideModel() {
        return new Model();
    }
}
