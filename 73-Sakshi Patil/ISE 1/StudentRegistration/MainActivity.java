package com.example.studentregistration;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etClass, etMobile;
    Button btnAdd, btnSubmit;
    TextView tvMessage;

    ArrayList<String> studentList = new ArrayList<>();
    ArrayList<String> mobileList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etClass = findViewById(R.id.etClass);
        etMobile = findViewById(R.id.etMobile);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvMessage = findViewById(R.id.tvMessage);

        btnAdd.setOnClickListener(view -> {

            String name = etName.getText().toString();
            String mobile = etMobile.getText().toString();
            String email = etEmail.getText().toString();
            String sclass = etClass.getText().toString();


            if(name.isEmpty() || mobile.isEmpty() || email.isEmpty() || sclass.isEmpty()){
                tvMessage.setText("Enter All Required Fields");
            } else {
                studentList.add(name);
                mobileList.add(mobile);

                tvMessage.setText("Student Added Successfully !!");


                etName.setText("");
                etEmail.setText("");
                etClass.setText("");
                etMobile.setText("");
            }
        });

        btnSubmit.setOnClickListener(view -> {

            if(studentList.isEmpty()){
                tvMessage.setText("No Students Added");
                return;
            }

            Intent intent = new Intent();
            intent.setClassName(
                    "com.example.studentlistapp",
                    "com.example.studentlistapp.MainActivity"
            );

            intent.putStringArrayListExtra("names", studentList);
            intent.putStringArrayListExtra("mobiles", mobileList);

            startActivity(intent);
        });
    }
}