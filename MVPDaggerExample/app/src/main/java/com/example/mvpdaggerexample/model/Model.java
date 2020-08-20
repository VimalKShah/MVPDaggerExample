package com.example.mvpdaggerexample.model;

import com.example.mvpdaggerexample.MainContract;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Model implements MainContract.ModelCallBacK {

    private List<String> arrayList = Arrays.asList(
            "Be yourself. everyone else is already taken.",
            "A room without books is like a body without a soul.",
            "You only live once, but if you do it right, once is enough.",
            "Be the change that you wish to see in the world.",
            "If you tell the truth, you don't have to remember anything."
    );

    @Override
    public void getNextQuote(OnFinishedListener onFinishedListener) {
        onFinishedListener.onFinished(getRandomQuote());
    }

    private String getRandomQuote() {
        Random random = new Random();
        int num = random.nextInt(arrayList.size());
        return arrayList.get(num);
    }
}
