package com.example.pro1121.HuongDan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.pro1121.R;
import com.example.pro1121.view.MainActivity;

public class SplashActivity extends AppCompatActivity {
    private static final String KEY = "KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        MyLoad myLoad = new MyLoad(this);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (myLoad.getBoleanValue(KEY)){
                    // voa` MainActivity
                    startActivity(MainActivity.class);
                }else {
                    // vao` LoadActivity
                    startActivity(LoadActivity.class);
                    myLoad.putBooleanValue(KEY, true);
                }
            }
        }, 1000);
    }

    private void startActivity(Class<?> clas){
        Intent i = new Intent(this, clas);
        startActivity(i);
        finish();
    }

}