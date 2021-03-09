package com.abies.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.abies.foodorderapp.Adapters.OrdersAdapter;
import com.abies.foodorderapp.Models.OrdersModel;
import com.abies.foodorderapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<OrdersModel> list = new ArrayList<>();
        list.add(new OrdersModel(R.drawable.burger_drobiowy, "Burger drobiowy", "13.50", "31345213"));
        list.add(new OrdersModel(R.drawable.burger_drobiowy, "Burger drobiowy", "13.50", "31345213"));
        list.add(new OrdersModel(R.drawable.burger_drobiowy, "Burger drobiowy", "13.50", "31345213"));
        list.add(new OrdersModel(R.drawable.burger_drobiowy, "Burger drobiowy", "13.50", "31345213"));
        list.add(new OrdersModel(R.drawable.burger_drobiowy, "Burger drobiowy", "13.50", "31345213"));
        list.add(new OrdersModel(R.drawable.burger_drobiowy, "Burger drobiowy", "13.50", "31345213"));
        list.add(new OrdersModel(R.drawable.burger_drobiowy, "Burger drobiowy", "13.50", "31345213"));
        list.add(new OrdersModel(R.drawable.burger_drobiowy, "Burger drobiowy", "13.50", "31345213"));
        list.add(new OrdersModel(R.drawable.burger_drobiowy, "Burger drobiowy", "13.50", "31345213"));
        list.add(new OrdersModel(R.drawable.burger_drobiowy, "Burger drobiowy", "13.50", "31345213"));
        list.add(new OrdersModel(R.drawable.burger_drobiowy, "Burger drobiowy", "13.50", "31345213"));
        list.add(new OrdersModel(R.drawable.burger_drobiowy, "Burger drobiowy", "13.50", "31345213"));
        list.add(new OrdersModel(R.drawable.burger_drobiowy, "Burger drobiowy", "13.50", "31345213"));
        list.add(new OrdersModel(R.drawable.burger_drobiowy, "Burger drobiowy", "13.50", "31345213"));
        list.add(new OrdersModel(R.drawable.burger_drobiowy, "Burger drobiowy", "13.50", "31345213"));
        list.add(new OrdersModel(R.drawable.burger_drobiowy, "Burger drobiowy", "13.50", "31345213"));
        list.add(new OrdersModel(R.drawable.burger_drobiowy, "Burger drobiowy", "13.50", "31345213"));

        OrdersAdapter adapter = new OrdersAdapter(list, this);
        binding.orderRecycleView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRecycleView.setLayoutManager(layoutManager);

    }
}