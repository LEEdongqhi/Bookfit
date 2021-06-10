package com.example.bookfit;

import android.content.Intent;
//import android.support.v7.app.AppcompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SubActivity extends AppCompatActivity{

    private ImageButton btn_menu;
    private ImageButton btn_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        btn_menu = findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SubActivity.this, Menu.class));
            }
        });

        /*btn_search = findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SubActivity.this, Search.class));
            }
        });*/




    }
}
