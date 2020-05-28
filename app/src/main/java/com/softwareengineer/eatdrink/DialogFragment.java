package com.softwareengineer.eatdrink;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.softwareengineer.eatdrink.adapter.cartAdapter;
import com.softwareengineer.eatdrink.model.Chef;
import com.softwareengineer.eatdrink.model.Order;
import com.softwareengineer.eatdrink.view.cFragmentImage;
import com.softwareengineer.eatdrink.view.cFragmentName;
import com.softwareengineer.eatdrink.view.cFragmentPrice;


import java.util.ArrayList;
import java.util.List;


public class DialogFragment extends Fragment {

    RecyclerView rc;
    TextView total;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_dialog, container, false);
        if(MenuActivity.list_img.size()!=0){
            createRecycle(view,MenuActivity.list_order,MenuActivity.list_img,MenuActivity.list_price);
            int totalprice = 0;
            for(int i =0;i<MenuActivity.list_price.size();i++){
                cFragmentPrice cc =  MenuActivity.list_price.get(i);
                int  price = Integer.parseInt(cc.cFragmentPrice);
                totalprice= totalprice+price;
            }
            System.out.println("////////////"+totalprice);
            total = view.findViewById(R.id.textView12);
            total.setText(""+totalprice);
        }else{
            Toast.makeText(getActivity(),"No Order",Toast.LENGTH_LONG );
        }

        final List<cFragmentName> newOrder;
        newOrder = MenuActivity.list_order;
        final List<cFragmentPrice> newOrderprice ;
        newOrderprice = MenuActivity.list_price;
        Button or = view.findViewById(R.id.button);
        or.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference().child("tbd_cashier/Table"+MenuActivity.Table+"/");
                DatabaseReference mCookRef = FirebaseDatabase.getInstance().getReference().child("user-messages/allmenu/");
                if(newOrder.size() !=0){
                    for(int i=0;i<newOrder.size();i++){
                        cFragmentName cn = newOrder.get(i);
                        cFragmentPrice cc =  newOrderprice.get(i);
                        String price = cc.cFragmentPrice;
                        String name = cn.cFragmentName;
                        String count = "1";
                        Order order = new Order(name,Integer.parseInt(count),Integer.parseInt(price),"1");
                        Chef chef = new Chef("T"+MenuActivity.Table+"-"+MenuActivity.nowid,name,count,price);
                        mRootRef.child("id"+MenuActivity.nowid).setValue(order);
                        mCookRef.child("menu-T"+MenuActivity.Table+"-"+MenuActivity.nowid).setValue(chef);
                        MenuActivity.nowid++;
                    }
                    MenuActivity.list_order = new ArrayList<>();
                    MenuActivity.list_img = new ArrayList<>();
                    MenuActivity.list_price = new ArrayList<>();
                    MenuActivity.ii.setCount(0);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment3, new MenuFragment()).commit();
                }



            }
        });

        return view;

    }



    private void createRecycle(ViewGroup view, List<cFragmentName> cvList, List<cFragmentImage> cpvList, List<cFragmentPrice> covList){
        rc = view.findViewById(R.id.cartrc);
        rc.setLayoutManager(new LinearLayoutManager(getActivity()));
        rc.setAdapter(new cartAdapter(cvList,cpvList,covList,getActivity()));
    }
}
