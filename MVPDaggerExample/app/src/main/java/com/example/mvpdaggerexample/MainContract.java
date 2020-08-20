package com.example.mvpdaggerexample;

public interface MainContract {

    public interface ModelCallBacK {

        interface OnFinishedListener {
            void onFinished(String string);
        }

        void getNextQuote(OnFinishedListener onFinishedListener);
    }

    public interface ViewCallBack {
        void showProgress();

        void hideProgress();

        void setQuote(String quote);
    }

    public interface PresenterCallBack {
        void onButtonClick();

        void onDestroy();
    }
}
