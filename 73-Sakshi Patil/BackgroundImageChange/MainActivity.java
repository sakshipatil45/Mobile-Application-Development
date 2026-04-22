package com.example.bgimageapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView bgImage;
    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bgImage = findViewById(R.id.bgImage);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(v ->
                bgImage.setImageResource(R.drawable.image1));

        btn2.setOnClickListener(v ->
                bgImage.setImageResource(R.drawable.image2));

        btn3.setOnClickListener(v ->
                bgImage.setImageResource(R.drawable.image3));
    }
}