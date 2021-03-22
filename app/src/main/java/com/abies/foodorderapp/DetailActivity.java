package com.abies.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
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

        final DataBaseHelper helper = new DataBaseHelper(this);

        if (getIntent().getIntExtra("type", 0) == 1) {
            final int image = getIntent().getIntExtra("image", 0);
            double price = parseDouble(getIntent().getStringExtra("price"));
            String name = getIntent().getStringExtra("name");
            String description = getIntent().getStringExtra("desc");

            final String priceView = String.valueOf(price) + "0";

            binding.detailImage.setImageResource(image);
            binding.priceLabel.setText(priceView);
            binding.nameBox.setText(name);
            binding.detailDescription.setText(description);

            binding.addToFav.setOnClickListener(v -> {
                boolean isInserted = helper.insertFavourite(name, priceView, image, description);

                if (isInserted) {
                    Toast.makeText(DetailActivity.this, "Pomyślnie dodano do ulubionych", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DetailActivity.this, "Błąd bazy danych.", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            String name = getIntent().getStringExtra("name");
            Cursor cursor = helper.getFavByName(name);

            binding.detailImage.setImageResource(cursor.getInt(2));
            binding.priceLabel.setText(cursor.getString(1));
            String nameFav = cursor.getString(0);
            binding.nameBox.setText(nameFav);
            binding.detailDescription.setText(cursor.getString(3));
            binding.addToFav.setText("Usuń z ulubionych");

            binding.addToFav.setOnClickListener(v -> {
              int isDeleted = helper.deleteFav(nameFav);
              if( isDeleted > 0){
                  Toast.makeText(DetailActivity.this, "Usunięto", Toast.LENGTH_SHORT).show();
              } else {
                  Toast.makeText(DetailActivity.this, "Błąd bazy danych", Toast.LENGTH_SHORT).show();
              }
            });
        }
    }
}