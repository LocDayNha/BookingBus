package com.example.pro1121.news;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.pro1121.Fragment.TrangChuFragment;
import com.example.pro1121.R;
import com.example.pro1121.view.MainActivity;


public class TinTucActivity extends AppCompatActivity {
    TextView nextNews, backdaynha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tin_tuc);

        nextNews = findViewById(R.id.nextNews);
        backdaynha = findViewById(R.id.backdaynha);

        nextNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TinTucActivity.this, TinTuc2Activity.class);
                startActivity(i);
            }
        });

        backdaynha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TinTucActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}