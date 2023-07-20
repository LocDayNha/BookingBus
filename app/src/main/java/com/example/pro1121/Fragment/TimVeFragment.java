package com.example.pro1121.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pro1121.Adapter.VeXeAdapter;
import com.example.pro1121.R;
import com.example.pro1121.model.LichSuVeXe;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TimVeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimVeFragment extends Fragment {
    private ArrayList<LichSuVeXe> veXes;
    VeXeAdapter veXeAdapter;
   TimVeFragment timVeFragment;
    private ListView lvVeXe;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private LichSuVeXe veXe=null;

    public TimVeFragment() {
        // Required empty public constructor
    }


    public static TimVeFragment newInstance(ArrayList<LichSuVeXe> veXes) {
        TimVeFragment fragment = new TimVeFragment();
        Bundle args = new Bundle();
        args.putSerializable("vexe", veXes);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            veXes = (ArrayList<LichSuVeXe>) getArguments().getSerializable("vexe");
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tim_ve, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvVeXe = view .findViewById(R.id.lvVeXE);
        getData();
//        lvVeXe.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                VeXE tramXe=(VeXE) parent.getItemAtPosition(position);
//                return false;
//            }
//        });
    }

    @Override
    public void onResume() {
        super.onResume();
        getData();
    }
    public void getData() {
        db.collection("vexelichsu")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<LichSuVeXe> list = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Map<String, Object> map = document.getData();
                                String diemDen = map.get("diemden").toString();
                                String diemDi = map.get("diemdi").toString();
                                String gia = map.get("gia").toString();
                                String gioChuyenDi = map.get("giochuyendi").toString();
                                String giodat = map.get("giodat").toString();
                                String soluongcho = map.get("soluongdat").toString();
                                String soxe = map.get("soxe").toString();
                                String viTriGhe = map.get("vitrive").toString();
                                LichSuVeXe veXe = new LichSuVeXe(document.getId(), diemDen, diemDi, gia, gioChuyenDi, giodat, soluongcho, soxe, viTriGhe);
                                veXe.setIdVeXe(document.getId());

                                Log.d("TAG>>>>>", "onComplete: " + document.getId());
                                list.add(veXe);

                            }
                            veXes = list;
                            veXeAdapter = new VeXeAdapter(veXes, TimVeFragment.this);
                            lvVeXe.setAdapter(veXeAdapter);

                        }
                    }

                });
    }

}