package com.example.furniture;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

public class FragmentBeranda extends Fragment implements View.OnClickListener{
    private RecyclerView RCV,recyclerView;
    private TabLayout tabLayout;

    public FragmentBeranda(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewXML);
        ListAdapter listAdapter = new ListAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(listAdapter);

        return view;
    }

    public void onClick(View v) {
        RCV = v.findViewById(R.id.rcvTabLayout);
        ListChairsAdapter LCA = new ListChairsAdapter();
        ListSofasAdapter LSA = new ListSofasAdapter();
        ListAllAdapter LAA = new ListAllAdapter();
        tabLayout = (TabLayout) v.findViewById(R.id.tabLayoutXML);
        tabLayout.addTab(tabLayout.newTab().setText("All"));
        tabLayout.addTab(tabLayout.newTab().setText("Chairs"));
        tabLayout.addTab(tabLayout.newTab().setText("Sofas"));
        tabLayout.addTab(tabLayout.newTab().setText("Beds"));
        tabLayout.addTab(tabLayout.newTab().setText("Tables"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        RCV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                        RCV.setAdapter(LAA);
                        break;

                    case 1:
                        RCV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                        RCV.setAdapter(LCA);
                        break;

                    case 2:
                        RCV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                        RCV.setAdapter(LSA);
                        break;

                    case 3:
                        break;

                    case 4:
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
    }
}