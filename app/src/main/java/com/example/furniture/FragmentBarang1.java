package com.example.furniture;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class FragmentBarang1 extends Fragment implements View.OnClickListener{
    public ImageButton IB;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public FragmentBarang1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_barang1, container, false);

        //Intent intent = new Intent(getContext(), ChoseItem.class);
        IB = (ImageButton)v.findViewById(R.id.bangkuIjo);
        IB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail();
            }
        });

        return v;
    }

    public void updateDetail() {
        Intent intent = new Intent(getActivity(), ChoseItem.class);
        startActivity(intent);
    }

    public void onClick(View v){

    }
}