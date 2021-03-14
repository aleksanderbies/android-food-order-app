package com.abies.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.abies.foodorderapp.databinding.ActivityDetailBinding;

import static java.lang.Double.parseDouble;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;


    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int image = getIntent().getIntExtra("image", 0);
        double price = parseDouble(getIntent().getStringExtra("price"));
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("desc");

        binding.detailImage.setImageResource(image);
        binding.priceLabel.setText(String.valueOf(price));
        binding.nameBox.setText(name);
        binding.detailDescription.setText(description);
    }
}