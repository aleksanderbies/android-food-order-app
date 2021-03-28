package com.abies.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_finish);

        ImageView backToMenu = findViewById(R.id.backToApp);

        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FinishActivity.this.startActivity(new Intent(FinishActivity.this, MainActivity.class));
                FinishActivity.this.finish();
            }
        });
    }
}