package com.softwareengineer.eatdrink;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softwareengineer.eatdrink.adapter.menuFragmentAdapter;
import com.softwareengineer.eatdrink.view.mFragmentImage;
import com.softwareengineer.eatdrink.view.mFragmentName;
import com.softwareengineer.eatdrink.view.mFragmentPrice;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MenuFragment extends Fragment {
    public JSONObject listMenu;
    public List<mFragmentName> countName;
    public List<mFragmentImage> countImage;
    public List<mFragmentPrice> countPrice;
    RecyclerView recycleMenu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_menu, container, false);
        countName = new ArrayList<>();
        countImage = new ArrayList<>();
        countPrice = new ArrayList<>();
        try {
            loadJSONFromAsset();
            String aa = listMenu.getString("Food");
            JSONArray JA = new JSONArray(aa);
            for(int i =0;i<JA.length();i++){
                JSONObject list1 = JA.getJSONObject(i);
                countName.add(new mFragmentName(list1.getString("Name")));
                countImage.add(new mFragmentImage(list1.getString("Image")));
                countPrice.add(new mFragmentPrice(list1.getString("Price")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        createRecycle(view,countName,countImage,countPrice);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void createRecycle(ViewGroup view,List<mFragmentName> cvList,List<mFragmentImage> cpvList,List<mFragmentPrice> covList){
        recycleMenu = view.findViewById(R.id.rc_menuFragment);
        recycleMenu.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycleMenu.setAdapter(new menuFragmentAdapter(cvList,cpvList,covList,getActivity()));
    }

    public void loadJSONFromAsset() throws JSONException {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open("food.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
        }
        listMenu = new JSONObject(json);

    }
}
