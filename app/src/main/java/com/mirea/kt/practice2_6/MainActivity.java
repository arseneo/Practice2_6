package com.mirea.kt.practice2_6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String debug = "DEBUG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(debug, "onCreate() called");
        EditText number1EditText = findViewById(R.id.number1EditText);
        EditText number2EditText = findViewById(R.id.number2EditText);
        Button divideButton = findViewById(R.id.divideButton);
        TextView resultTextView = findViewById(R.id.resultTextView);
        TextView nameTextView = findViewById(R.id.nameTextView);
        nameTextView.setText("Корнеев А.П., Вариант 2, РИБО-04-22");
        divideButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Log.i(debug, "Divide button clicked");
                String num1Str = number1EditText.getText().toString();
                String num2Str = number2EditText.getText().toString();
                try {
                    double num1 = Double.parseDouble(num1Str);
                    double num2 = Double.parseDouble(num2Str);
                    if (num2 == 0) {
                        resultTextView.setText("Ошибка: Деление на ноль!");
                        Log.i(debug, "Attempted to divide by zero");
                    } else {
                        double result = num1 / num2;
                        resultTextView.setText(String.valueOf(result));
                        Log.i(debug, "Division performed successfully");
                    }
                } catch (NumberFormatException e) {
                    resultTextView.setText("Ошибка: Неверный формат числа!");
                    Log.i(debug, "Number format exception", e);
                }
            }
        });
    }
}