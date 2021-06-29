package com.example.furniture;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ListChairsAdapter extends RecyclerView.Adapter {

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_barang, parent, false);
        return new ListViewBarangHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewBarangHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return listItems.imgChairsTabLayout.length;
    }

    private class ListViewBarangHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView tombolGambar;
        private TextView Nama, Harga;

        public ListViewBarangHolder(View itemView){
            super(itemView);
            tombolGambar = (ImageView) itemView.findViewById(R.id.imgViewTabLayout);
            Nama = (TextView) itemView.findViewById(R.id.tvNamaBarangTabLayout);
            Harga = (TextView) itemView.findViewById(R.id.tvHargaBarangTabLayout);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            tombolGambar.setImageResource(listItems.imgChairsTabLayout[position]);
            Nama.setText(listItems.NamaKursi[position]);
            Harga.setText(listItems.hargaKursi[position]);
        }

        public void onClick(View view){

        }
    }

}
