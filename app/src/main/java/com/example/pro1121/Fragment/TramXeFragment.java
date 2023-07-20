package com.example.pro1121.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pro1121.Adapter.TramXeAdapter;
import com.example.pro1121.R;
import com.example.pro1121.model.TramXe;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TramXeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TramXeFragment extends Fragment  {


    private ArrayList<TramXe> tramXes;
    private ListView lvFrgTramXe;

    public TramXeFragment() {
        // Required empty public constructor
    }



    public static TramXeFragment newInstance(ArrayList<TramXe> tramXes) {


        TramXeFragment fragment = new TramXeFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chuyen_xe, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvFrgTramXe=view.findViewById(R.id.lvFrgChuyenXe);

        TramXeAdapter adapter = new TramXeAdapter(tramXes,getContext());
        lvFrgTramXe.setAdapter(adapter);
        lvFrgTramXe.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TramXe tramXe=(TramXe) parent.getItemAtPosition(position);
                // truyen ra activyti
//                ChuyenXeActivity activity= (ChuyenXeActivity) view.getContext();
//                activity.onCoursesItemClick(course);
                return true;
            }
        });
    }
}