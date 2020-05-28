package com.softwareengineer.eatdrink.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softwareengineer.eatdrink.ItemClickListener;
import com.softwareengineer.eatdrink.MenuActivity;
import com.softwareengineer.eatdrink.R;
import com.softwareengineer.eatdrink.view.cFragmentImage;
import com.softwareengineer.eatdrink.view.cFragmentName;
import com.softwareengineer.eatdrink.view.cFragmentPrice;
import com.softwareengineer.eatdrink.view.mFragmentName;
import com.softwareengineer.eatdrink.view.mFragmentImage;
import com.softwareengineer.eatdrink.view.mFragmentPrice;


import org.json.JSONException;

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
    public void onBindViewHolder(@NonNull menuFragmentAdapter.menuFragmentHolder holder, final int position) {
        final mFragmentName txtFn = fn.get(position);
        final mFragmentImage imgF = fi.get(position);
        final mFragmentPrice txtFp =fp.get(position);
        holder.name.setText("NAME : " +txtFn.mFragmentName);
        holder.price.setText("PRICE : "+txtFp.mFragmentPrice);
        try {
            holder.img.setImageBitmap(getBitmapFromAssets("img/"+imgF.mFragmentImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick){
                System.out.println("Click From menuFragment//"+position);
                Toast.makeText(cContext,"Order",Toast.LENGTH_SHORT );
                MenuActivity.ii.increase();
                MenuActivity.list_order.add(new cFragmentName(txtFn.mFragmentName));
                MenuActivity.list_price.add(new cFragmentPrice(txtFp.mFragmentPrice));
                MenuActivity.list_img.add(new cFragmentImage(imgF.mFragmentImage));
            }
        });

    }

    /*System.out.println("Click From menuFragment//"+position);
                MenuActivity.list_order.add(new cFragmentName(txtFn.mFragmentName));
                MenuActivity.list_price.add(new cFragmentPrice(txtFp.mFragmentPrice));
                MenuActivity.list_img.add(new cFragmentImage(imgF.mFragmentImage));*/

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

    class menuFragmentHolder extends  RecyclerView.ViewHolder implements View.OnClickListener
            , View.OnLongClickListener, View.OnTouchListener{

        ImageView img;
        ImageView imgg;
        TextView price;
        TextView name;
        private ItemClickListener itemClickListener;


        public menuFragmentHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imageView2);
            imgg = itemView.findViewById(R.id.imageView_menu);
            name=itemView.findViewById(R.id.textView2);
            price=itemView.findViewById(R.id.textView3);
            imgg.setOnClickListener(this);

        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            try {
                itemClickListener.onClick(v, getAdapterPosition(), false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public boolean onLongClick(View v) {
            try {
                itemClickListener.onClick(v, getAdapterPosition(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return false;
        }
    }
}
