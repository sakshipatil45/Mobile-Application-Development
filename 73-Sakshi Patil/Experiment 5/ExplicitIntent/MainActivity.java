package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);
        loginBtn = findViewById(R.id.buttonLogin);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                // Demo credentials
                if(user.equals("sakshi") && pass.equals("1234")) {

                    // Open ProfileApp (Different App)
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(
                            "com.example.profileapp",
                            "com.example.profileapp.MainActivity"
                    ));

                    startActivity(intent);

                } else {

                    // Show error inside fields
                    username.setError("Invalid Username");
                    password.setError("Invalid Password");
                }
            }
        });
    }
}