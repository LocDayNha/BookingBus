package com.example.pro1121.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pro1121.Fragment.ChuyenXeFragment;
import com.example.pro1121.Fragment.DatVeFragment;
import com.example.pro1121.Fragment.TimChuyenFragment;
import com.example.pro1121.Fragment.TinTucFragment;

import com.example.pro1121.R;
import com.example.pro1121.model.ChuyenXE;
import com.example.pro1121.view.DatXeActivity;

import java.util.ArrayList;

public class ChuyenXeAdapter extends BaseAdapter {
    private ArrayList<ChuyenXE> list;
    private TimChuyenFragment abc;

    private Context context;
    private Activity activity;

    public ChuyenXeAdapter(ArrayList<ChuyenXE> list,Context context,Activity activity) {

        this.list = list;
        this.context=context;
        this.activity=activity;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int _i, View _view, ViewGroup _viewGroup) {
        View view = _view;
        if (view == null) {
            view = View.inflate(_viewGroup.getContext(), R.layout.one_item_chuyenxe, null);
            TextView chuyenxeDiemdi = view.findViewById(R.id.chuyenxeDiemdi);
            TextView chuyenxeDiemden = view.findViewById(R.id.chuyenxeDiemden);
            TextView chuyenxeGio = view.findViewById(R.id.chuyenxeGio);
            TextView chuyenxeSoxe = view.findViewById(R.id.chuyenxeSoxe);
            TextView chuyenxeGia = view.findViewById(R.id.chuyenxeGia);
            Button btndatxe=view.findViewById(R.id.btndatxe);
            ImageButton btnedit = view.findViewById(R.id.btnedit);
            ImageButton btndelete = view.findViewById(R.id.btndelete);
            ViewHolder holder = new ViewHolder(chuyenxeDiemdi, chuyenxeDiemden, chuyenxeGio, chuyenxeSoxe,chuyenxeGia, btnedit, btndelete,btndatxe);
            view.setTag(holder);
        }
        ChuyenXE chuyenXE = (ChuyenXE) getItem(_i);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.chuyenxeDiemdi.setText((chuyenXE.getDiemdi()));
        holder.chuyenxeDiemden.setText((chuyenXE.getDiemden()));
        holder.chuyenxeGio.setText((chuyenXE.getGio()));
        holder.chuyenxeSoxe.setText((chuyenXE.getSoxe()));
        holder.chuyenxeGia.setText(chuyenXE.getGia());
        holder.btndatxe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Intent intent= new Intent(context, DatXeActivity.class);
               intent.putExtra("id",chuyenXE.getIdchuyenxe());
            context.startActivity(intent);



            }
        });

        holder.btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IAdapterClickEvent iAdapterClickEvent = (IAdapterClickEvent) _viewGroup.getContext();
                iAdapterClickEvent.onEditChuyenXeClick(chuyenXE);

            }
        });
        holder.btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IAdapterClickEvent iAdapterClickEvent = (IAdapterClickEvent) _viewGroup.getContext();
                iAdapterClickEvent.onDeleteChuyenXeClick(chuyenXE);
            }
        });
        return view;
    }
    private static class ViewHolder{
        final TextView chuyenxeDiemdi,chuyenxeDiemden,chuyenxeGio,chuyenxeSoxe,chuyenxeGia;
        final ImageButton btnedit,btndelete;
        final Button btndatxe;

        public ViewHolder(TextView chuyenxeDiemdi, TextView chuyenxeDiemden, TextView chuyenxeGio, TextView chuyenxeSoxe,TextView chuyenxeGia,ImageButton btnedit,ImageButton btndelete,Button btndatxe) {
            this.chuyenxeDiemdi = chuyenxeDiemdi;
            this.chuyenxeDiemden = chuyenxeDiemden;
            this.chuyenxeGio = chuyenxeGio;
            this.chuyenxeSoxe = chuyenxeSoxe;
            this.chuyenxeGia=chuyenxeGia;
            this.btnedit = btnedit;
            this.btndelete = btndelete;
            this.btndatxe=btndatxe;
        }
    }

}
