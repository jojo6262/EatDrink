package com.softwareengineer.eatdrink;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.softwareengineer.eatdrink.view.CookCountView;
import com.softwareengineer.eatdrink.view.CookMenuView;
import com.softwareengineer.eatdrink.view.CookOrderView;
import com.softwareengineer.eatdrink.view.CookPriceView;
import com.softwareengineer.eatdrink.view.CookView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CookActivity extends AppCompatActivity {
    DatabaseReference show;
    private String Tag;
    private TextView txttest;
    protected List<CookView> cvList;
    protected List<CookPriceView> cpvList;
    protected List<CookOrderView> covList;
    protected List<CookMenuView> cmvList;
    protected List<CookCountView> ccvList;
    RecyclerView recycleCook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook);

        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference().child("");

        final HashMap<String, Object> postValues = new HashMap<>();

        Map<String, Object> childUpdates = new HashMap<>();

        mRootRef.updateChildren(childUpdates);

        cvList = new ArrayList<>();
        cpvList = new ArrayList<>();
        covList = new ArrayList<>();
        cmvList = new ArrayList<>();
        ccvList = new ArrayList<>();
        mRootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                String na = "";
                String price = "";
                String order="";
                String menu="";
                String count="";


                for (DataSnapshot postSnapshot: snapshot.getChildren()) {


                    DataSnapshot userMessagesSnapshot = postSnapshot.child("allmenu");
                    for (DataSnapshot postMS: userMessagesSnapshot.getChildren()){
                        na = postMS.child("name").getValue().toString();
                        System.out.println(na);
                        if (na.equals("0") ) {


                        }
                        else
                            {
                            price = postMS.child("price").getValue().toString();
                            order = postMS.child("idorder").getValue().toString();
                            //menu = postMS.child("IDMenu").getValue().toString();
                            count = postMS.child("countOrder").getValue().toString();
                            cvList.add(new CookView(na));
                            cpvList.add(new CookPriceView(price));
                            covList.add(new CookOrderView(order));
                            //cmvList.add(new CookMenuView(menu));
                            ccvList.add(new CookCountView(count));
                        }



                    }


                    DataSnapshot usersSnapshot = postSnapshot.child("");
                    for (DataSnapshot postMS: usersSnapshot.getChildren()){

                    }
                }
                System.out.println(cvList.size());
                createRecycle(cvList,cpvList,covList,ccvList);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });




    }



    private void createRecycle(List<CookView> cvList,List<CookPriceView> cpvList,List<CookOrderView> covList,List<CookCountView> ccvList){
        recycleCook = findViewById(R.id.rc_cook);
        recycleCook.setLayoutManager(new LinearLayoutManager(this));
        recycleCook.setAdapter(new cook_adapter(cvList,cpvList,covList,ccvList,this));
    }

    private void getData(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()){

        }
        Log.d(Tag, "--------------------------------------------------------------");
    }

}