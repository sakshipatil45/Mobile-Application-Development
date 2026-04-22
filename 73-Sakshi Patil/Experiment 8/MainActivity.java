package com.example.menuapplication;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button btnMenu;

    // Food Data
    String[] foodItems = {"Pizza", "Burger", "Pasta", "Sandwich"};

    int[] foodImages = {
            R.drawable.pizza,
            R.drawable.burger,
            R.drawable.pasta,
            R.drawable.sandwich
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.listView);
        btnMenu = findViewById(R.id.btnMenu);

        // Set Custom Adapter (Image + Name)
        FoodAdapter adapter = new FoodAdapter(this, foodItems, foodImages);
        listView.setAdapter(adapter);

        // Register Context Menu (Long Press)
        registerForContextMenu(listView);

//        // Item Click (optional - for better UI)
//        listView.setOnItemClickListener((parent, view, position, id) -> {
//            Toast.makeText(this,
//                    foodItems[position] + " selected",
//                    Toast.LENGTH_SHORT).show();
//        });

        // Popup Menu (Button Click)
        btnMenu.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(MainActivity.this, btnMenu);
            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

            popup.setOnMenuItemClickListener(item -> {
                Toast.makeText(this,
                        item.getTitle() + " selected",
                        Toast.LENGTH_SHORT).show();
                return true;
            });

            popup.show();
        });
    }

    // 🔹 OPTIONS MENU (Top Right 3 dots)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this,
                item.getTitle() + " clicked",
                Toast.LENGTH_SHORT).show();
        return true;
    }

    // 🔹 CONTEXT MENU (Long Press on List Item)
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Select Action");
        menu.add(0, v.getId(), 0, "Add To Cart");
        menu.add(0, v.getId(), 0, "View Details");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this,
                item.getTitle() + " selected",
                Toast.LENGTH_SHORT).show();
        return true;
    }
}