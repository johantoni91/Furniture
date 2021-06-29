package com.example.furniture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentBeranda Fb = new FragmentBeranda();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        BottomNavigationView bottom = findViewById(R.id.menu);

        tabLayout = (TabLayout) findViewById(R.id.tabLayoutXML);
        tabLayout.addTab(tabLayout.newTab().setText("All"));
        tabLayout.addTab(tabLayout.newTab().setText("Chairs"));
        tabLayout.addTab(tabLayout.newTab().setText("Sofas"));
        tabLayout.addTab(tabLayout.newTab().setText("Beds"));
        tabLayout.addTab(tabLayout.newTab().setText("Tables"));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        ft.add(R.id.fragment, Fb);
                        ft.replace(R.id.fragment, Fb);
                        ft.commit();
                        return false;

                    case R.id.favourite:
                        return false;

                    case R.id.belanja:
                        return false;

                    case R.id.profile:
                        return false;
                }return false;
            }
        });
    }
}