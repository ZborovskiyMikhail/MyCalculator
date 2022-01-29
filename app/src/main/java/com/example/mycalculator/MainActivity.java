package com.example.mycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonDiv;
    private Button buttonMultiply;
    private Button buttonEqual;
    private Button button1Sqr;
    private Button buttonCube;
    private Button buttonTheme;
    private Button buttonDot;
    private Button buttonLBracket;
    private Button buttonRBracket;
    private Button buttonClear;
    private Button buttonDel;
    private TextView expression;
    private TextView result;

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
        buttonTheme = findViewById(R.id.button_themechange);
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
        buttonMultiply.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonDel.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonLBracket.setOnClickListener(this);
        buttonRBracket.setOnClickListener(this);
        button1Sqr.setOnClickListener(this);
        buttonCube.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonTheme.setOnClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initElements();
        setButtonClickers();

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("SAVE_EXPRESSION", expression.getText().toString());
        outState.putString("SAVE_RESULT",result.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        expression.setText(savedInstanceState.getString("SAVE_EXPRESSION"));
        result.setText(savedInstanceState.getString("SAVE_RESULT"));
    }

    @Override
    public void onClick(View v) {
        String buffer = expression.getText().toString();
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
            case R.id.button_plus:
                expression.append("+");
                break;
            case R.id.button_minus:
                expression.append("-");
                break;
            case R.id.button_div:
                expression.append("/");
                break;
            case R.id.button_multiply:
                expression.append("*");
                break;
            case R.id.button_lBracket:
                expression.append("(");
                break;
            case R.id.button_rBracket:
                expression.append(")");
                break;
            case R.id.button_dot:
                expression.append(".");
                break;
            case R.id.button_clear:
                expression.setText("");
                result.setText("");
                break;
            case R.id.button_del:
                if(buffer.length()>0) {
                buffer = buffer.substring(0, buffer.length() - 1);
                expression.setText(buffer);
                }
                break;
            case R.id.button_equal:
                buffer = buffer.replaceAll("÷","/");
                buffer = buffer.replaceAll("×","*");
                Expression exp = new Expression(buffer);
                String res = String.valueOf(exp.calculate());
                result.setText(res);
                break;
            case R.id.button_sqr:
                buffer = buffer.replaceAll("÷","/");
                buffer = buffer.replaceAll("×","*");
                Expression exp1 = new Expression("("+buffer+")^2");
                String res1 = String.valueOf(exp1.calculate());
                result.setText(res1);
                break;
            case R.id.button_cube:
                buffer = buffer.replaceAll("÷","/");
                buffer = buffer.replaceAll("×","*");
                Expression exp2 = new Expression("("+buffer+")^3");
                String res2 = String.valueOf(exp2.calculate());
                result.setText(res2);
                break;
            case R.id.button_themechange:
                Intent intent = new Intent(MainActivity.this,ChangeStyle.class);
                startActivity(intent);
        }
    }
}