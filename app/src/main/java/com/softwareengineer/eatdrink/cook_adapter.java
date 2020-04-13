package com.softwareengineer.eatdrink;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class cook_adapter extends RecyclerView.Adapter<cook_adapter.cookHolder> {
    private List<CookView> cv;
    private List<CookPriceView> cpv;
    //public Context cContext

    public cook_adapter(List<CookView> cv, List<CookPriceView> cpv){
        this.cv = cv;
        this.cpv = cpv;
        //this.cContext = context;
    }
    @Override
    public  cook_adapter.cookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_order,null);
        cook_adapter.cookHolder holder = new cook_adapter.cookHolder(view);
        return holder;
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull cookHolder holder, int position) {
        CookView txtCv = cv.get(position);
        CookPriceView txtCpv = cpv.get(position);
        System.out.println(txtCv.CookOrder);
        System.out.println(txtCpv.CookPrice);
        holder.table.setText(txtCv.CookOrder);
        holder.menu.setText(txtCpv.CookPrice);
        //holder.setItem(position);
    }

    @Override
    public int getItemCount() {
        return cpv.size();
    }


    class cookHolder extends  RecyclerView.ViewHolder{

        TextView table;
        TextView menu;

        public cookHolder(@NonNull View itemView) {
            super(itemView);
            table=itemView.findViewById(R.id.text_title);
            menu=itemView.findViewById(R.id.text_description);
        }
        public void setItem(int position)
        {

        }

    }
}
