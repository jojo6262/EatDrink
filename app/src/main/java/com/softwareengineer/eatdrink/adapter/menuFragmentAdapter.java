package com.softwareengineer.eatdrink.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softwareengineer.eatdrink.R;
import com.softwareengineer.eatdrink.view.mFragmentName;
import com.softwareengineer.eatdrink.view.mFragmentImage;
import com.softwareengineer.eatdrink.view.mFragmentPrice;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class menuFragmentAdapter extends RecyclerView.Adapter<menuFragmentAdapter.menuFragmentHolder> {
    private Context cContext;
    private List<mFragmentName> fn;
    private List<mFragmentImage> fi;
    private List<mFragmentPrice> fp;


    public menuFragmentAdapter(List<mFragmentName> cv, List<mFragmentImage> cpv, List<mFragmentPrice> cov, Context context){
        this.fn = cv;
        this.fi = cpv;
        this.fp = cov;
        this.cContext = context;
    }

    @Override
    public  menuFragmentAdapter.menuFragmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_menulist,parent,false);
        menuFragmentAdapter.menuFragmentHolder holder = new menuFragmentAdapter.menuFragmentHolder(view);
        return holder;
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull menuFragmentAdapter.menuFragmentHolder holder, int position) {
        mFragmentName txtFn = fn.get(position);
        mFragmentImage imgF = fi.get(position);
        mFragmentPrice txtFp =fp.get(position);
        holder.name.setText("NAME : " +txtFn.mFragmentName);
        holder.price.setText("PRICE : "+txtFp.mFragmentPrice);
        try {
            holder.img.setImageBitmap(getBitmapFromAssets("img/"+imgF.mFragmentImage));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public Bitmap getBitmapFromAssets(String fileName) throws IOException {
        AssetManager assetManager = cContext.getAssets();

        InputStream istr = assetManager.open(fileName);
        Bitmap bitmap = BitmapFactory.decodeStream(istr);
        istr.close();

        return bitmap;
    }

    @Override
    public int getItemCount() {
        return fn.size();
    }

    class menuFragmentHolder extends  RecyclerView.ViewHolder{

        ImageView img;
        TextView price;
        TextView name;


        public menuFragmentHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView2);
            name=itemView.findViewById(R.id.textView2);
            price=itemView.findViewById(R.id.textView3);
        }

    }
}
