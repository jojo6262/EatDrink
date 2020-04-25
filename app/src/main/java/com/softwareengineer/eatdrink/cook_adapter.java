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
    private List<CookOrderView> cov;
    private List<CookMenuView> cmv;
    private List<CookCountView> ccv;
    RecyclerView recycleCook;
    public Context cContext;
    View listView;

    public cook_adapter(List<CookView> cv, List<CookPriceView> cpv,List<CookOrderView> cov,List<CookMenuView> cmv,List<CookCountView> ccv,Context context){
        this.cv = cv;
        this.cpv = cpv;
        this.cov = cov;
        this.cmv =cmv;
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
        CookOrderView txtcov =cov.get(position);
        CookMenuView txtcmv=cmv.get(position);
        CookCountView txtccv=ccv.get(position);
//        CookCountView txtCcv = ccv.get(position);

      System.out.println(txtCv.CookName);


        holder.name.setText(txtCv.CookName);
        holder.price.setText(txtCpv.CookPrice);
        holder.order.setText(txtcov.CookIDOrder);
        holder.menu.setText(txtcmv.CookMenu);
        holder.count.setText(txtccv.CookCount);
        //holder.setItem(position);
    }

    @Override
    public int getItemCount() {
        return cpv.size();
    }


    class cookHolder extends  RecyclerView.ViewHolder{

        TextView count;
        TextView price;
        TextView name;
        TextView menu;
        TextView order;

        public cookHolder(@NonNull View itemView) {
            super(itemView);
            count=itemView.findViewById(R.id.txtcount);
            menu=itemView.findViewById(R.id.txtorder);
            name=itemView.findViewById(R.id.txtfoodname);
            price=itemView.findViewById(R.id.txtprice);
            order=itemView.findViewById(R.id.txtidorder);
        }
        public void setItem(int position)
        {

        }

    }
}
