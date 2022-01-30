package com.example.mycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CalculatorModel calculator = new CalculatorModel();
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
        button1.setOnClickListener(buttonCalcClick);
        button2.setOnClickListener(buttonCalcClick);
        button3.setOnClickListener(buttonCalcClick);
        button4.setOnClickListener(buttonCalcClick);
        button5.setOnClickListener(buttonCalcClick);
        button6.setOnClickListener(buttonCalcClick);
        button7.setOnClickListener(buttonCalcClick);
        button8.setOnClickListener(buttonCalcClick);
        button9.setOnClickListener(buttonCalcClick);
        button0.setOnClickListener(buttonCalcClick);
        buttonMultiply.setOnClickListener(buttonCalcClick);
        buttonClear.setOnClickListener(buttonCalcClick);
        buttonDel.setOnClickListener(buttonCalcClick);
        buttonDiv.setOnClickListener(buttonCalcClick);
        buttonDot.setOnClickListener(buttonCalcClick);
        buttonMinus.setOnClickListener(buttonCalcClick);
        buttonPlus.setOnClickListener(buttonCalcClick);
        buttonLBracket.setOnClickListener(buttonCalcClick);
        buttonRBracket.setOnClickListener(buttonCalcClick);
        button1Sqr.setOnClickListener(buttonCalcClick);
        buttonCube.setOnClickListener(buttonCalcClick);
        buttonEqual.setOnClickListener(buttonCalcClick);
        buttonTheme.setOnClickListener(changeTheme);
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

    View.OnClickListener buttonCalcClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            calculator.buttonPressed(v.getId());
            expression.setText(calculator.getExpression());
            result.setText(calculator.getResult());

        }
    };
    View.OnClickListener changeTheme = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,ChangeStyle.class);
            startActivity(intent);
        }
    };

}