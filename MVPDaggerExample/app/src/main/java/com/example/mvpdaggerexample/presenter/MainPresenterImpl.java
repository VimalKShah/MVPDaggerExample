package com.example.mvpdaggerexample.presenter;

import com.example.mvpdaggerexample.MainContract;
import com.example.mvpdaggerexample.model.Model;

public class MainPresenterImpl implements MainContract.PresenterCallBack,
        MainContract.ModelCallBacK.OnFinishedListener {

    private MainContract.ViewCallBack viewCallBack;
    private Model model;

    public MainPresenterImpl(MainContract.ViewCallBack viewCallBack, Model model) {
        this.viewCallBack = viewCallBack;
        this.model = model;
    }

    @Override
    public void onFinished(String string) {
        if(viewCallBack != null) {
            viewCallBack.setQuote(string);
            viewCallBack.hideProgress();
        }
    }

    @Override
    public void onButtonClick() {
        if(viewCallBack != null) {
            viewCallBack.showProgress();
        }
        model.getNextQuote(this);
    }

    @Override
    public void onDestroy() {
        viewCallBack = null;
    }
}
