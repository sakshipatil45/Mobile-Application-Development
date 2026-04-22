package com.example.calculator;


import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        btnAdd.setOnClickListener(v -> calculate("+"));
        btnSub.setOnClickListener(v -> calculate("-"));
        btnMul.setOnClickListener(v -> calculate("*"));
        btnDiv.setOnClickListener(v -> calculate("/"));
    }

    private void calculate(String op) {

        String n1 = num1.getText().toString();
        String n2 = num2.getText().toString();

        if (n1.isEmpty() || n2.isEmpty()) {
            Toast.makeText(this, "Enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double a = Double.parseDouble(n1);
        double b = Double.parseDouble(n2);
        double res = 0;

        switch (op) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
                res = a * b;
                break;
            case "/":
                if (b == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                res = a / b;
                break;
        }

        result.setText("Result: " + res);
    }
}