package com.example.pro1121.HuongDan;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {


    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Load0Fragment();

            case 1:
                return new Load1Fragment();

            case 2:
                return new Load2Fragment();

            case 3:
                return new Load3Fragment();

            default:
                return new Load0Fragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
