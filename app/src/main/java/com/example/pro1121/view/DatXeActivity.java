package com.example.pro1121.view;








import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.pro1121.Fragment.TimChuyenFragment;
import com.example.pro1121.R;
import com.example.pro1121.model.ChuyenXE;

import com.example.pro1121.model.VeXE;

import com.example.pro1121.model.VeXeDat;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.collection.LLRBNode;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.type.Color;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DatXeActivity extends AppCompatActivity  {

    ImageButton A1,A2,A3,A4,A5,A6,A7,A8,A9,
                B1,B2,B3,B4,B5,B6,B7,B8,B9,
                C1,C2,C3,C4,C5,C6,C7,C8,C9,
                D1,D2,D3,D4,D5,D6,D7,D8,D9;
    ArrayList<Object> imb= new ArrayList<>();
    ArrayList<String>vitrive;
    TextView giodatve,diemdive,diemdenve,giochuyendi,soluongve,tienve;
    Button btndat;
    String vitrine;
    String id_chuyenxe1;
    VeXeDat veXeDat=null;
    public String id_chuyenxe;
    String soxedat;
    String giochuyendidat;

    FirebaseFirestore db = FirebaseFirestore.getInstance();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_choose_seat);
        vitrive= new ArrayList<>();
        giodatve=findViewById(R.id.giodatve);
        btndat=findViewById(R.id.dat);
        btndat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSaveClick(v);
            }
        });
        tienve=findViewById(R.id.tienve);
        soluongve=findViewById(R.id.soluongve);
        diemdive=findViewById(R.id.diemdive);
        diemdenve=findViewById(R.id.diemdenve);
        giochuyendi=findViewById(R.id.giochuyendi);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
        String datetime = dateformat.format(c.getTime());
        giodatve.setText(datetime);
        Intent intent= getIntent();
        id_chuyenxe1= intent.getStringExtra("id");

        Toast.makeText(this, "id: "+id_chuyenxe1, Toast.LENGTH_SHORT).show();

        getData();




        A1=findViewById(R.id.A1);
        A2=findViewById(R.id.A2);
        A3=findViewById(R.id.A3);
        A4=findViewById(R.id.A4);
        A5=findViewById(R.id.A5);
        A6=findViewById(R.id.A6);
        A7=findViewById(R.id.A7);
        A8=findViewById(R.id.A8);
        A9=findViewById(R.id.A9);
        B1=findViewById(R.id.B1);
        B2=findViewById(R.id.B2);
        B3=findViewById(R.id.B3);
        B4=findViewById(R.id.B4);
        B5=findViewById(R.id.B5);
        B6=findViewById(R.id.B6);
        B7=findViewById(R.id.B7);
        B8=findViewById(R.id.B8);
        B9=findViewById(R.id.B9);
        C1=findViewById(R.id.C1);
        C2=findViewById(R.id.C2);
        C3=findViewById(R.id.C3);
        C4=findViewById(R.id.C4);
        C5=findViewById(R.id.C5);
        C6=findViewById(R.id.C6);
        C7=findViewById(R.id.C7);
        C8=findViewById(R.id.C8);
        C9=findViewById(R.id.C9);
        D1=findViewById(R.id.D1);
        D2=findViewById(R.id.D2);
        D3=findViewById(R.id.D3);
        D4=findViewById(R.id.D4);
        D5=findViewById(R.id.D5);
        D6=findViewById(R.id.D6);
        D7=findViewById(R.id.D7);
        D8=findViewById(R.id.D8);
        D9=findViewById(R.id.D9);




        A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (A1.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {
                    A1.setImageResource(R.drawable.your_seat_img);
                    String choa1="A1";
                    imb.add(A1);
                    tienve.setText(imb.size()*250000+" VNĐ");
                    soluongve.setText(imb.size()+"  Chổ");
                    vitrive.add(choa1);



                }
                else
                {
                    Toast.makeText(DatXeActivity.this, "Đã Được chọn", Toast.LENGTH_SHORT).show();
                }
            }

        });

        A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (A2.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {
                    A2.setImageResource(R.drawable.your_seat_img);
                    String choa1="A1";
                    imb.add(A2);
                    soluongve.setText(imb.size()+"  Chổ");
                    tienve.setText(imb.size()*250000+" VNĐ");
                    vitrive.add(choa1);
                }
                else
                {
                    Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

                }
            }
        });
        A3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (A3.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {

                    A3.setImageResource(R.drawable.your_seat_img);
                    String choa1="A3";
                    imb.add(A3);
                    soluongve.setText(imb.size()+"  Chổ");
                    tienve.setText(imb.size()*250000+" VNĐ");
                    vitrive.add(choa1);

                }
                else
                {
                    Toast.makeText(DatXeActivity.this, "Đã Được chọn", Toast.LENGTH_SHORT).show();
                }
            }
        });

        A4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (A4.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {
                    A4.setImageResource(R.drawable.your_seat_img);

                    String choa1="A4";
                    imb.add(A4);
                    soluongve.setText(imb.size()+"  Chổ");
                    tienve.setText(imb.size()*250000+" VNĐ");
                    vitrive.add(choa1);
                }else
                {
                    Toast.makeText(DatXeActivity.this, "Đã Được chọn", Toast.LENGTH_SHORT).show();

                }

            }
        });

        A5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (A5.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {
                    A5.setImageResource(R.drawable.your_seat_img);
                    String choa1="A5";
                    imb.add(A5);
                    soluongve.setText(imb.size()+"  Chổ");
                    tienve.setText(imb.size()*250000+" VNĐ");
                    vitrive.add(choa1);
                }
                else
                {
                    Toast.makeText(DatXeActivity.this, "Đã Được chọn", Toast.LENGTH_SHORT).show();
                }
            }
        });
        A6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (A6.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {
                    A6.setImageResource(R.drawable.your_seat_img);
                    String choa1="A6";
                    imb.add(A1);
                    soluongve.setText(imb.size()+"  Chổ");
                    tienve.setText(imb.size()*250000+" VNĐ");
                    vitrive.add(choa1);

                }
                else
                {
                    Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();
                }
            }
        });
        A7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (A7.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {
                    A7.setImageResource(R.drawable.your_seat_img);
                    String choa1="A7";
                    imb.add(A7);
                    soluongve.setText(imb.size()+"  Chổ");
                    tienve.setText(imb.size()*250000+" VNĐ");
                    vitrive.add(choa1);

                }
                else
                {
                    Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();
                }
            }
        });
        A8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (A8.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {
                    A8.setImageResource(R.drawable.your_seat_img);
                    String choa1="A8";
                    imb.add(A8);
                    soluongve.setText(imb.size()+"  Chổ");
                    tienve.setText(imb.size()*250000+" VNĐ");
                    vitrive.add(choa1);

                }
                else
                {
                    Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

                }
            }
        });


        A9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (A9.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {
                    A9.setImageResource(R.drawable.your_seat_img);
                    String choa1="A9";
                    imb.add(A9);
                    soluongve.setText(imb.size()+"  Chổ");
                    tienve.setText(imb.size()*250000+" VNĐ");
                    vitrive.add(choa1);

                }
                else
                {
                    Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

                }
            }
        });
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (B1.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {
                    B1.setImageResource(R.drawable.your_seat_img);
                    String choa1="B1";
                    imb.add(B1);
                    soluongve.setText(imb.size()+"  Chổ");
                    tienve.setText(imb.size()*250000+" VNĐ");
                    vitrive.add(choa1);

                }
                else
                {
                    Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

                }
            }
        });
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (B2.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {
                    B2.setImageResource(R.drawable.your_seat_img);
                    String choa1="B2";
                    imb.add(B2);
                    soluongve.setText(imb.size()+"  Chổ");
                    tienve.setText(imb.size()*250000+" VNĐ");
                    vitrive.add(choa1);
                }
                else
                {
                    Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

                }
            }
        });
        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (B3.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {
                    B3.setImageResource(R.drawable.your_seat_img);
                    String choa1="B3";
                    imb.add(B3);
                    soluongve.setText(imb.size()+"  Chổ");
                    tienve.setText(imb.size()*250000+" VNĐ");
                    vitrive.add(choa1);
                }
                else
                {
                    Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

                }
            }
        });
        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (B4.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {
                    B4.setImageResource(R.drawable.your_seat_img);
                    String choa1="B4";
                    imb.add(B4);
                    soluongve.setText(imb.size()+"  Chổ");
                    tienve.setText(imb.size()*250000+" VNĐ");
                    vitrive.add(choa1);
                }
                else
                {
                    Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

                }
            }
        });

       B5.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if (B5.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
               {
                   B5.setImageResource(R.drawable.your_seat_img);
                   String choa1="B5";
                   imb.add(B5);
                   soluongve.setText(imb.size()+"  Chổ");
                   tienve.setText(imb.size()*250000+" VNĐ");
                   vitrive.add(choa1);
               }
               else
               {
                   Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

               }
           }
       });
       B6.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (B6.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
               {
                   B6.setImageResource(R.drawable.your_seat_img);
                   String choa1="B6";
                   imb.add(B6);
                   soluongve.setText(imb.size()+"  Chổ");
                   tienve.setText(imb.size()*250000+" VNĐ");
                   vitrive.add(choa1);
               }
               else
               {
                   Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

               }
           }
       });
       B7.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (B7.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
               {
                   B7.setImageResource(R.drawable.your_seat_img);
                   String choa1="B7";
                   imb.add(B7);
                   soluongve.setText(imb.size()+"  Chổ");
                   tienve.setText(imb.size()*250000+" VNĐ");
                   vitrive.add(choa1);

               }
               else
               {
                   Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

               }
           }
       });
       B8.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (B8.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
               {
                   B8.setImageResource(R.drawable.your_seat_img);
                   String choa1="B8";
                   imb.add(B8);
                   soluongve.setText(imb.size()+"  Chổ");
                   tienve.setText(imb.size()*250000+" VNĐ");
                   vitrive.add(choa1);
               }
               else
               {
                   Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

               }
           }
       });

       B9.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (B9.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
               {
                   B9.setImageResource(R.drawable.your_seat_img);
                   String choa1="B9";
                   imb.add(B9);
                   soluongve.setText(imb.size()+"  Chổ");
                   tienve.setText(imb.size()*250000+" VNĐ");
                   vitrive.add(choa1);

               }
               else
               {
                   Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

               }
           }
       });

       C1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (C1.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
               {
                   C1.setImageResource(R.drawable.your_seat_img);
                   String choa1="C1";
                   imb.add(C1);
                   soluongve.setText(imb.size()+"  Chổ");
                   tienve.setText(imb.size()*250000+" VNĐ");
                   vitrive.add(choa1);

               }
               else
               {
                   Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

               }
           }
       });
       C2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (C2.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
               {
                   C2.setImageResource(R.drawable.your_seat_img);
                   String choa1="C2";
                   imb.add(C2);
                   soluongve.setText(imb.size()+"  Chổ");
                   tienve.setText(imb.size()*250000+" VNĐ");
                   vitrive.add(choa1);

               }
               else
               {
                   Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

               }
           }
       });
       C3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (C3.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
               {
                   C3.setImageResource(R.drawable.your_seat_img);
                   String choa1="C3";
                   imb.add(C3);
                   soluongve.setText(imb.size()+"  Chổ");
                   tienve.setText(imb.size()*250000+" VNĐ");
                   vitrive.add(choa1);
               }
               else
               {
                   Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

               }
           }
       });

       C4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if (C4.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
               {
                   C4.setImageResource(R.drawable.your_seat_img);
                   String choa1="C4";
                   imb.add(C4);
                   soluongve.setText(imb.size()+"  Chổ");
                   tienve.setText(imb.size()*250000+" VNĐ");
                   vitrive.add(choa1);
               }
               else
               {
                   Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

               }
           }
       });
       C5.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (C5.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
               {
                   C5.setImageResource(R.drawable.your_seat_img);
                   String choa1="C5";
                   imb.add(C5);
                   soluongve.setText(imb.size()+"  Chổ");
                   tienve.setText(imb.size()*250000+" VNĐ");
                   vitrive.add(choa1);
               }
               else
               {
                   Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

               }
           }
       });
       C6. setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (C6.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
               {
                   C6.setImageResource(R.drawable.your_seat_img);
                   String choa1="C6";
                   imb.add(C6);
                   soluongve.setText(imb.size()+"  Chổ");
                   tienve.setText(imb.size()*250000+" VNĐ");
                   vitrive.add(choa1);
               }
               else
               {
                   Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

               }
           }
       });
       C7.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (C7.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
               {

                   C7.setImageResource(R.drawable.your_seat_img);
                   String choa1="C7";
                   imb.add(C7);
                   soluongve.setText(imb.size()+"  Chổ");
                   tienve.setText(imb.size()*250000+" VNĐ");
                   vitrive.add(choa1);
               }
               else
               {
                   Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

               }
           }
       });
       C8.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (C8.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
               {
                   C8.setImageResource(R.drawable.your_seat_img);
                   String choa1="C8";
                   imb.add(C8);
                   soluongve.setText(imb.size()+"  Chổ");
                   tienve.setText(imb.size()*250000+" VNĐ");
                   vitrive.add(choa1);
               }
               else
               {
                   Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

               }
           }
       });

       C9.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (C9.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
               {
                   C9.setImageResource(R.drawable.your_seat_img);
                   String choa1="C9";
                   imb.add(C9);
                   soluongve.setText(imb.size()+"  Chổ");
                   tienve.setText(imb.size()*250000+" VNĐ");
                   vitrive.add(choa1);
               }
               else
               {
                   Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

               }
           }
       });

        D1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (D1.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {
                    D1.setImageResource(R.drawable.your_seat_img);
                    String choa1="D1";
                    imb.add(D1);
                    soluongve.setText(imb.size()+"  Chổ");
                    tienve.setText(imb.size()*250000+" VNĐ");
                    vitrive.add(choa1);
                }
                else
                {
                    Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

                }
            }
        });

        D2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (D2.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {
                    D2.setImageResource(R.drawable.your_seat_img);
                    String choa1="D2";
                    imb.add(D2);
                    soluongve.setText(imb.size()+"  Chổ");
                    tienve.setText(imb.size()*250000+" VNĐ");
                    vitrive.add(choa1);
                }
                else
                {
                    Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

                }
            }
        });

        D3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (D3.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {
                    D3.setImageResource(R.drawable.your_seat_img);
                    String choa1="D3";
                    imb.add(D3);
                    soluongve.setText(imb.size()+"  Chổ");
                    tienve.setText(imb.size()*250000+" VNĐ");
                    vitrive.add(choa1);
                }
                else
                {
                    Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

                }
            }
        });

        D4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (D4.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {
                    D4.setImageResource(R.drawable.your_seat_img);
                    String choa1="D4";
                    imb.add(D4);
                    soluongve.setText(imb.size()+"  Chổ");
                    tienve.setText(imb.size()*250000+" VNĐ");
                    vitrive.add(choa1);
                }
                else
                {
                    Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

                }
            }
        });

        D5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (D5.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {
                    D5.setImageResource(R.drawable.your_seat_img);
                    String choa1="D5";
                    imb.add(D5);
                    soluongve.setText(imb.size()+"  Chổ");
                    tienve.setText(imb.size()*250000+" VNĐ");
                    vitrive.add(choa1);
                }
                else
                {
                    Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

                }
            }
        });

        D6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (D6.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {
                    D6.setImageResource(R.drawable.your_seat_img);
                    String choa1="D6";
                    imb.add(D6);
                    soluongve.setText(imb.size()+"  Chổ");
                    tienve.setText(imb.size()*250000+" VNĐ");
                    vitrive.add(choa1);
                }
                else
                {
                    Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

                }
            }
        });

        D7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (D7.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {
                    D7.setImageResource(R.drawable.your_seat_img);
                    String choa1="D7";
                    imb.add(D7);
                    soluongve.setText(imb.size()+"  Chổ");
                    tienve.setText(imb.size()*250000+" VNĐ");
                    vitrive.add(choa1);
                }
                else
                {
                    Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

                }
            }
        });

        D8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (D8.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {
                    D8.setImageResource(R.drawable.your_seat_img);
                    String choa1="D8";
                    imb.add(D8);
                    soluongve.setText(imb.size()+"  Chổ");
                    tienve.setText(imb.size()*250000+" VNĐ");
                    vitrive.add(choa1);
                }
                else
                {
                    Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

                }
            }
        });
        D9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (D9.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.booked).getConstantState())
                {
                    D9.setImageResource(R.drawable.your_seat_img);
                    String choa1="D9";
                    imb.add(D9);
                    soluongve.setText(imb.size()+"  Chổ");
                    tienve.setText(imb.size()*250000+" VNĐ");
                    vitrive.add(choa1);

                }
                else
                {
                    Toast.makeText(DatXeActivity.this, "Chổ Này Đã Có Người Đặt", Toast.LENGTH_SHORT).show();

                }
            }
        });

















    }
    private void getData()
    {
        ArrayList<ChuyenXE> list= new ArrayList<>();
        ArrayList<ChuyenXE> listvexe= new ArrayList<>();
        db.collection("chuyenxe")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Map<String, Object> map= document.getData();
                                String diemdi=map.get("diemdi").toString();
                                String diemden=map.get("diemden").toString();
                                String gio=map.get("gio").toString();
                                String soxe=map.get("soxe").toString();
                                String gia=map.get("gia").toString();

                                ChuyenXE chuyenXE= new ChuyenXE(-1,diemdi,diemden,gio,soxe,gia);
                                chuyenXE.setIdchuyenxe(document.getId());
                                list.add(chuyenXE);





                            }
                            for (int i=0;i<list.size();i++)
                            {


                                if (id_chuyenxe1.equals(list.get(i).getIdchuyenxe()) )
                                {
                                    Log.d("aaaaaa",list.get(i).getDiemdi());
                                    String diemdi23=list.get(i).getDiemdi();
                                    String diemden23=list.get(i).getDiemden();
                                    String gio23=list.get(i).getGio();
                                    String soxe23=list.get(i).getSoxe();
                                    String gia23=list.get(i).getGia();

                                    ChuyenXE chuyenXE23= new ChuyenXE(-1,diemdi23,diemden23,gio23,soxe23,gia23);
                                    chuyenXE23.setIdchuyenxe(list.get(i).getIdchuyenxe());

                                    diemdive.setText(diemdi23);
                                    diemdenve.setText(diemden23);
                                    giochuyendi.setText(gio23);
                                    soxedat=soxe23;
                                    giochuyendidat=gio23;




                                    listvexe.add(chuyenXE23);
                                    id_chuyenxe=chuyenXE23.getIdchuyenxe();
                                    Log.d("aaa",chuyenXE23.getIdchuyenxe());


                                }
                            }
                            Log.d("aaaaaaaaa",list.size()+"");


                        }
                    }
                });

    }






