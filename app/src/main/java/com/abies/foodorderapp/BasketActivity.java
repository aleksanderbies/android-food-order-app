package com.abies.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.abies.foodorderapp.Adapters.BasketAdapter;
import com.abies.foodorderapp.Models.BasketModel;
import com.abies.foodorderapp.Models.MainModel;
import com.abies.foodorderapp.databinding.ActivityBasketBinding;
import com.abies.foodorderapp.databinding.ActivityFavouriteBinding;

import java.util.ArrayList;

public class BasketActivity extends AppCompatActivity {

    ActivityBasketBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logoactionbar);
        binding = ActivityBasketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<BasketModel> basket = new ArrayList<>();
        basket.add(new BasketModel(R.drawable.peperoni, "HAOFHLA", "2.00", "1"));

        BasketAdapter adapter = new BasketAdapter(basket, this);
        binding.basketRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.basketRecyclerView.setLayoutManager(layoutManager);
    }
}