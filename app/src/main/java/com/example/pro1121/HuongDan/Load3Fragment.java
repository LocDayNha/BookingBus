package com.example.pro1121.HuongDan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.pro1121.R;
import com.example.pro1121.view.MainActivity;

public class Load3Fragment extends Fragment {
    private Button btnStart;
    private View mView;


    public Load3Fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_load3, container, false);

        btnStart = mView.findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), MainActivity.class);
                getActivity().startActivity(i);
            }
        });

        return mView;
    }
}