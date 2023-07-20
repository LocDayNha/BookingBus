package com.example.pro1121.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.pro1121.R;
import com.example.pro1121.model.TramXe;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TimTramFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimTramFragment extends Fragment {
    private ArrayList<TramXe> tramXes;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private TramXe tramXe=null;

    public TimTramFragment() {

    }


    // TODO: Rename and change types and number of parameters
    public static TimTramFragment newInstance(ArrayList<TramXe> tramXes) {
        TimTramFragment fragment = new TimTramFragment();
        Bundle args = new Bundle();
        args.putSerializable("tramxe", tramXes);

        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tramXes = (ArrayList<TramXe>) getArguments().getSerializable("tramxe");
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tim_tram,container,false);

        getData();
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
        db.collection("tramxe")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<TramXe> list= new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Map<String, Object> map = document.getData();
                                String tenTram = map.get("tenTram").toString();
                                String viTri = map.get("viTri").toString();

                                TramXe tramXe=new TramXe(-1,tenTram,viTri);

                                tramXe.setIdTramXe(document.getId());
                                list.add(tramXe);

                            }
                            getActivity().getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.frltimtram, TramXeFragment.newInstance(list)).commit();
                        }
                    }


                });
    }

}