package com.example.mvpdaggerexample.di.component;

import com.example.mvpdaggerexample.view.MainActivity;
import com.example.mvpdaggerexample.MainContract;
import com.example.mvpdaggerexample.di.module.MvPModule;
import com.example.mvpdaggerexample.di.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = {MvPModule.class}, dependencies = {AppComponent.class})
public interface ActivityComponent {
    void inject(MainActivity mainActivity);

    MainContract.PresenterCallBack getMainPresenter();
}
