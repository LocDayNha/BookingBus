package com.example.pro1121.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.pro1121.Adapter.ChuyenXeAdapter;
import com.example.pro1121.R;
import com.example.pro1121.model.ChuyenXE;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChuyenXeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChuyenXeFragment extends Fragment  {


    private ArrayList<ChuyenXE> chuyenxes;
    private ListView lvFrgChuyenXe;
    private TimChuyenFragment frg;

    public ChuyenXeFragment() {
        // Required empty public constructor
    }



    public static ChuyenXeFragment newInstance(ArrayList<ChuyenXE> chuyenxes) {


        ChuyenXeFragment fragment = new ChuyenXeFragment();
        Bundle args = new Bundle();
        args.putSerializable("chuyenxe", chuyenxes);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            chuyenxes = (ArrayList<ChuyenXE>) getArguments().getSerializable("chuyenxe");
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
        lvFrgChuyenXe=view.findViewById(R.id.lvFrgChuyenXe);
        ChuyenXeAdapter adapter=new ChuyenXeAdapter(chuyenxes,getContext(),getActivity());
        lvFrgChuyenXe.setAdapter(adapter);
        lvFrgChuyenXe.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ChuyenXE chuyenXE=(ChuyenXE) parent.getItemAtPosition(position);
                // truyen ra activyti
//                ChuyenXeActivity activity= (ChuyenXeActivity) view.getContext();
//                activity.onCoursesItemClick(course);
                return true;
            }
        });
    }
}