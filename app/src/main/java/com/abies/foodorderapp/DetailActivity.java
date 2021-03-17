package com.abies.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.abies.foodorderapp.databinding.ActivityDetailBinding;

import static java.lang.Double.parseDouble;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;


    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logoactionbar);

        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final int image = getIntent().getIntExtra("image", 0);
        double price = parseDouble(getIntent().getStringExtra("price"));
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("desc");

        final String priceView = String.valueOf(price)+"0";

        binding.detailImage.setImageResource(image);
        binding.priceLabel.setText(priceView);
        binding.nameBox.setText(name);
        binding.detailDescription.setText(description);

        DataBaseHelper helper = new DataBaseHelper(this);

        binding.addToFav.setOnClickListener(v -> {
            boolean isInserted = helper.insertFavourite(name, priceView,image);

            if (isInserted){
                Toast.makeText(DetailActivity.this, "Pomyślnie dodano do ulubionych", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(DetailActivity.this, "Błąd bazy danych.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}