package com.example.furniture;

import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ChoseItem extends AppCompatActivity {
    public int hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_item);
        WarnaKursiFragment WFH = new WarnaKursiFragment();

        FragmentManager mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(R.id.frame_container, WFH).commit();
        addCart();
    }

    public void addCart(){
        TextView TVhasil = findViewById(R.id.TVhasil);
        Button BTkurang = findViewById(R.id.BTkurang);
        Button BTnambah = findViewById(R.id.BTnambah);

        BTkurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hasil = Integer.parseInt(String.valueOf(TVhasil.getText()));
                if(hasil == 1){
                    BTkurang.setClickable(false);
                    BTkurang.setActivated(false);
                } else{
                    hasil--;
                }
                TVhasil.setText(hasil);
            }
        });

        BTnambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hasil = Integer.parseInt(String.valueOf(TVhasil.getText()));
                hasil++;
                TVhasil.setText(hasil);
            }
        });
    }
}