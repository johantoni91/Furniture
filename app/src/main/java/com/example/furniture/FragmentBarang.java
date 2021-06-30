package com.example.furniture;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;


public class FragmentBarang extends Fragment {

    public FragmentBarang() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_barang, container, false);
        Intent i = new Intent(getActivity(), ChoseItem.class);
        ImageButton IB = v.findViewById(R.id.imgViewList0);
        IB.setOnClickListener(v1 -> startActivity(i));
        return v;
    }
}
