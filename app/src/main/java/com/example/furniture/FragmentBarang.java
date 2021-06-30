package com.example.furniture;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;


public class FragmentBarang extends Fragment implements View.OnClickListener{
    public ImageButton IB;
    public FragmentBarang() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_barang, container, false);

        Intent intent = new Intent(getContext(), ChoseItem.class);
        IB = v.findViewById(R.id.bangkuIjo);
        IB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        return v;
    }

    @Override
    public void onClick(View v) {

    }
}