//                       Toast.makeText(DatXeActivity.this, "aa"+imb.size()+listvx.size(), Toast.LENGTH_SHORT).show();
//                   for (int i=0;i<listvx.size();i++)
//                   {
//                       Log.d("aaaaaaaa",listvx.get(i).getVitri()+ listvx.get(i).getGia());
//
//                   }


    public  void onSaveClick(View view)
    {
        String diemdi=diemdive.getText().toString();
        String diemden=diemdenve.getText().toString();
        String giodat=giodatve.getText().toString();
        String giochuyendi=giochuyendidat;
        String soxe=soxedat;
        String gia=tienve.getText().toString();
        String soluongdat=soluongve.getText().toString();
        for (int i=0;i<vitrive.size();i++)
        {
             vitrine=vitrive.get(i).toString();


        }
        String vitrive=vitrine;
        // Create a new user with a first and last name
        Map<String, Object> item = new HashMap<>();
        item.put("diemdi", diemdi);
        item.put("diemden", diemden);
        item.put("gia", gia);
        item.put("giochuyendi",giochuyendi);
        item.put("giodat",giodat);
        item.put("soluongdat",soluongdat);
        item.put("soxe", soxe);
        item.put("vitrive",vitrive);

        if(veXeDat==null)
        {
            // Add a new document with a generated ID
            db.collection("vexelichsu")
                    .add(item)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(DatXeActivity.this, "Insert thành công", Toast.LENGTH_SHORT).show();
                            getData();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });

        }else
        {
            db.collection("vexelichsu").document(veXeDat.getIdvexedat())
                    .set(item)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
//                            onCancelClick(null);
                            Toast.makeText(DatXeActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                            getData();
                            veXeDat=null;
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(DatXeActivity.this, "Cập nhật khôngthành công", Toast.LENGTH_SHORT).show();
                        }
                    });


        }

//        Log.d("TAG", "onSaveClick: "+veXE.getVitri());

        Log.d("TAG", "onSaveClick: "+ VeXE.getVitri());





    }

}