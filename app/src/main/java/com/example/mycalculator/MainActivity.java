package com.example.mycalculator;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CalculatorModel calculator = new CalculatorModel();
    int[] buttonId = new int[] {
            R.id.button_1,
            R.id.button_2,
            R.id.button_3,
            R.id.button_4,
            R.id.button_5,
            R.id.button_6,
            R.id.button_7,
            R.id.button_8,
            R.id.button_9,
            R.id.button_0,
            R.id.button_plus,
            R.id.button_minus,
            R.id.button_div,
            R.id.button_multiply,
            R.id.button_equal,
            R.id.button_sqr,
            R.id.button_cube,
            R.id.button_dot,
            R.id.button_lBracket,
            R.id.button_rBracket,
            R.id.button_clear,
            R.id.button_del,
            R.id.expression,
            R.id.result
    };

    private TextView expression;
    private TextView result;




  public void initElements() {

        expression = findViewById(R.id.expression);
        result = findViewById(R.id.result);

    }

    public void setButtonClickers(){

        for (int i = buttonId.length - 1; i >= 0; i--){
            findViewById(buttonId[i]).setOnClickListener(buttonCalcClick);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initElements();
        setButtonClickers();

        ThemeStorage storage = new ThemeStorage(this);

        ActivityResultLauncher<Intent> settingsLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Theme theme = (Theme) result.getData().getSerializableExtra(ChangeStyle.THEME_RESULT);
                    storage.saveTheme(theme);
                    recreate();
                }

            }
        });

        setTheme(storage.getTheme().getStyle());

        setContentView(R.layout.activity_main);

        findViewById(R.id.button_themechange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsLauncher.launch(ChangeStyle.intent(MainActivity.this, storage.getTheme()));
            }
        });


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


}