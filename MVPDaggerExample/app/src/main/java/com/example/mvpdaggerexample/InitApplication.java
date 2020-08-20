package com.example.mvpdaggerexample;

import android.app.Application;
import android.content.Context;

import com.example.mvpdaggerexample.di.component.AppComponent;
import com.example.mvpdaggerexample.di.component.DaggerAppComponent;
import com.example.mvpdaggerexample.di.module.AppModule;
import com.example.mvpdaggerexample.di.module.ContextModule;
import com.example.mvpdaggerexample.di.module.DataModule;

public class InitApplication extends Application {

    private AppComponent appComponent;

    public static InitApplication get(Context context) {
        return (InitApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .dataModule(new DataModule())
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
