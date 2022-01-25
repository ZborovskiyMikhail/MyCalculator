package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;
    Button buttonPlus;
    Button buttonMinus;
    Button buttonDiv;
    Button buttonMultiply;
    Button buttonEqual;
    Button button1Sqr;
    Button buttonCube;
    Button buttonPercent;
    Button buttonDot;
    Button buttonLBracket;
    Button buttonRBracket;
    Button buttonClear;
    Button buttonDel;
    TextView expression;
    TextView result;

    public void initElements() {
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        button0 = findViewById(R.id.button_0);
        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        buttonDiv = findViewById(R.id.button_div);
        buttonMultiply = findViewById(R.id.button_multiply);
        buttonEqual = findViewById(R.id.button_equal);
        button1Sqr = findViewById(R.id.button_sqr);
        buttonCube = findViewById(R.id.button_cube);
        buttonPercent = findViewById(R.id.button_percent);
        buttonDot = findViewById(R.id.button_dot);
        buttonLBracket = findViewById(R.id.button_lBracket);
        buttonRBracket = findViewById(R.id.button_rBracket);
        buttonClear = findViewById(R.id.button_clear);
        buttonDel = findViewById(R.id.button_del);
        expression = findViewById(R.id.expression);
        result = findViewById(R.id.result);

    }
    public void setButtonClickers(){
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initElements();
        setButtonClickers();

    }

    @Override
    public void onClick(View v) {
    switch (v.getId())
    {
        case R.id.button_1:
            expression.append("1");
            break;
        case R.id.button_2:
            expression.append("2");
            break;
        case R.id.button_3:
            expression.append("3");
            break;
        case R.id.button_4:
            expression.append("4");
            break;
        case R.id.button_5:
            expression.append("5");
            break;
        case R.id.button_6:
            expression.append("6");
            break;
        case R.id.button_7:
            expression.append("7");
            break;
        case R.id.button_8:
            expression.append("8");
            break;
        case R.id.button_9:
            expression.append("9");
            break;
        case R.id.button_0:
            expression.append("0");
            break;




    }
    }
}