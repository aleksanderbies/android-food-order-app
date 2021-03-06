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

        list.add(new MainModel(R.drawable.margherita, "Pizza Margherita", "38.50", "ser, sos, oregano"));
        list.add(new MainModel(R.drawable.peperoni, "Pizza Peperoni", "38.50", "ser, sos, oregano, papryka peperoni"));
        list.add(new MainModel(R.drawable.capriciosa, "Pizza Capriciosa", "40.50", "ser, sos, oregano, szynka, pieczarki"));
        list.add(new MainModel(R.drawable.roma, "Pizza Roma", "45.50", "bazylia, pomidory, salami, ser, sos"));
        list.add(new MainModel(R.drawable.fruttidimare, "Pizza \"Frutti di Mare\"", "45.50", "ser, oregano, owoce morza"));
        list.add(new MainModel(R.drawable.wegetarianska, "Pizza wegetariańska", "36.90", "sos, ser, oregano, pieczarki, cebula, papryka, kukurydza"));
        list.add(new MainModel(R.drawable.hawajska, "Pizza hawajska", "38.50", "sos, ser, oregano, szynka, ananas\n"));
        list.add(new MainModel(R.drawable.didiabolo, "Pizza \"Di Diabolo\"", "36.90", "sos, ser, oregano, papryka, papryka peperoni, chilli, czosnek\n"));
        list.add(new MainModel(R.drawable.sery4, "Pizza \"Cztery Sery\"", "38.50", "sos, oregano, ser gouda, ser mozzarella, ser typu feta, ser pleśniowy\n"));
        list.add(new MainModel(R.drawable.burger_drobiowy, "Burger drobiowy", "13.50", "polędwica z kurczaka, sałata, ser, pomidory, cebula"));
        list.add(new MainModel(R.drawable.burger_wolowy, "Burger wołowy", "13.50", "polędwica wołowa, sałata, ser, pomidory, cebula"));
        list.add(new MainModel(R.drawable.kebab_bulka, "Kebab w bułce", "15.50", "mięso wołowe, cebula, surówka koperkowa, frytki"));
        list.add(new MainModel(R.drawable.kebab_tortilla, "Kebab w cieście", "15.50", "mięso wołowe, cebula, surówka koperkowa, frytki"));
        list.add(new MainModel(R.drawable.zapiekanka, "Zapiekanka", "6.50", "ser, szynka, pieczarki"));
        list.add(new MainModel(R.drawable.hotdog, "2 x Hot-Dog", "8.50", "parówka wieprzowa, ser, sałata zielona, sałatka, ogórek, pomidor, bułka"));
        list.add(new MainModel(R.drawable.frytki, "Frytki", "4.50", "  "));
        list.add(new MainModel(R.drawable.sospomidorowy,"Sos pomidorowy", "3.00", "   "));
        list.add(new MainModel(R.drawable.sosczosnkowy, "Sos czosnkowy", "3.00", "   "));
        list.add(new MainModel(R.drawable.sosjogurtowy, "Sos jogurtowy", "3.00", "  "));
        MainAdapter adapter = new MainAdapter(list, this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }
}