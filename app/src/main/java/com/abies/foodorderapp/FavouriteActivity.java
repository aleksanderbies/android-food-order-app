package com.abies.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.abies.foodorderapp.Adapters.FavouritesAdapter;
import com.abies.foodorderapp.Models.FavouritesModel;
import com.abies.foodorderapp.databinding.ActivityFavouriteBinding;

import java.util.ArrayList;

public class FavouriteActivity extends AppCompatActivity {

    ActivityFavouriteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logoactionbar);

        binding = ActivityFavouriteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DataBaseHelper helper = new DataBaseHelper(this);
        ArrayList<FavouritesModel> list = helper.getFavourites();


        FavouritesAdapter adapter = new FavouritesAdapter(list, this);
        binding.orderRecycleView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRecycleView.setLayoutManager(layoutManager);

    }
}