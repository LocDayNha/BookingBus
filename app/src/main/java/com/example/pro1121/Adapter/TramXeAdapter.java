package com.example.pro1121.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pro1121.R;
import com.example.pro1121.model.TramXe;

import java.util.ArrayList;

public class TramXeAdapter extends BaseAdapter {
    private ArrayList<TramXe> list;
    private Context context;

    public TramXeAdapter(ArrayList<TramXe> list,Context context) {
        this.context = context;
        this.list = list;
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
            view = View.inflate(_viewGroup.getContext(), R.layout.item_recycler_tramxe, null);
            TextView tenTram = view.findViewById(R.id.txtTenTram);
            TextView viTri = view.findViewById(R.id.txtViTri);
            ImageButton btnedit = view.findViewById(R.id.ivEdit);

            ViewHolder holder = new ViewHolder(tenTram,viTri, btnedit);
            view.setTag(holder);
        }
        TramXe tramXe = (TramXe) getItem(_i);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.tenTram.setText(tramXe.getTenTram());
        holder.viTri.setText(tramXe.getViTri());



        holder.btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //IAdapterClickEvent1 iAdapterClickEvent = (IAdapterClickEvent1) _viewGroup.getContext();
                String latitude = "10.7604961";
                String longitude = "106.6724924";
                String uri = "https://www.google.com.tw/maps/place/" + latitude + "," + longitude;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                context.startActivity(intent);

            }
        });
//        holder.btndelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                IAdapterClickEvent1 iAdapterClickEvent = (IAdapterClickEvent1) _viewGroup.getContext();
//                iAdapterClickEvent.onDeleteChuyenXeClick(tramXe);
//            }
//        });
        return view;
    }
    private static class ViewHolder{
        final TextView tenTram,viTri;
        final ImageButton btnedit;

        public ViewHolder(TextView tenTram,TextView viTri,ImageButton btnedit) {
            this.tenTram= tenTram;
            this.viTri= viTri;
            this.btnedit = btnedit;

        }
    }

}
