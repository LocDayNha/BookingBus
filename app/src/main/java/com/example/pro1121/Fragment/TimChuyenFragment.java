package com.example.pro1121.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.pro1121.Adapter.IAdapterClickEvent;
import com.example.pro1121.R;

import com.example.pro1121.model.ChuyenXE;


import com.example.pro1121.view.DatXeActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;


public class TimChuyenFragment extends Fragment {
    private ArrayList<ChuyenXE> chuyenxes;
    EditText diemden1;
    private EditText diemdi1;
    Button btntim;
    ImageButton chuyendoi;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ChuyenXE chuyenXE=null;
    private View view;
    public String id_chuyenxe;
//    private TruyenId mTruyenId;
//
////    public interface  TruyenId{
////        void Truyendata(String idchuyenxedat);
////    }

//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        if (context instanceof TruyenId ){
//            mTruyenId= (TruyenId) getActivity();
//        } else {
//            throw new RuntimeException(context.toString() + " must implement onViewSelected");
//        }
//
//    }

    public TimChuyenFragment() {

    }

//    // TODO: Rename and change types and number of parameters
    public static TimChuyenFragment newInstance(ArrayList<ChuyenXE> chuyenxes) {
        TimChuyenFragment fragment = new TimChuyenFragment();
        Bundle args = new Bundle();
        args.putSerializable("chuyenxe", chuyenxes);

        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            chuyenxes = (ArrayList<ChuyenXE>)
                    getArguments().getSerializable("chuyenxe");
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_tim_chuyen,container,false);
        diemdi1=view.findViewById(R.id.diemdi);
        diemden1=view.findViewById(R.id.diemden);
        btntim=view.findViewById(R.id.btntim);
        chuyendoi=view.findViewById(R.id.chuyendoi);
        chuyendoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String diemdichuyendoi=diemdi1.getText().toString();
                String diemdenchuyendoi=diemden1.getText().toString();
                diemdi1.setText(diemdenchuyendoi);
                diemden1.setText(diemdichuyendoi);
            }
        });
        btntim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();

            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getData();
    }
    private void getData()
    {
        ArrayList<ChuyenXE> list= new ArrayList<>();
        ArrayList<ChuyenXE> list2= new ArrayList<>();
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
                            String diemdi2=diemdi1.getText().toString();
                            String diemden2=diemden1.getText().toString();

                            for (int i=0;i<list.size();i++)
                            {

                                if (diemdi2.equals(list.get(i).getDiemdi())|| diemden2.equals(list.get(i).getDiemden()) )
                                {
                                    Log.d("aaaaaa",list.get(i).getDiemdi());
                                    String diemdi23=list.get(i).getDiemdi();
                                    String diemden23=list.get(i).getDiemden();
                                    String gio23=list.get(i).getGio();
                                    String soxe23=list.get(i).getSoxe();
                                    String gia23=list.get(i).getGia();

                                    ChuyenXE chuyenXE23= new ChuyenXE(-1,diemdi23,diemden23,gio23,soxe23,gia23);
                                    chuyenXE23.setIdchuyenxe(list.get(i).getIdchuyenxe());

                                    list2.add(chuyenXE23);
                                    id_chuyenxe=chuyenXE23.getIdchuyenxe();
                                    Log.d("aaa",chuyenXE23.getIdchuyenxe());


                                }
                            }
                            Log.d("aaaaaaaaa",list.size()+"");


                            getActivity().getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.frltimchuyen, ChuyenXeFragment.newInstance(list2)).commit();
                        }
                    }
                });

    }



}