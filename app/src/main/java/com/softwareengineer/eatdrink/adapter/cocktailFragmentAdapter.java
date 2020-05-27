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
import com.softwareengineer.eatdrink.view.cFragmentImage;
import com.softwareengineer.eatdrink.view.cFragmentName;
import com.softwareengineer.eatdrink.view.cFragmentPrice;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class cocktailFragmentAdapter extends RecyclerView.Adapter<cocktailFragmentAdapter.cocktailFragmentHolder>{
    private Context cContext;
    private List<cFragmentName> fn;
    private List<cFragmentImage> fi;
    private List<cFragmentPrice> fp;


    public cocktailFragmentAdapter(List<cFragmentName> cv, List<cFragmentImage> cpv, List<cFragmentPrice> cov, Context context){
        this.fn = cv;
        this.fi = cpv;
        this.fp = cov;
        this.cContext = context;
    }

    @Override
    public  cocktailFragmentAdapter.cocktailFragmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_cocktaillist,parent,false);
        cocktailFragmentAdapter.cocktailFragmentHolder holder = new cocktailFragmentAdapter.cocktailFragmentHolder(view);
        return holder;
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull cocktailFragmentAdapter.cocktailFragmentHolder holder, int position) {
        cFragmentName txtFn = fn.get(position);
        cFragmentImage imgF = fi.get(position);
        cFragmentPrice txtFp =fp.get(position);
        System.out.println(txtFn.cFragmentName+"/"+txtFp.cFragmentPrice);
        holder.name.setText("NAME : " +txtFn.cFragmentName);
        holder.price.setText("PRICE : "+txtFp.cFragmentPrice+" Bath");
        try {
            holder.img.setImageBitmap(getBitmapFromAssets("img/"+imgF.cFragmentImage));
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

    class cocktailFragmentHolder extends  RecyclerView.ViewHolder{

        ImageView img;
        TextView price;
        TextView name;
        TextView txt;


        public cocktailFragmentHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.ct_imageView2);
            name=itemView.findViewById(R.id.ct_textView2);
            price=itemView.findViewById(R.id.ct_textView3);
        }

    }
}

