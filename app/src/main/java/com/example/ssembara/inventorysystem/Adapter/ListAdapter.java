package com.example.ssembara.inventorysystem.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.ssembara.inventorysystem.ListActivity;
import com.example.ssembara.inventorysystem.Model.ListModel;
import com.example.ssembara.inventorysystem.R;


import java.util.ArrayList;
public class ListAdapter extends ArrayAdapter<ListModel> {
    private ArrayList<ListModel> dataBarangArrayList;
    private Context context;
    //Membuat Interfece
    public interface dataListener{
        void onDeleteData(ListModel data, int position);
    }
    public ListAdapter(@NonNull Context context,
                             ArrayList<ListModel> dataBarangArrayList){
        super(context, R.layout.activity_view, dataBarangArrayList);
        this.dataBarangArrayList = dataBarangArrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull
            ViewGroup parent){
        ListModel DataBarang = getItem(position);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.activity_view,parent,false);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.id_barang = convertView.findViewById(R.id.id_barang);
        viewHolder.nama_barang =
                convertView.findViewById(R.id.nama_barang);
        viewHolder.harga_barang =
                convertView.findViewById(R.id.harga_barang);
        viewHolder.stok_barang =
                convertView.findViewById(R.id.stok_barang);
        viewHolder.id_barang.setText(DataBarang.getId_barang());
        viewHolder.nama_barang.setText(DataBarang.getNama_barang());
        viewHolder.harga_barang.setText(DataBarang.getHarga_barang());
        viewHolder.stok_barang.setText(DataBarang.getStok_barang());
        return convertView;
    }
    static class ViewHolder {
        public TextView id_barang,nama_barang,harga_barang,stok_barang;
    }
}

