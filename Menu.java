package com.example.bookfit;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity{

    private ImageButton btn_kyobo;
    private ImageButton btn_st11;
    private ImageButton btn_yes24;
    private ImageButton btn_bandi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        btn_kyobo = findViewById(R.id.btn_kyobo);
        btn_kyobo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Menu.this, Kyobo.class));
            }
        });

        btn_st11 = findViewById(R.id.btn_st11);
        btn_st11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Menu.this, St11.class));
            }
        });

        btn_yes24 = findViewById(R.id.btn_yes24);
        btn_yes24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Menu.this, Yes24.class));
            }
        });

        btn_bandi = findViewById(R.id.btn_bandi);
        btn_bandi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Menu.this, Bandi.class));
            }
        });




    }
}
