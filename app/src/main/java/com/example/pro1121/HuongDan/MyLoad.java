package com.example.pro1121.HuongDan;

import android.content.Context;
import android.content.SharedPreferences;

public class MyLoad {

    private static final String MY_LOAD = "MY_LOAD";
    private Context context;

    public MyLoad(Context context) {
        this.context = context;
    }

    public void putBooleanValue(String key, boolean value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_LOAD, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBoleanValue(String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_LOAD, 0);
        return sharedPreferences.getBoolean(key, false);
    }
}
