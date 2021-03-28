package com.abies.foodorderapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {
    EditText nameAndSurname, addressAndNumber, postCodeAndCity, email, phoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logoactionbar);
        setContentView(R.layout.activity_order);

        nameAndSurname = findViewById(R.id.nameAndSurnane);
        addressAndNumber = findViewById(R.id.addressAndNumber);
        postCodeAndCity = findViewById(R.id.postCodeAndCity);
        email = findViewById(R.id.email);
        phoneNumber = findViewById(R.id.phoneNumber);

        Button orderNow = findViewById(R.id.orderNow);

        orderNow.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                String n = nameAndSurname.getText().toString();
                String a = addressAndNumber.getText().toString();
                String p = postCodeAndCity.getText().toString();
                String t = phoneNumber.getText().toString();
                String e = email.getText().toString();
                if (n.equals("Imię i nazwisko") || n.equals("") || n.equals(" ")){
                    Toast.makeText(OrderActivity.this, "Podaj swoje imię i nazwisko", Toast.LENGTH_SHORT).show();
                }else if (a.equals("Ulica, Nr domu") || a.equals("") || a.equals(" ")){
                    Toast.makeText(OrderActivity.this, "Podaj swój adres", Toast.LENGTH_SHORT).show();
                }else if (p.equals("Kod pocztowy, Miasto") || p.equals("") || p.equals(" ")){
                    Toast.makeText(OrderActivity.this, "Podaj swój kod pocztowy oraz miasto", Toast.LENGTH_SHORT).show();
                }else if(!e.contains("@") || e.chars().filter(ch -> ch == '@').count() != 1){
                    Toast.makeText(OrderActivity.this, "Podaj poprawny adres email", Toast.LENGTH_SHORT).show();
                }else if(t.length()!=9){
                    Toast.makeText(OrderActivity.this, "Podaj poprawny numer telefonu", Toast.LENGTH_SHORT).show();
                }else {
                    OrderActivity.this.startActivity(new Intent(OrderActivity.this, FinishActivity.class));
                    OrderActivity.this.finish();
                }
            }
        });
    }
}