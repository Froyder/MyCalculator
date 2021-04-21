package com.example.mycalculator;

public class Operations{

    public static String getResult (float fN, String operator, float sN) {

        switch (operator) {
            case "+":
                return (Float.toString(fN + sN));
            case "-":
                return (Float.toString(fN - sN));
            case "*":
                return (Float.toString(fN * sN));
            case "/":
                if (sN == 0) {
                    return ("Деление на ноль!");
                } else {
                    return (Float.toString(fN / sN));
                }
        } return "";

    }

}
