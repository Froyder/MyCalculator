package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button zero, one, two, three, four, five, six, seven, eight, nine,
            plus, minus, mult, div, cancel, delete, dot, eqls;
    TextView textView;

    String firstNumber, operator, secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        initView();

    }

    public void initView() {

        firstNumber = "";
        secondNumber = "";
        operator = "";

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

        //editText = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textField);

        one.setOnClickListener(button1ClickListener);
        two.setOnClickListener(button2ClickListener);
        three.setOnClickListener(button3ClickListener);
        four.setOnClickListener(button4ClickListener);
        five.setOnClickListener(button5ClickListener);
        six.setOnClickListener(button6ClickListener);
        seven.setOnClickListener(button7ClickListener);
        eight.setOnClickListener(button8ClickListener);
        nine.setOnClickListener(button9ClickListener);
        zero.setOnClickListener(button0ClickListener);

        plus.setOnClickListener(buttonPlusClickListener);
        minus.setOnClickListener(buttonMinusClickListener);
        mult.setOnClickListener(buttonMultClickListener);
        eqls.setOnClickListener(buttonEqlsClickListener);
        div.setOnClickListener(buttonDivClickListener);
        cancel.setOnClickListener(buttonCancelClickListener);
        dot.setOnClickListener(buttonDotClickListener);
        delete.setOnClickListener(buttonDeleteClickListener);

    }

    public View.OnClickListener button1ClickListener = v -> {
        if (operator.equals("")) {
            firstNumber = firstNumber + "1";
            textView.setText(firstNumber);
        } else {
            secondNumber = secondNumber + "1";
            textView.setText(firstNumber + operator + secondNumber);
        }
    };

    public View.OnClickListener button2ClickListener = v -> {
        if (operator.equals("")) {
            firstNumber = firstNumber + "2";
            textView.setText(firstNumber);
        } else {
            secondNumber = secondNumber + "2";
            textView.setText(firstNumber + operator + secondNumber);
        }
    };

    public View.OnClickListener button3ClickListener = v -> {
        if (operator.equals("")) {
            firstNumber = firstNumber + "3";
            textView.setText(firstNumber);
        } else {
            secondNumber = secondNumber + "3";
            textView.setText(firstNumber + operator + secondNumber);
        }
    };

    public View.OnClickListener button4ClickListener = v -> {
        if (operator.equals("")) {
            firstNumber = firstNumber + "4";
            textView.setText(firstNumber);
        } else {
            secondNumber = secondNumber + "4";
            textView.setText(firstNumber + operator + secondNumber);
        }
    };

    public View.OnClickListener button5ClickListener = v -> {
        if (operator.equals("")) {
            firstNumber = firstNumber + "5";
            textView.setText(firstNumber);
        } else {
            secondNumber = secondNumber + "5";
            textView.setText(firstNumber + operator + secondNumber);
        }
    };

    public View.OnClickListener button6ClickListener = v -> {
        if (operator.equals("")) {
            firstNumber = firstNumber + "6";
            textView.setText(firstNumber);
        } else {
            secondNumber = secondNumber + "6";
            textView.setText(firstNumber + operator + secondNumber);
        }
    };

    public View.OnClickListener button7ClickListener = v -> {
        if (operator.equals("")) {
            firstNumber = firstNumber + "7";
            textView.setText(firstNumber);
        } else {
            secondNumber = secondNumber + "7";
            textView.setText(firstNumber + operator + secondNumber);
        }
    };

    public View.OnClickListener button8ClickListener = v -> {
        if (operator.equals("")) {
            firstNumber = firstNumber + "8";
            textView.setText(firstNumber);
        } else {
            secondNumber = secondNumber + "8";
            textView.setText(firstNumber + operator + secondNumber);
        }
    };

    public View.OnClickListener button9ClickListener = v -> {
        if (operator.equals("")) {
            firstNumber = firstNumber + "9";
            textView.setText(firstNumber);
        } else {
            secondNumber = secondNumber + "9";
            textView.setText(firstNumber + operator + secondNumber);
        }
    };

    public View.OnClickListener button0ClickListener = v -> {
        if (operator.equals("")) {
            firstNumber = firstNumber + "0";
            textView.setText(firstNumber);
        } else {
            secondNumber = secondNumber + "0";
            textView.setText(firstNumber + operator + secondNumber);
        }
    };

    public View.OnClickListener buttonDotClickListener = v -> {
        if (operator.equals("")) {
            firstNumber = firstNumber + ".";
            textView.setText(firstNumber);
        } else {
            secondNumber = secondNumber + ".";
            textView.setText(firstNumber + operator + secondNumber);
        }
    };
    public View.OnClickListener buttonPlusClickListener = v -> {
        if (!firstNumber.equals("") && operator.equals("")) {
            operator = "+";
            textView.setText(firstNumber + operator);
        } else {
        }
    };
    public View.OnClickListener buttonMinusClickListener = v -> {
        if (firstNumber.equals("")) {
            firstNumber = firstNumber + "-";
            textView.setText(firstNumber);
        } else if (!firstNumber.equals("") && operator.equals("")) {
            operator = "-";
            textView.setText(firstNumber + operator);
        } else {
        }
    };

    public View.OnClickListener buttonMultClickListener = v -> {
        if (!firstNumber.equals("") && operator.equals("")) {
            operator = "*";
            textView.setText(firstNumber + operator);
        } else {
        }
    };
    public View.OnClickListener buttonDivClickListener = v -> {
        if (!firstNumber.equals("") && operator.equals("")) {
            operator = "/";
            textView.setText(firstNumber + operator);
        } else {
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
            textView.setText(firstNumber + operator + secondNumber);
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
            String result;

            switch (operator) {
                case "+":
                    result = (Float.toString(fN + sN));
                    textView.setText(result);
                    firstNumber = result;
                    break;
                case "-":
                    result = (Float.toString(fN - sN));
                    textView.setText(result);
                    firstNumber = result;
                    break;
                case "*":
                    result = (Float.toString(fN * sN));
                    textView.setText(result);
                    firstNumber = result;
                    break;
                case "/":
                    result = (Float.toString(fN / sN));
                    textView.setText(result);
                    firstNumber = result;
                    break;
            }
        }
        secondNumber = "";
        operator = "";

    };

}
