package com.example.furniture;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

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
        return view;
    }

    //AKSI//
    public void onClick(View v) {

        ImageView IV0, IV1, IV2, IV3;
        TextView TVN0,TVN1,TVN2,TVN3, TVH0,TVH1,TVH2,TVH3;

        //ambil data list barang
        IV0 = v.findViewById(R.id.imgViewList0);
        IV1 = v.findViewById(R.id.imgViewList1);
        IV2 = v.findViewById(R.id.imgViewList2);
        IV3 = v.findViewById(R.id.imgViewList3);

        TVN0 = v.findViewById(R.id.tvNamaBarangList0);
        TVN1 = v.findViewById(R.id.tvNamaBarangList1);
        TVN2 = v.findViewById(R.id.tvNamaBarangList2);
        TVN3 = v.findViewById(R.id.tvNamaBarangList3);

        TVH0 = v.findViewById(R.id.tvHargaBarangList0);
        TVH1 = v.findViewById(R.id.tvHargaBarangList1);
        TVH2 = v.findViewById(R.id.tvHargaBarangList2);
        TVH3 = v.findViewById(R.id.tvHargaBarangList3);


        FragmentManager FM = getFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();

        //Ambil layer fragment list_barang
        FragmentBarang FB = new FragmentBarang();
        BottomNavigationView BikiniBottom = v.findViewById(R.id.pilihan);

        //Ambil layer fragment fragmnet_barang1
        FragmentBarang1 FB1 = new FragmentBarang1();

        BikiniBottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.all:
                        IV0.setImageResource(R.drawable.kursi4);
                        TVN0.setText("Oslo Side Chair");
                        TVH0.setText("$250");
                        IV1.setImageResource(R.drawable.kursi2);
                        TVN1.setText("Womb Chair");
                        TVH1.setText("$310");
                        IV2.setImageResource(R.drawable.sofa3);
                        TVN2.setText("Fritz Hansen Sofa");
                        TVH2.setText("$390");
                        IV3.setImageResource(R.drawable.sofa2);
                        TVN3.setText("Scandinavian Sofa");
                        TVH3.setText("$280");
                        FT.replace(R.id.tampilPilihan, FB, FragmentBarang.class.getSimpleName());
                        FT.addToBackStack(null);
                        FT.commit();
                        break;

                    case R.id.Chairs:
                        IV0.setImageResource(R.drawable.kursi4);
                        TVN0.setText("Oslo Side Chair");
                        TVH0.setText("$250");
                        IV1.setImageResource(R.drawable.kursi2);
                        TVN1.setText("Womb Chair");
                        TVH1.setText("$310");


                    case R.id.Sofas:
                        IV0.setImageResource(R.drawable.sofa3);
                        TVN0.setText("Fritz Hansen Sofa");
                        TVH0.setText("$390");
                        IV1.setImageResource(R.drawable.sofa2);
                        TVN1.setText("Scandinavian Sofa");
                        TVH1.setText("$280");


                    case R.id.Beds:

                    case R.id.Tables:

                        FT.replace(R.id.tampilPilihan, FB1, FragmentBarang1.class.getSimpleName());
                        FT.addToBackStack(null);
                        FT.commit();
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