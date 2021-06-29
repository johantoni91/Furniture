package com.example.furniture;

import android.content.ClipData;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


public class FragmentBarang extends Fragment implements View.OnClickListener {

    public FragmentBarang() {
    }

    public FragmentBarang(int contentLayoutId) {
        super(contentLayoutId);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_barang, container, false);
        return v;
    }

    @Override
    public void onClick(View v) {

    }
}
