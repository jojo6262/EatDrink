package com.softwareengineer.eatdrink;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.softwareengineer.eatdrink.view.CookCountView;
import com.softwareengineer.eatdrink.view.CookMenuView;
import com.softwareengineer.eatdrink.view.CookOrderView;
import com.softwareengineer.eatdrink.view.CookPriceView;
import com.softwareengineer.eatdrink.view.CookView;
import com.softwareengineer.eatdrink.view.cFragmentImage;
import com.softwareengineer.eatdrink.view.cFragmentName;
import com.softwareengineer.eatdrink.view.cFragmentPrice;

import java.io.IOException;
import java.util.List;

public class cook_adapter extends RecyclerView.Adapter<cook_adapter.cookHolder> {
    private List<CookView> cv;
    private List<CookPriceView> cpv;
    private List<CookOrderView> cov;
    private List<CookMenuView> cmv;
    private List<CookCountView> ccv;
    RecyclerView recycleCook;
    public Context cContext;
    View listView;

    public cook_adapter(List<CookView> cv, List<CookPriceView> cpv,List<CookOrderView> cov,List<CookCountView> ccv,Context context){
        this.cv = cv;
        this.cpv = cpv;
        this.cov = cov;
        this.ccv =ccv;

        this.cContext = context;
    }
    @Override
    public  cook_adapter.cookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_order,parent,false);
        cook_adapter.cookHolder holder = new cook_adapter.cookHolder(view);
        this.listView = view;
        return holder;
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull cookHolder holder, int position) {
        CookView txtCv = cv.get(position);
        CookPriceView txtCpv = cpv.get(position);
        final CookOrderView txtcov =cov.get(position);
        CookCountView txtccv=ccv.get(position);
//        CookCountView txtCcv = ccv.get(position);

      System.out.println(txtCv.CookName);


        holder.name.setText("NAME : "+txtCv.CookName);
        holder.price.setText("PRICE : "+txtCpv.CookPrice);
        holder.order.setText("ORDER : "+txtcov.CookIDOrder);
        //holder.menu.setText(txtcmv.CookMenu);
        holder.count.setText("PRICE : "+txtccv.CookCount);
        //holder.setItem(position);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick){
                DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference().child("user-messages/allmenu/menu-"+txtcov.CookIDOrder);
                mRootRef.removeValue();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cpv.size();
    }


    class cookHolder extends  RecyclerView.ViewHolder implements View.OnClickListener
            , View.OnLongClickListener, View.OnTouchListener{

        TextView count;
        TextView price;
        TextView name;
        TextView menu;
        TextView order;
        Button upd;
        private ItemClickListener itemClickListener;

        public cookHolder(@NonNull View itemView) {
            super(itemView);
            upd = itemView.findViewById(R.id.updButton);
            name=itemView.findViewById(R.id.txtcount);
            //menu=itemView.findViewById(R.id.txtorder);
            count=itemView.findViewById(R.id.txtfoodname);
            price=itemView.findViewById(R.id.txtprice);
            order=itemView.findViewById(R.id.txtidorder);
            upd.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            try {
                itemClickListener.onClick(v, getAdapterPosition(), false);
                cpv.clear();
                cov.clear();
                ccv.clear();
                notifyItemRangeRemoved(0, getItemCount());
                notifyDataSetChanged();
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
