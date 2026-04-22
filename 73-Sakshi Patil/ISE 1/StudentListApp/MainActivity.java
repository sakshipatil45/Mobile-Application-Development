package com.example.studentlistapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> names;
    ArrayList<String> mobiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        Intent intent = getIntent();
        names = intent.getStringArrayListExtra("names");
        mobiles = intent.getStringArrayListExtra("mobiles");

        listView.setAdapter(new CustomAdapter());
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return names.size();
        }


        @Override
        public Object getItem(int i) {
            return names.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.list_item, viewGroup, false);

            TextView tvName = view.findViewById(R.id.tvName);
            TextView tvMobile = view.findViewById(R.id.tvMobile);
            Button btnCall = view.findViewById(R.id.btnCall);

            tvName.setText(names.get(i));
            tvMobile.setText(mobiles.get(i));

            btnCall.setOnClickListener(v -> {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + mobiles.get(i)));
                startActivity(callIntent);
            });

            return view;
        }
    }
}