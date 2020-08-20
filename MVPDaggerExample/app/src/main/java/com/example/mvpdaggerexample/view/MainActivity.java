package com.example.mvpdaggerexample.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpdaggerexample.InitApplication;
import com.example.mvpdaggerexample.MainContract;
import com.example.mvpdaggerexample.R;
import com.example.mvpdaggerexample.di.component.DaggerActivityComponent;
import com.example.mvpdaggerexample.di.module.MvPModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.ViewCallBack {

    private ProgressBar progressBar;
    private TextView textView;
    private Button button;

    @Inject
    public Context context;

    @Inject
    public MainContract.PresenterCallBack presenterCallBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        DaggerActivityComponent.builder()
                .appComponent(InitApplication.get(this).getAppComponent())
                .mvPModule(new MvPModule(this))
                .build()
        .inject(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenterCallBack.onButtonClick();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterCallBack.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setQuote(String quote) {
        textView.setText(quote);
        Toast.makeText(this, "Quote Updated", Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
    }


}