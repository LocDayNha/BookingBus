package com.example.pro1121.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pro1121.R;
import com.example.pro1121.model.ChuyenXE;

import com.example.pro1121.view.DatXeActivity;

import java.util.ArrayList;

public class DatVeFragment extends Fragment {




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view=inflater.inflate(R.layout.layout_choose_seat,container,false);
//        A1=view.findViewById(R.id.A1);
//        A2=view.findViewById(R.id.A2);
//        A3=view.findViewById(R.id.A3);
//        A4=view.findViewById(R.id.A4);
//        A5=view.findViewById(R.id.A5);
//        A6=view.findViewById(R.id.A6);
//        A7=view.findViewById(R.id.A7);
//        A8=view.findViewById(R.id.A8);
//        A9=view.findViewById(R.id.A9);
//        B1=view.findViewById(R.id.B1);
//        B2=view.findViewById(R.id.B2);
//        B3=view.findViewById(R.id.B3);
//        B4=view.findViewById(R.id.B4);
//        B5=view.findViewById(R.id.B5);
//        B6=view.findViewById(R.id.B6);
//        B7=view.findViewById(R.id.B7);
//        B8=view.findViewById(R.id.B8);
//        B9=view.findViewById(R.id.B9);
//        C1=view.findViewById(R.id.C1);
//        C2=view.findViewById(R.id.C2);
//        C3=view.findViewById(R.id.C3);
//        C4=view.findViewById(R.id.C4);
//        C5=view.findViewById(R.id.C5);
//        C6=view.findViewById(R.id.C6);
//        C7=view.findViewById(R.id.C7);
//        C8=view.findViewById(R.id.C8);
//        C9=view.findViewById(R.id.C9);
//        D1=view.findViewById(R.id.D1);
//        D2=view.findViewById(R.id.D2);
//        D3=view.findViewById(R.id.D3);
//        D4=view.findViewById(R.id.D4);
//        D5=view.findViewById(R.id.D5);
//        D6=view.findViewById(R.id.D6);
//        D7=view.findViewById(R.id.D7);
//        D8=view.findViewById(R.id.D8);
//        D9=view.findViewById(R.id.D9);
//
//
//        A1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                if (A1.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    A1.setImageResource(R.drawable.your_seat_img);
//                    String choa1="A1";
//                    imb.add(A1);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//        });
//
//        A2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (A2.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    A2.setImageResource(R.drawable.your_seat_img);
//                    String choa1="A1";
//                    imb.add(A2);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//        A3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (A3.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//
//                    A3.setImageResource(R.drawable.your_seat_img);
//                    String choa1="A3";
//                    imb.add(A3);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        A4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (A4.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    A4.setImageResource(R.drawable.your_seat_img);
//
//                    String choa1="A4";
//                    imb.add(A4);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//
//            }
//        });
//
//        A5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (A5.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    A5.setImageResource(R.drawable.your_seat_img);
//                    String choa1="A5";
//                    imb.add(A5);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        A6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (A6.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    A6.setImageResource(R.drawable.your_seat_img);
//                    String choa1="A6";
//                    imb.add(A1);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        A7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (A7.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    A7.setImageResource(R.drawable.your_seat_img);
//                    String choa1="A7";
//                    imb.add(A7);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        A8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (A8.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    A8.setImageResource(R.drawable.your_seat_img);
//                    String choa1="A8";
//                    imb.add(A8);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//
//
//        A9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (A9.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    A9.setImageResource(R.drawable.your_seat_img);
//                    String choa1="A9";
//                    imb.add(A9);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//        B1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (B1.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    B1.setImageResource(R.drawable.your_seat_img);
//                    String choa1="B1";
//                    imb.add(B1);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//        B2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (B2.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    B2.setImageResource(R.drawable.your_seat_img);
//                    String choa1="B2";
//                    imb.add(B2);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//        B3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (B3.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    B3.setImageResource(R.drawable.your_seat_img);
//                    String choa1="B3";
//                    imb.add(B3);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//        B4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (B4.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    B4.setImageResource(R.drawable.your_seat_img);
//                    String choa1="B4";
//                    imb.add(B4);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//
//        B5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (B5.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    B5.setImageResource(R.drawable.your_seat_img);
//                    String choa1="B5";
//                    imb.add(B5);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//        B6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (B6.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    B6.setImageResource(R.drawable.your_seat_img);
//                    String choa1="B6";
//                    imb.add(B6);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//        B7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (B7.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    B7.setImageResource(R.drawable.your_seat_img);
//                    String choa1="B7";
//                    imb.add(B7);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//        B8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (B8.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    B8.setImageResource(R.drawable.your_seat_img);
//                    String choa1="B8";
//                    imb.add(B8);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        B9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (B9.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    B9.setImageResource(R.drawable.your_seat_img);
//                    String choa1="B9";
//                    imb.add(B9);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//
//        C1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (C1.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    C1.setImageResource(R.drawable.your_seat_img);
//                    String choa1="C1";
//                    imb.add(C1);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//        C2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (C2.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    C2.setImageResource(R.drawable.your_seat_img);
//                    String choa1="C2";
//                    imb.add(C2);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//        C3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (C3.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    C3.setImageResource(R.drawable.your_seat_img);
//                    String choa1="C3";
//                    imb.add(C3);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//
//        C4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (C4.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    C4.setImageResource(R.drawable.your_seat_img);
//                    String choa1="C4";
//                    imb.add(C4);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//        C5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (C5.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    C5.setImageResource(R.drawable.your_seat_img);
//                    String choa1="C5";
//                    imb.add(C5);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//        C6. setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (C6.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    C6.setImageResource(R.drawable.your_seat_img);
//                    String choa1="C6";
//                    imb.add(C6);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//        C7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (C7.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//
//                    C7.setImageResource(R.drawable.your_seat_img);
//                    String choa1="C7";
//                    imb.add(C7);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//        C8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (C8.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    C8.setImageResource(R.drawable.your_seat_img);
//                    String choa1="C8";
//                    imb.add(C8);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//
//        C9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (C9.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    C9.setImageResource(R.drawable.your_seat_img);
//                    String choa1="C9";
//                    imb.add(C9);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//
//        D1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (D1.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    D1.setImageResource(R.drawable.your_seat_img);
//                    String choa1="D1";
//                    imb.add(D1);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        D2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (D2.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    D2.setImageResource(R.drawable.your_seat_img);
//                    String choa1="D2";
//                    imb.add(D2);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//
//        D3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (D3.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    D3.setImageResource(R.drawable.your_seat_img);
//                    String choa1="D3";
//                    imb.add(D3);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//
//        D4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (D4.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    D4.setImageResource(R.drawable.your_seat_img);
//                    String choa1="D4";
//                    imb.add(D4);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//
//        D5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (D5.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    D5.setImageResource(R.drawable.your_seat_img);
//                    String choa1="D5";
//                    imb.add(D5);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//
//        D6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (D6.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    D6.setImageResource(R.drawable.your_seat_img);
//                    String choa1="D6";
//                    imb.add(D6);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//
//        D7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (D7.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    D7.setImageResource(R.drawable.your_seat_img);
//                    String choa1="D7";
//                    imb.add(D7);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//
//        D8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (D8.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    D8.setImageResource(R.drawable.your_seat_img);
//                    String choa1="D8";
//                    imb.add(D8);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//        D9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (D9.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
//                {
//                    D9.setImageResource(R.drawable.your_seat_img);
//                    String choa1="D9";
//                    imb.add(D9);
//                    VeXE veXE= new VeXE(1,choa1,"2500","1");
//                    listvx.add(veXE);
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Đã được chọn", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });


        return null;
    }
}
