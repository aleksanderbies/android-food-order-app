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

        Intent mainIntent = new Intent(DetailActivity.this, MainActivity.class);
        Intent basketIntent = new Intent(DetailActivity.this, BasketActivity.class);

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

            binding.insertButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean inBasket = helper.insertToBasket(name, priceView, image, "1");
                    if(inBasket){
                        DetailActivity.this.startActivity(basketIntent);
                        DetailActivity.this.finish();
                        Toast.makeText(DetailActivity.this, "Dodano do koszyka", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(DetailActivity.this, "Wystąpił błąd.", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            binding.addToFav.setOnClickListener(v -> {
                boolean isInserted = helper.insertFavourite(name, priceView, image, description);

                if (isInserted) {
                    DetailActivity.this.startActivity(mainIntent);
                    DetailActivity.this.finish();
                    Toast.makeText(DetailActivity.this, "Pomyślnie dodano do ulubionych", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DetailActivity.this, "Błąd bazy danych.", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            String name = getIntent().getStringExtra("name");
            Cursor cursor = helper.getFavByName(name);
            int favFoodImage = cursor.getInt(2);
            String favFoodPrice = cursor.getString(1);
            String nameFav = cursor.getString(0);
            String favFoodDecription = cursor.getString(3);
            binding.detailImage.setImageResource(favFoodImage);
            binding.priceLabel.setText(favFoodPrice);
            binding.nameBox.setText(nameFav);
            binding.detailDescription.setText(favFoodDecription);
            binding.addToFav.setText("Usuń z ulubionych");

            binding.insertButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean inBasket = helper.insertToBasket(name, favFoodPrice, favFoodImage, "1");
                    if(inBasket){
                        DetailActivity.this.startActivity(basketIntent);
                        DetailActivity.this.finish();
                        Toast.makeText(DetailActivity.this, "Dodano do koszyka", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(DetailActivity.this, "Wystąpił błąd.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            binding.addToFav.setOnClickListener(v -> {
              int isDeleted = helper.deleteFav(nameFav);
              if( isDeleted > 0){
                  Toast.makeText(DetailActivity.this, "Usunięto", Toast.LENGTH_SHORT).show();
                  DetailActivity.this.startActivity(mainIntent);
                  DetailActivity.this.finish();
              } else {
                  Toast.makeText(DetailActivity.this, "Błąd bazy danych", Toast.LENGTH_SHORT).show();
              }

            });
        }
    }
}