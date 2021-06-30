package com.example.furniture;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class WarnaKursiFragment extends Fragment implements View.OnClickListener{
    private ImageButton btnCoklat;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_warna_kursi, container, false);
        WarnaKursiCoklat mWarnaKursiCoklat = new WarnaKursiCoklat();
        FragmentManager mFragmentManager = getChildFragmentManager();
        btnCoklat = (ImageButton)view.findViewById(R.id.btn_coklat);
        btnCoklat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragmentManager.beginTransaction().replace(R.id.frame_container, mWarnaKursiCoklat).commit();
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {
        }
}