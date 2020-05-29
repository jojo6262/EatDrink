package com.softwareengineer.eatdrink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.andremion.counterfab.CounterFab;
import com.google.android.material.tabs.TabLayout;
import com.softwareengineer.eatdrink.view.cFragmentImage;
import com.softwareengineer.eatdrink.view.cFragmentName;
import com.softwareengineer.eatdrink.view.cFragmentPrice;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    static public List<cFragmentName> list_order = new ArrayList<>();
    static public List<cFragmentPrice> list_price = new ArrayList<>();
    static public List<cFragmentImage> list_img = new ArrayList<>();
    static public CounterFab ii ;
    static public String Table;
    static public int nowid = 1;
    static public int countVodka = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Bundle table = getIntent().getExtras();
        Table =table.getString("Key");
        TextView tt = findViewById(R.id.textView13);
        tt.setText("TABLE"+Table);
        TabLayout TL = findViewById(R.id.tab1);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        MenuFragment fragment = new MenuFragment();
        transaction.replace(R.id.fragment3, fragment);
        transaction.commit();
        TL.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tab.getPosition()) {
                    case 0:
                        MenuFragment fragment = new MenuFragment();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.fragment3, fragment);
                        transaction.commit();
                        break;

                    case 1:
                        CocktailFragment ctfragment = new CocktailFragment();
                        FragmentManager manager1 = getSupportFragmentManager();
                        FragmentTransaction transaction1 = manager1.beginTransaction();
                        transaction1.replace(R.id.fragment3, ctfragment);
                        transaction1.commit();
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

        ii = findViewById(R.id.counter_fab);
        ii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment fragment = new DialogFragment();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment3, fragment);
                transaction.commit();
            }
        });

    }

    public void clearFragment(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        DialogFragment myFragment = new DialogFragment();
        fragmentTransaction.remove(myFragment).commit();
    }


}
