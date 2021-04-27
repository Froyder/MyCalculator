package com.example.mycalculator;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

    private static final int Alt = R.style.Theme_MyCalculatorAlternative;
    private static final int Dark = R.style.Theme_MyCalculatorDark;

    String firstNumber = "", operator = "", secondNumber = "";
    TextView textView;

    int[] numberButtonIds;

    void initButtons() {

        textView = findViewById(R.id.textField);

        numberButtonIds = new int[]{R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3,
                R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9};

        setNumberButtonListeners();

        findViewById(R.id.button_plus).setOnClickListener(buttonPlusClickListener);
        findViewById(R.id.button_minus).setOnClickListener(buttonMinusClickListener);
        findViewById(R.id.button_division).setOnClickListener(buttonDivClickListener);
        findViewById(R.id.button_multiplication).setOnClickListener(buttonMultClickListener);
        findViewById(R.id.button_C).setOnClickListener(buttonCancelClickListener);
        findViewById(R.id.button_dot).setOnClickListener(buttonDotClickListener);
        findViewById(R.id.button_delete).setOnClickListener(buttonDeleteClickListener);
        findViewById(R.id.button_eqls).setOnClickListener(buttonEqlsClickListener);

        findViewById(R.id.theme_button).setOnClickListener(changeTheme);
    }

    public View.OnClickListener changeTheme = v -> {
        SharedPreferences sharedPref = getPreferences(MODE_PRIVATE);
        if (sharedPref.getInt("Theme", Alt) == Alt) {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("Theme", Dark);
            editor.apply();
            recreate();
        } else {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("Theme", Alt);
            editor.apply();
            recreate();
        }
    };

    private void setNumberButtonListeners() {
        for (int i = 0; i < numberButtonIds.length; i++) {
            int index = i;
            findViewById(numberButtonIds[i]).setOnClickListener(v -> onNumberClick(index));
        }
    }

    private void onNumberClick(int index) {
        String strIndex = String.valueOf(index);
        if (operator.equals("")) {
            firstNumber = firstNumber + strIndex;
            textView.setText(firstNumber);
        } else {
            secondNumber = secondNumber + strIndex;
            textView.setText(String.format("%s%s%s", firstNumber, operator, secondNumber));
        }
    }

    public View.OnClickListener buttonPlusClickListener = v -> {
        if (!firstNumber.equals("") && operator.equals("")) {
            operator = "+";
            textView.setText(String.format("%s%s", firstNumber, operator));
        }
    };

    public View.OnClickListener buttonMinusClickListener = v -> {
        if (firstNumber.equals("")) {
            firstNumber = firstNumber + "-";
            textView.setText(firstNumber);
        } else if (operator.equals("")) {
            operator = "-";
            textView.setText(String.format("%s%s", firstNumber, operator));
        }
    };

    public View.OnClickListener buttonMultClickListener = v -> {
        if (!firstNumber.equals("") && operator.equals("")) {
            operator = "*";
            textView.setText(String.format("%s%s", firstNumber, operator));
        }
    };

    public View.OnClickListener buttonDivClickListener = v -> {
        if (!firstNumber.equals("") && operator.equals("")) {
            operator = "/";
            textView.setText(String.format("%s%s", firstNumber, operator));
        }
    };

    public View.OnClickListener buttonDotClickListener = v -> {
        if (operator.equals("")) {
            if (!firstNumber.contains(".")) {
                firstNumber = firstNumber + ".";
                textView.setText(firstNumber);
            }
        } else {
            if (!secondNumber.contains(".")) {
                secondNumber = secondNumber + ".";
                textView.setText(String.format("%s%s%s", firstNumber, operator, secondNumber));
            }
        }
    };

    public View.OnClickListener buttonCancelClickListener = v -> {
        textView.setText("");
        firstNumber = "";
        secondNumber = "";
        operator = "";
    };

    public View.OnClickListener buttonDeleteClickListener = v -> {
        String temp;
        if (!secondNumber.equals("")) {
            temp = secondNumber.substring(0, secondNumber.length() - 1);
            secondNumber = temp;
            textView.setText(String.format("%s%s%s", firstNumber, operator, secondNumber));
        } else if (!operator.equals("")) {
            operator = "";
            textView.setText(firstNumber);
        } else if (!firstNumber.equals("")) {
            temp = firstNumber.substring(0, firstNumber.length() - 1);
            firstNumber = temp;
            textView.setText(firstNumber);
        }
    };

    public View.OnClickListener buttonEqlsClickListener = v -> {
        if (!firstNumber.equals("") && !operator.equals("") && !secondNumber.equals("")) {
            float fN = Float.parseFloat(firstNumber);
            float sN = Float.parseFloat(secondNumber);
            String result = Operations.getResult(fN, operator, sN);

            if (result.endsWith(".0")) {
                result = result.substring(0, result.length() - 2);
            }

            textView.setText(result);

            if (!result.equals("Деление на ноль!")) {
                firstNumber = result;
                operator = "";
            }
            secondNumber = "";
        }
    };

}
