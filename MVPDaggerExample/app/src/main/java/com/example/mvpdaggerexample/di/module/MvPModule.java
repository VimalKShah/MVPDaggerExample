package com.example.mvpdaggerexample.di.module;

import com.example.mvpdaggerexample.MainContract;
import com.example.mvpdaggerexample.model.Model;
import com.example.mvpdaggerexample.presenter.MainPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class MvPModule {

    private MainContract.ViewCallBack viewCallBack;

    public MvPModule(MainContract.ViewCallBack viewCallBack) {
        this.viewCallBack = viewCallBack;
    }

    @Provides
    public MainContract.ViewCallBack provideViewCallBack() {
        return viewCallBack;
    }

    @Provides
    public MainContract.PresenterCallBack providePresenterCallBack(
            MainContract.ViewCallBack viewCallBack, Model model) {
        return new MainPresenterImpl(viewCallBack, model);
    }
}
