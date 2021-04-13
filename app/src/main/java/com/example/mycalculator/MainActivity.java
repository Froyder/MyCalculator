package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

        Button zero, one, two, three, four, five, six, seven, eight, nine,
                plus, minus, mult, div, cancel, delete, dot, eqls;
        EditText editText;

        String firstNumber, operator, secondNumber, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    public void initView () {
        firstNumber = "";
        secondNumber = "";
        operator = "";
        result = "";

        zero = findViewById(R.id.button_0);
        one = findViewById(R.id.button_1);
        two = findViewById(R.id.button_2);
        three = findViewById(R.id.button_3);
        four = findViewById(R.id.button_4);
        five = findViewById(R.id.button_5);
        six = findViewById(R.id.button_6);
        seven = findViewById(R.id.button_7);
        eight = findViewById(R.id.button_8);
        nine = findViewById(R.id.button_9);
        plus = findViewById(R.id.button_plus);
        minus = findViewById(R.id.button_minus);
        mult = findViewById(R.id.button_multiplication);
        div = findViewById(R.id.button_division);
        eqls = findViewById(R.id.button_eqls);
        cancel = findViewById(R.id.button_C);
        dot = findViewById(R.id.button_dot);
        delete = findViewById(R.id.button_delete);

        editText = findViewById(R.id.editTextNumber);

        four.setOnClickListener(button4ClickListener);
        five.setOnClickListener(button5ClickListener);

        plus.setOnClickListener(buttonPlusClickListener);
        minus.setOnClickListener(buttonMinusClickListener);
        mult.setOnClickListener(buttonMultClickListener);
        eqls.setOnClickListener(buttonEqlsClickListener);
        div.setOnClickListener(buttonDivClickListener);
        cancel.setOnClickListener(buttonCancelClickListener);
        dot.setOnClickListener(buttonDotClickListener);
        delete.setOnClickListener(buttonDeleteClickListener);

    }

    public View.OnClickListener button4ClickListener = v -> {
        if (operator.equals("")) {
            firstNumber = firstNumber + "4";
            editText.setText(firstNumber);
        } else {
            secondNumber = secondNumber + "4";
            editText.setText(firstNumber + operator + secondNumber);
        }
    };

    public View.OnClickListener button5ClickListener = v -> {
        if (operator.equals("")) {
            firstNumber = firstNumber + "5";
            editText.setText(firstNumber);
        } else {
            secondNumber = secondNumber + "5";
            editText.setText(firstNumber + operator + secondNumber);
        }
    };

    public View.OnClickListener buttonDotClickListener = v -> {
        if (operator.equals("")) {
            firstNumber = firstNumber + ".";
            editText.setText(firstNumber);
        } else {
            secondNumber = secondNumber + ".";
            editText.setText(firstNumber + operator + secondNumber);
        }
    };

    public View.OnClickListener buttonPlusClickListener = v -> {
        if (!firstNumber.equals("") && operator.equals("")) {
            operator = "+";
            editText.setText(firstNumber + operator);
        } else {
        }
    };

    public View.OnClickListener buttonMinusClickListener = v -> {
        if (!firstNumber.equals("") && operator.equals("")) {
            operator = "-";
            editText.setText(firstNumber + operator);
        } else {
        }
    };

    public View.OnClickListener buttonMultClickListener = v -> {
        if (!firstNumber.equals("") && operator.equals("")) {
            operator = "*";
            editText.setText(firstNumber + operator);
        } else {
        }
    };

    public View.OnClickListener buttonDivClickListener = v -> {
        if (!firstNumber.equals("") && operator.equals("")) {
            operator = "/";
            editText.setText(firstNumber + operator);
        } else {
        }
    };

    public View.OnClickListener buttonCancelClickListener = v -> {
            editText.setText("");
            firstNumber = "";
            secondNumber = "";
            operator = "";
    };

    public View.OnClickListener buttonDeleteClickListener = v -> {
        String temp;

        if (!secondNumber.equals("")) {
            temp = secondNumber.substring(0, secondNumber.length()-1);
            secondNumber = temp;
            editText.setText(firstNumber + operator + secondNumber);
        } else if (!operator.equals("")) {
            operator = "";
            editText.setText(firstNumber);
        } else if (!firstNumber.equals("")) {
            temp = firstNumber.substring(0, firstNumber.length()-1);
            firstNumber = temp;
            editText.setText(firstNumber);
        }
    };

    public View.OnClickListener buttonEqlsClickListener = v -> {

        if (!firstNumber.equals("") && !operator.equals("") && !secondNumber.equals("")) {
            float fN = Float.parseFloat(firstNumber);
            float sN = Float.parseFloat(secondNumber);
            String result;

            switch (operator) {
                case "+":
                    result = (Float.toString(fN + sN));
                    editText.setText(result);
                    firstNumber = result;
                    break;
                case "-":
                    result = (Float.toString(fN - sN));
                    editText.setText(result);
                    firstNumber = result;
                    break;
                case "*":
                    result = (Float.toString(fN * sN));
                    editText.setText(result);
                    firstNumber = result;
                    break;
                case "/":
                    result = (Float.toString(fN / sN));
                    editText.setText(result);
                    firstNumber = result;
                    break;
            }
        }
        secondNumber = "";
        operator = "";

    };
}
