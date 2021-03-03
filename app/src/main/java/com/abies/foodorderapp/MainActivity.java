package com.abies.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.abies.foodorderapp.Adapters.MainAdapter;
import com.abies.foodorderapp.Models.MainModel;
import com.abies.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.ffs, "Zestaw obiadowy \"Schabowy\"", "18.50", "Do wyboru ziemniaki lub frytki"));
        list.add(new MainModel(R.drawable.ffs, "Zestaw obiadowy \"Schabowy\"", "18.50", "Do wyboru ziemniaki lub frytki"));
        list.add(new MainModel(R.drawable.ffs, "Zestaw obiadowy \"Schabowy\"", "18.50", "Do wyboru ziemniaki lub frytki"));
        list.add(new MainModel(R.drawable.ffs, "Zestaw obiadowy \"Schabowy\"", "18.50", "Do wyboru ziemniaki lub frytki"));
        list.add(new MainModel(R.drawable.ffs, "Zestaw obiadowy \"Schabowy\"", "18.50", "Do wyboru ziemniaki lub frytki"));
        list.add(new MainModel(R.drawable.ffs, "Zestaw obiadowy \"Schabowy\"", "18.50", "Do wyboru ziemniaki lub frytki"));

        MainAdapter adapter = new MainAdapter(list, this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }
}