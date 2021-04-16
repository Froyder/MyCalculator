package com.example.mycalculator;

import android.os.Bundle;

import java.util.Objects;

public class MainActivity extends Calculations {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        initButtons();
    }

}
