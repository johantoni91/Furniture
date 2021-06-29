package com.example.furniture;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;

public class FragmentBeranda extends Fragment {
    public TabLayout tabLayout;

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

        tabLayout = (TabLayout) view.findViewById(R.id.tabLayoutXML);
        tabLayout.addTab(tabLayout.newTab().setText("All"));
        tabLayout.addTab(tabLayout.newTab().setText("Chairs"));
        tabLayout.addTab(tabLayout.newTab().setText("Sofas"));
        tabLayout.addTab(tabLayout.newTab().setText("Beds"));
        tabLayout.addTab(tabLayout.newTab().setText("Tables"));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.tabLayoutXML);
                switch (tab.getPosition()){
                    case 0:
                        view.addOnLayoutChangeListener(view.findViewById(R.id.tampil));
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    public FragmentBeranda(TabLayout tabLayout) {
        this.tabLayout = tabLayout;
    }

    public FragmentBeranda(int contentLayoutId, TabLayout tabLayout) {
        super(contentLayoutId);
        this.tabLayout = tabLayout;
    }
}