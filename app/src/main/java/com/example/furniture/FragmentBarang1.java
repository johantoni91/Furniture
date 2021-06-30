package com.example.furniture;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class FragmentBarang1 extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_barang1, container, false);
        Intent intent = new Intent(getActivity(), ChoseItem.class);
        ImageButton IB = v.findViewById(R.id.imgViewListv2);
        IB.setOnClickListener(v1 -> startActivity(intent));
        return v;
    }
}