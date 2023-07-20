package com.example.pro1121.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pro1121.Adapter.IAdapterClickEvent;
import com.example.pro1121.Fragment.ChuyenXeFragment;
import com.example.pro1121.R;
import com.example.pro1121.model.ChuyenXE;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChuyenXeActivity extends AppCompatActivity implements IAdapterClickEvent {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private EditText edtdiemdi,edtdiemden,edtgio,edtsoxe,edtgia;
    private ChuyenXE chuyenXE=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuyen_xe);
        edtdiemdi=findViewById(R.id.edtdiemdi);
        edtdiemden=findViewById(R.id.edtdiemden);
        edtgio=findViewById(R.id.edtgio);
        edtsoxe=findViewById(R.id.edtsoxe);
        edtgia=findViewById(R.id.edtgia);



    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }
    public  void onSaveClick(View view)
    {
        String diemdi=edtdiemdi.getText().toString();
        String diemden=edtdiemden.getText().toString();
        String gio=edtgio.getText().toString();
        String soxe=edtsoxe.getText().toString();
        String gia=edtgia.getText().toString();
        // Create a new user with a first and last name
        Map<String, Object> item = new HashMap<>();
        item.put("diemdi", diemdi);
        item.put("diemden", diemden);
        item.put("gio", gio);
        item.put("soxe", soxe);
        item.put("gia",gia);

        if(chuyenXE==null)
        {
            // Add a new document with a generated ID
            db.collection("chuyenxe")
                    .add(item)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(ChuyenXeActivity.this, "Insert thành công", Toast.LENGTH_SHORT).show();
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
            db.collection("chuyenxe").document(chuyenXE.getIdchuyenxe())
                    .set(item)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            onCancelClick(null);
                            Toast.makeText(ChuyenXeActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                            getData();
                            chuyenXE=null;
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(ChuyenXeActivity.this, "Cập nhật khôngthành công", Toast.LENGTH_SHORT).show();
                        }
                    });


        }




    }
    public void onCancelClick(View view)
    {
        edtdiemdi.setText(null);
        edtdiemden.setText(null);
        edtgio.setText(null);
        edtsoxe.setText(null);
        edtgia.setText(null);
    }
    private  void getData()
    {
        db.collection("chuyenxe")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<ChuyenXE> list= new ArrayList<>();
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
//                                for (int i=0;i<list.size();i++)
//                                {
//                                    EditText aa=findViewById(R.id.aa);
//                                    aa.setText(list.get(i).getDiemdi());
//
//
//                                }


                            }


                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.flChuyenxe, ChuyenXeFragment.newInstance(list)).commit();
                        }
                    }
                });
    }


    @Override
    public void onEditChuyenXeClick(ChuyenXE chuyenxe) {
        edtdiemdi.setText(chuyenxe.getDiemdi());
        edtdiemden.setText(chuyenxe.getDiemden());
        edtgio.setText(chuyenxe.getGio());
        edtsoxe.setText(chuyenxe.getSoxe());
        edtgia.setText(chuyenxe.getGia());
        chuyenXE=chuyenxe;

    }

    @Override
    public void onDeleteChuyenXeClick(ChuyenXE chuyenXE) {
        new AlertDialog.Builder(ChuyenXeActivity.this)
                .setTitle("Xóa")
                .setMessage("Xóa sẽ không phục hồi đc")
                .setNegativeButton("Hủy",null)
                .setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        db.collection("chuyenxe").document(chuyenXE.getIdchuyenxe())
                                .delete()
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(ChuyenXeActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                                        getData();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ChuyenXeActivity.this, "Xóa không thành công", Toast.LENGTH_SHORT).show();

                                    }
                                });


                    }
                })
                .show();

    }

    @Override
    public void onDatXeClick() {

    }


}