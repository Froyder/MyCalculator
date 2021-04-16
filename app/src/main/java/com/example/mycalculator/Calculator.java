package com.example.mycalculator;

import android.media.VolumeShaper;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

    String firstNumber = "", operator = "", secondNumber = "";
    TextView textView;

    int [] numberButtonIds;

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
    }

    private void setNumberButtonListeners() {
        for (int i = 0; i < numberButtonIds.length; i++) {
            int index = i;
            findViewById(numberButtonIds[i]).setOnClickListener(v -> onNumberClick(index));
        }
    }

    private void onNumberClick(int index) {
        String strIndex = String.valueOf(index);
        switch (strIndex) {
            case ("0"):
                if (operator.equals("")) {
                    firstNumber = firstNumber + "0";
                    textView.setText(firstNumber);
                } else {
                    secondNumber = secondNumber + "0";
                    textView.setText(String.format("%s%s%s", firstNumber, operator, secondNumber));
                } break;
            case ("1"):
                if (operator.equals("")) {
                    firstNumber = firstNumber + "1";
                    textView.setText(firstNumber);
                } else {
                    secondNumber = secondNumber + "1";
                    textView.setText(String.format("%s%s%s", firstNumber, operator, secondNumber));
                } break;
            case ("2"):
                if (operator.equals("")) {
                    firstNumber = firstNumber + "2";
                    textView.setText(firstNumber);
                } else {
                    secondNumber = secondNumber + "2";
                    textView.setText(String.format("%s%s%s", firstNumber, operator, secondNumber));
                } break;
            case ("3"):
                if (operator.equals("")) {
                    firstNumber = firstNumber + "3";
                    textView.setText(firstNumber);
                } else {
                    secondNumber = secondNumber + "3";
                    textView.setText(String.format("%s%s%s", firstNumber, operator, secondNumber));
                } break;
            case ("4"):
                if (operator.equals("")) {
                    firstNumber = firstNumber + "4";
                    textView.setText(firstNumber);
                } else {
                    secondNumber = secondNumber + "4";
                    textView.setText(String.format("%s%s%s", firstNumber, operator, secondNumber));
                } break;
            case ("5"):
                if (operator.equals("")) {
                    firstNumber = firstNumber + "5";
                    textView.setText(firstNumber);
                } else {
                    secondNumber = secondNumber + "5";
                    textView.setText(String.format("%s%s%s", firstNumber, operator, secondNumber));
                } break;
            case ("6"):
                if (operator.equals("")) {
                    firstNumber = firstNumber + "6";
                    textView.setText(firstNumber);
                } else {
                    secondNumber = secondNumber + "6";
                    textView.setText(String.format("%s%s%s", firstNumber, operator, secondNumber));
                } break;
            case ("7"):
                if (operator.equals("")) {
                    firstNumber = firstNumber + "7";
                    textView.setText(firstNumber);
                } else {
                    secondNumber = secondNumber + "7";
                    textView.setText(String.format("%s%s%s", firstNumber, operator, secondNumber));
                } break;
            case ("8"):
                if (operator.equals("")) {
                    firstNumber = firstNumber + "8";
                    textView.setText(firstNumber);
                } else {
                    secondNumber = secondNumber + "8";
                    textView.setText(String.format("%s%s%s", firstNumber, operator, secondNumber));
                } break;
            case ("9"):
                if (operator.equals("")) {
                    firstNumber = firstNumber + "9";
                    textView.setText(firstNumber);
                } else {
                    secondNumber = secondNumber + "9";
                    textView.setText(String.format("%s%s%s", firstNumber, operator, secondNumber));
                } break;
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
                firstNumber = firstNumber + ".";
                textView.setText(firstNumber);
            } else {
                secondNumber = secondNumber + ".";
                textView.setText(String.format("%s%s%s", firstNumber, operator, secondNumber));
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

            textView.setText(result);

            if (!result.equals("На ноль делить нельзя!")) {
                firstNumber = result;
                operator = "";
            } secondNumber = "";
        }
    };

}
