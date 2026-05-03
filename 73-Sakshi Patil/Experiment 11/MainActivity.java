package com.example.sqliteapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editName, editAge;
    Button btnInsert, btnView;
    TextView textViewData;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editAge = findViewById(R.id.editAge);
        btnInsert = findViewById(R.id.btnInsert);
        btnView = findViewById(R.id.btnView);
        textViewData = findViewById(R.id.textViewData);

        db = new DBHelper(this);

        // INSERT DATA
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editName.getText().toString();
                String age = editAge.getText().toString();

                boolean result = db.insertData(name, age);

                if (result)
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Insertion Failed", Toast.LENGTH_SHORT).show();
            }
        });

        // DISPLAY DATA
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor = db.getData();

                if (cursor.getCount() == 0) {
                    textViewData.setText("No Data Found");
                    return;
                }

                StringBuilder buffer = new StringBuilder();

                while (cursor.moveToNext()) {
                    buffer.append("ID: ").append(cursor.getInt(0)).append("\n");
                    buffer.append("Name: ").append(cursor.getString(1)).append("\n");
                    buffer.append("Age: ").append(cursor.getString(2)).append("\n\n");
                }

                textViewData.setText(buffer.toString());
            }
        });
    }
}