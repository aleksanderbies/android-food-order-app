package com.abies.foodorderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.abies.foodorderapp.Adapters.BasketAdapter;
import com.abies.foodorderapp.Models.BasketModel;
import com.abies.foodorderapp.databinding.ActivityBasketBinding;

import java.util.ArrayList;

public class BasketActivity extends AppCompatActivity {

    ActivityBasketBinding binding;
    DataBaseHelper helper = new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logoactionbar);
        binding = ActivityBasketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<BasketModel> basket = helper.getProductsFromBasket();

        BasketAdapter adapter = new BasketAdapter(basket, this);
        binding.basketRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.basketRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.basket_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.BackToMenu:
                startActivity(new Intent(BasketActivity.this, MainActivity.class));
                break;
            case R.id.Order:
                ArrayList<BasketModel> basket = helper.getProductsFromBasket();
                if(basket.isEmpty()){
                    Toast.makeText(BasketActivity.this, "Nie można złożyć zamówienia ponieważ koszyk jest pusty!", Toast.LENGTH_LONG).show();
                }else {
                    startActivity(new Intent(BasketActivity.this, OrderActivity.class));
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}