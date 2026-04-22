package com.example.uicomponentsexp6;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnAlert;
    CheckBox checkBox;
    RadioGroup radioGroup;
    Spinner spinner;
    ToggleButton toggleButton;

    String[] items = {"Select", "Item 1", "Item 2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlert = findViewById(R.id.btnAlert);
        checkBox = findViewById(R.id.checkBox);
        radioGroup = findViewById(R.id.radioGroup);
        spinner = findViewById(R.id.spinner);
        toggleButton = findViewById(R.id.toggleButton);

        // Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                items
        );
        spinner.setAdapter(adapter);

        // Alert Dialog
        btnAlert.setOnClickListener(v -> {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Alert")
                    .setMessage("Working!")
                    .setPositiveButton("OK", null)
                    .show();
        });
    }
}