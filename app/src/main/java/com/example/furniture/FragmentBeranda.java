package com.example.furniture;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentBeranda extends Fragment {
    private RecyclerView recyclerView;
    private ListAdapter listAdapter;
    private ArrayList<disc> discountArrayList;

    public FragmentBeranda(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewXML);
        ListAdapter listAdapter = new ListAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(listAdapter);

        return view;

    }
}