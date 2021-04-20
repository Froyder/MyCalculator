package com.example.mycalculator;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.Objects;

public class MainActivity extends Calculator {

    private static final int Alt = R.style.Theme_MyCalculatorAlternative;
    private static final int Dark = R.style.Theme_MyCalculatorDark;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPref = getPreferences(MODE_PRIVATE);
        setTheme(sharedPref.getInt("Theme", Alt));

        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        initButtons();

        findViewById(R.id.theme_button).setOnClickListener(changeTheme);

    }

    public View.OnClickListener changeTheme = v -> {

    //    setTheme(R.style.Theme_MyCalculatorDark);
        SharedPreferences sharedPref = getPreferences(MODE_PRIVATE);

        if (sharedPref.getInt("Theme", Alt) == Alt) {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("Theme", Dark);
            editor.commit();
            recreate();
        } else {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("Theme", Alt);
            editor.commit();
            recreate();
        }
    };

}
