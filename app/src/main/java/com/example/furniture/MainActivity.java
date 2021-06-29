package com.example.furniture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public ImageView IV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentBeranda Fb = new FragmentBeranda();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        IV = (ImageView) findViewById(R.id.imgViewTabLayout);
        BottomNavigationView bottom = findViewById(R.id.menu);

        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        ft.add(R.id.fragment, Fb);
                        ft.replace(R.id.fragment, Fb);
                        ft.commit();

                        IV.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(MainActivity.this, ChoseItem.class));
                            }
                        });
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