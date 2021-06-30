package com.example.furniture;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Timer;
import java.util.TimerTask;

public class FragmentBeranda extends Fragment implements View.OnClickListener{
    private RecyclerView recyclerView;

    public FragmentBeranda(){

    }

    //CONSTRUCTOR
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewXML);
        timer();

        //Menangkap Fragment Child
        FragmentManager FM = getChildFragmentManager();
        FM.beginTransaction().replace(R.id.tampilPilihan, new FragmentBarang()).commit();

        BottomNavigationView BikiniBottom = view.findViewById(R.id.pilihan);
        BikiniBottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.all: FM.beginTransaction().replace(R.id.tampilPilihan, new FragmentBarang()).commit();
                        return false;

                    case R.id.Chairs: FM.beginTransaction().replace(R.id.tampilPilihan, new FragmentBarang1()).commit();
                        return false;

                    case R.id.Sofas:  FM.beginTransaction().replace(R.id.tampilPilihan, new FragmentBarang2()).commit();
                        return false;
                }
                return false;
            }
        });

        return view;
    }

    public void onClick(View v) {
    }

    //AUTO SCROLL//
    private void timer(){
        ListAdapter listAdapter = new ListAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listAdapter);
        LinearSnapHelper LSH = new LinearSnapHelper();
        LSH.attachToRecyclerView(recyclerView);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(layoutManager.findLastCompletelyVisibleItemPosition() < (listAdapter.getItemCount() - 1)){
                    layoutManager.smoothScrollToPosition(recyclerView, new RecyclerView.State(), layoutManager.findLastCompletelyVisibleItemPosition() + 1);
                }
                else if(layoutManager.findLastCompletelyVisibleItemPosition() < (listAdapter.getItemCount() - 1)){
                    layoutManager.smoothScrollToPosition(recyclerView, new RecyclerView.State(),0);

                }
            }
        }, 0, 5000);
    }
}