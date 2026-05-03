package com.example.internalstorageapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText editTextData;
    Button btnSave, btnRead;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextData = findViewById(R.id.editTextData);
        btnSave = findViewById(R.id.btnSave);
        btnRead = findViewById(R.id.btnRead);
        textViewResult = findViewById(R.id.textViewResult);

        // WRITE DATA
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String data = editTextData.getText().toString();

                try {
                    FileOutputStream fos = openFileOutput("myfile.txt", MODE_PRIVATE);
                    fos.write(data.getBytes());
                    fos.close();

                    Toast.makeText(MainActivity.this, "Data saved!", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error saving data", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        // READ DATA
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    FileInputStream fis = openFileInput("myfile.txt");
                    int i;
                    StringBuilder data = new StringBuilder();

                    while ((i = fis.read()) != -1) {
                        data.append((char) i);
                    }

                    fis.close();

                    textViewResult.setText(data.toString());

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error reading data", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }
}