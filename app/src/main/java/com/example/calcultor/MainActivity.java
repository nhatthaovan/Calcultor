package com.example.calcultor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private String input, ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.result);

    }

    public void number (View view){
        Button btn = (Button) view;
        String data = btn.getText().toString();
        switch (data) {
            case "CE":
                input = "";
                break;
            case "=":
                calculator();
                ans = input;
                break;
            case "÷":
                calculator();
                input += "/";
                break;
            case "*":
                calculator();
                input += "*";
                break;
            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("+") || data.equals("-")) {
                    calculator();
                }
                input+=data;
        }

        tv.setText(input);

    }

    public void calculator() {
        if (input.split("\\*").length == 2) {
            String number[] = input.split("\\*");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = mul + "";
            } catch (Exception e) {
            }
        }
        if (input.split("\\/").length == 2) {
            String number[] = input.split("\\/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div + "";
            } catch (Exception e) {
            }
        }
        if (input.split("\\+").length == 2) {
            String number[] = input.split("\\+");
            try {
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = sum + "";
            } catch (Exception e) {
            }
        }
        if (input.split("\\-").length == 2) {
            String number[] = input.split("\\-");
            try {
                double sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                input = sub + "";
            } catch (Exception e) {
            }
        }
    }}