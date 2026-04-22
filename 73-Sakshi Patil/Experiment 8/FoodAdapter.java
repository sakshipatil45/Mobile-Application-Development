package com.example.menuapplication;

import android.content.Context;
import android.view.*;
import android.widget.*;
import java.util.*;

public class FoodAdapter extends BaseAdapter {

    Context context;
    String[] foodNames;
    int[] foodImages;
    LayoutInflater inflater;

    public FoodAdapter(Context context, String[] foodNames, int[] foodImages) {
        this.context = context;
        this.foodNames = foodNames;
        this.foodImages = foodImages;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return foodNames.length;
    }

    @Override
    public Object getItem(int i) {
        return foodNames[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        view = inflater.inflate(R.layout.list_item, null);

        ImageView image = view.findViewById(R.id.foodImage);
        TextView name = view.findViewById(R.id.foodName);

        image.setImageResource(foodImages[i]);
        name.setText(foodNames[i]);

        return view;
    }
}