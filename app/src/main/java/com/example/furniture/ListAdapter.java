package com.example.furniture;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        return listItems.namaBarang.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mItemText;
        private TextView mDiscounts;
        private ImageView mObjects;
        private FrameLayout FLdiskon;
        private RelativeLayout RL1;

        public ListViewHolder(View itemView){
            super(itemView);
            mItemText   = (TextView) itemView.findViewById(R.id.Tv_barang);
            mDiscounts  = (TextView) itemView.findViewById(R.id.Tv_diskon);
            mObjects    = (ImageView) itemView.findViewById(R.id.gambar);
            FLdiskon    = (FrameLayout) itemView.findViewById(R.id.FLdiskon);
            RL1         = (RelativeLayout) itemView.findViewById(R.id.RL1);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            mItemText.setText(listItems.namaBarang[position]);
            mDiscounts.setText(listItems.jmlDiskon[position]);
            mObjects.setImageResource(listItems.image[position]);
            FLdiskon.setBackgroundColor(listItems.Bg[position]);
            FLdiskon.setBackgroundResource(listItems.BGrl[position]);
        }

        public void onClick(View view){

        }
    }
}
