package com.example.furniture;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.Timer;
import java.util.TimerTask;

public class FragmentBeranda extends Fragment {
    private RecyclerView recyclerView;

    public FragmentBeranda(){

    }

    //CONSTRUCTOR
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewXML);
        timer();
        onClick(container);
        return view;
    }

    //Pindah Fragment
    public boolean loadFragment(Fragment fragment){
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(fragment != null){
            ft.replace(R.id.tampilPilihan, fragment).commit();
            return true;
        } return false;
    }

    //AKSI//
    public void onClick(View v) {
        FragmentManager FM = getFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        FragmentBarang FB = new FragmentBarang();
        FragmentBarang1 FB1 = new FragmentBarang1();
        FragmentBarang2 FB2 = new FragmentBarang2();
        FT.add(R.id.tampilPilihan, FB).addToBackStack(null).commit();
        BottomNavigationView BikiniBottom = v.findViewById(R.id.pilihan);
        BikiniBottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.all: FT.replace(R.id.tampilPilihan, FB).addToBackStack(null).commit();
                    break;

                    case R.id.Chairs: FT.add(R.id.tampilPilihan, FB1).addToBackStack(null).commit();
                    break;

                    case R.id.Sofas:  FT.add(R.id.tampilPilihan, FB2).addToBackStack(null).commit();
                    break;
                }
                return false;
            }
        });
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
        }, 0, 3000);
    }
}