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
    public void onBindViewHolder(@NonNull final cocktailFragmentAdapter.cocktailFragmentHolder holder, final int position) {
        final cFragmentName txtFn = fn.get(position);
        final cFragmentImage imgF = fi.get(position);
        final cFragmentPrice txtFp =fp.get(position);
        System.out.println(txtFn.cFragmentName+"/"+txtFp.cFragmentPrice);
        holder.name.setText("NAME : " +txtFn.cFragmentName);
        holder.price.setText("PRICE : "+txtFp.cFragmentPrice+" Bath");
        try {
            holder.img.setImageBitmap(getBitmapFromAssets("img/"+imgF.cFragmentImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick){
                System.out.println("Click From cocktailFragment//"+position);
                Toast.makeText(cContext,"Order",Toast.LENGTH_SHORT );
                if(MenuActivity.countVodka<3){
                    MenuActivity.ii.increase();
                    MenuActivity.countVodka++;
                    MenuActivity.list_order.add(new cFragmentName(txtFn.cFragmentName));
                    MenuActivity.list_price.add(new cFragmentPrice(txtFp.cFragmentPrice));
                    MenuActivity.list_img.add(new cFragmentImage(imgF.cFragmentImage));
                }else {
                    Toast.makeText(cContext,"Maximum",Toast.LENGTH_SHORT );
                }
            }
        });


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

    class cocktailFragmentHolder extends  RecyclerView.ViewHolder implements View.OnClickListener
            , View.OnLongClickListener, View.OnTouchListener{

        ImageView img;
        ImageView imgct;
        TextView price;
        TextView name;
        TextView txt;
        private ItemClickListener itemClickListener;


        public cocktailFragmentHolder(@NonNull View itemView) {
            super(itemView);
            imgct = itemView.findViewById(R.id.imageView_ct);
            img = itemView.findViewById(R.id.ct_imageView2);
            name=itemView.findViewById(R.id.ct_textView2);
            price=itemView.findViewById(R.id.ct_textView3);
            imgct.setOnClickListener(this);
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

