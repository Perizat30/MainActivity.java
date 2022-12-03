package com.example.lesson7;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Integer firstValue = 0;
    private Integer secondValue = 0;
    private Integer result = 0;
    private TextView tvResult;
    private Button btnOne, btnTwo, btnPlus, btnEqual, btnClear;
    private Button btnThree, btnFour, btnFive, btnSix, btnMinus;
    private Button btnSeven, btnEight, btnNine, btnMultiply, btnDivide, btnZero;
    private boolean shouldSetFirstValue = true;
    private Operation operation = Operation.NONE;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tv_result);
        btnOne = findViewById(R.id.btn_one);
        btnTwo = findViewById(R.id.btn_two);
        btnThree = findViewById(R.id.btn_three);
        btnFour = findViewById(R.id.btn_four);
        btnFive = findViewById(R.id.btn_five);
        btnSix = findViewById(R.id.btn_six);
        btnSeven = findViewById(R.id.btn_seven);
        btnEight = findViewById(R.id.btn_eight);
        btnNine = findViewById(R.id.btn_nine);
        btnZero = findViewById(R.id.btn_zero);

        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnDivide = findViewById(R.id.btn_divide);
        btnEqual = findViewById(R.id.btn_equal);
        btnClear = findViewById(R.id.btn_clear);
        calculatedNew();
    }

    @SuppressLint("SetTextI18n")
    public void calculateNumber(Integer number) {
        if (shouldSetFirstValue) {
            if (firstValue.equals(0)) firstValue = number;
            else firstValue = Integer.valueOf(firstValue + number.toString());
            tvResult.setText(firstValue.toString());
        } else {
            if (secondValue.equals(0)) secondValue = number;
            else secondValue = Integer.valueOf(secondValue + number.toString());
            tvResult.setText(secondValue.toString());
        }
    }

    @SuppressLint("SetTextI18n")
    public void calculatedNew() {
        btnOne.setOnClickListener(v -> calculateNumber(1));
        btnTwo.setOnClickListener(v -> calculateNumber(2));
        btnThree.setOnClickListener(v -> calculateNumber(3));
        btnFour.setOnClickListener(v -> calculateNumber(4));
        btnFive.setOnClickListener(v -> calculateNumber(5));
        btnSix.setOnClickListener(v -> calculateNumber(6));
        btnSeven.setOnClickListener(v -> calculateNumber(7));
        btnEight.setOnClickListener(v -> calculateNumber(8));
        btnNine.setOnClickListener(v -> calculateNumber(9));
        btnZero.setOnClickListener(v -> calculateNumber(0));

        btnDivide.setOnClickListener(v -> {

            operation = Operation.DIVISION;
            shouldSetFirstValue = false;

        });
        btnMultiply.setOnClickListener(v -> {

            operation = Operation.MULTIPLICATION;
            shouldSetFirstValue = false;

        });

        btnClear.setOnClickListener(v -> {
            firstValue = 0;
            secondValue = 0;
            tvResult.setText("0");
            result = 0;
        });

        btnEqual.setOnClickListener(v -> {
            if (operation == Operation.ADDITION) {
                result = firstValue + secondValue;
                operation = Operation.NONE;

            } else if (operation == Operation.SUBTRACTION) {
                result = firstValue - secondValue;
                operation = Operation.NONE;
            } else if (operation == Operation.MULTIPLICATION) {
                result = firstValue * secondValue;
                operation = Operation.NONE;
            } else if (operation == Operation.DIVISION) {
                result = firstValue / secondValue;
                operation = Operation.NONE;
            }
            tvResult.setText(result.toString());
            firstValue = result;
            secondValue = 0;
            shouldSetFirstValue = false;
        });

        btnMinus.setOnClickListener(view -> {

            operation = Operation.SUBTRACTION;
            shouldSetFirstValue = false;

        });
        btnPlus.setOnClickListener(v -> {
            operation = Operation.ADDITION;
            shouldSetFirstValue = false;

        });

    }
}



