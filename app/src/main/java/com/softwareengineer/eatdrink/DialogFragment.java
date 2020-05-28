package com.softwareengineer.eatdrink;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.softwareengineer.eatdrink.adapter.cartAdapter;
import com.softwareengineer.eatdrink.view.cFragmentImage;
import com.softwareengineer.eatdrink.view.cFragmentName;
import com.softwareengineer.eatdrink.view.cFragmentPrice;


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

        return view;

    }

    private void createRecycle(ViewGroup view, List<cFragmentName> cvList, List<cFragmentImage> cpvList, List<cFragmentPrice> covList){
        rc = view.findViewById(R.id.cartrc);
        rc.setLayoutManager(new LinearLayoutManager(getActivity()));
        rc.setAdapter(new cartAdapter(cvList,cpvList,covList,getActivity()));
    }
}
