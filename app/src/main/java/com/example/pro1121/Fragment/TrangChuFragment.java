package com.example.pro1121.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.pro1121.R;
import com.example.pro1121.databinding.FragmentNguoidungBinding;
import com.example.pro1121.news.TinTucActivity;
import com.example.pro1121.view.MainActivity;
import com.example.pro1121.view.TimChuyenActivity;

public class TrangChuFragment extends Fragment {
    ImageView imgSearchBusinMain,imgMapBusinMain,imgHistoryBusinMain,imgProfileinMain,imgNewsinMain,imgExitinMain, doipass;
    Fragment fragment = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragmnet_trangchu, container, false);

        imgSearchBusinMain = view.findViewById(R.id.imgSearchBusinMain);
        imgMapBusinMain = view.findViewById(R.id.imgMapBusinMain);
        imgHistoryBusinMain = view.findViewById(R.id.imgHistoryBusinMain);
        imgProfileinMain = view.findViewById(R.id.imgProfileinMain);
        imgNewsinMain = view.findViewById(R.id.imgNewsinMain);
        imgExitinMain = view.findViewById(R.id.imgExitinMain);
        doipass = view.findViewById(R.id.doipass);

        imgSearchBusinMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment timChuyenFragment = new TimChuyenFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.trangchu_fragmenttt, timChuyenFragment);
                transaction.commit();
            }
        });

        imgMapBusinMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment timTramFragment = new TimTramFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.trangchu_fragmenttt, timTramFragment);
                transaction.commit();
            }
        });

        imgHistoryBusinMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment timVeFragment = new TimVeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.trangchu_fragmenttt, timVeFragment);
                transaction.commit();
            }
        });

        imgNewsinMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment feedBackFragment = new FeedBackFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.trangchu_fragmenttt, feedBackFragment);
                transaction.commit();
            }
        });

        imgProfileinMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment nguoiDungFragment = new NguoiDungFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.trangchu_fragmenttt, nguoiDungFragment);
                transaction.commit();
            }
        });

        doipass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment doiPassFragment = new DoiPassFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.trangchu_fragmenttt, doiPassFragment);
                transaction.commit();
            }
        });


        return view;
    }

}
