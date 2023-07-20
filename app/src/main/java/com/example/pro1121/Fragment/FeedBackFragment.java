package com.example.pro1121.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.pro1121.HuongDan.LoadActivity;
import com.example.pro1121.R;
import com.example.pro1121.view.MainActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FeedBackFragment extends Fragment {
    private Button btnFeedBack, btnGetFeedBack;
    private EditText edtFeedBack, edtFeedBackEmail, edtSDT;
    private TextView get_data1, get_data2, get_data3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);

        btnFeedBack = view.findViewById(R.id.btnFeedBack);
        btnGetFeedBack = view.findViewById(R.id.btnGetFeedBack);
        edtFeedBack = view.findViewById(R.id.edtFeedBack);
        edtFeedBackEmail = view.findViewById(R.id.edtFeedBackEmail);
        edtSDT = view.findViewById(R.id.edtSDT);
        get_data1 = view.findViewById(R.id.get_data1);
        get_data2 = view.findViewById(R.id.get_data2);
        get_data3 = view.findViewById(R.id.get_data3);

        setProFile();

        btnFeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickFeedBack();
            }
        });

        btnGetFeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readDatabase();
            }
        });

        return view;
    }

    private void onClickFeedBack(){
        String feedback ="feedback/";
        int id=0;
        id+=1;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(feedback + id + "/email");
        myRef.setValue(edtFeedBackEmail.getText().toString().trim());
        DatabaseReference myRef1 = database.getReference(feedback + id + "/phone");
        myRef1.setValue(edtSDT.getText().toString().trim());
        DatabaseReference myRef2 = database.getReference(feedback + id + "/cmt");
        myRef2.setValue(edtFeedBack.getText().toString().trim(), new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Toast.makeText(getActivity(), "Gửi thành công !!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void readDatabase(){
        String feedback ="feedback/";
        int id=0;
        id+=1;
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference( feedback + id + "/email");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                get_data1.setText(value);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        DatabaseReference myRef1 = database.getReference( feedback + id + "/phone");
        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                get_data2.setText(value);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        DatabaseReference myRef2 = database.getReference( feedback + id + "/cmt");
        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                get_data3.setText(value);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }

    private void setProFile(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null){
            return;
        }
        edtFeedBackEmail.setText(user.getEmail());
        Log.d("<><><><><>TAG", "setProFile: ");
    }

}
