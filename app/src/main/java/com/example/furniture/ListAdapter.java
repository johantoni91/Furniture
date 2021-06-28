package com.example.furniture;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ListAdapter extends RecyclerView.Adapter{

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_diskon, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return disc.namaBarang.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mItemText;
        private TextView mDiscounts;
        private ImageView mObjects;

        public ListViewHolder(View itemView){
            super(itemView);
            mItemText   = (TextView) itemView.findViewById(R.id.Tv_barang);
            mDiscounts  = (TextView) itemView.findViewById(R.id.Tv_diskon);
            mObjects    = (ImageView) itemView.findViewById(R.id.gambar);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            mItemText.setText(disc.namaBarang[position]);
            mDiscounts.setText(disc.jmlDiskon[position]);
            mObjects.setImageResource(disc.image[position]);
        }

        public void onClick(View view){

        }
    }
}
