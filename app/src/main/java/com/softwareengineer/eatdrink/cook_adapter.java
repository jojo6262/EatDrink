package com.softwareengineer.eatdrink;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_order,null);
        cook_adapter.cookHolder holder = new cook_adapter.cookHolder(view);
        this.listView = view;
        return holder;
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull cookHolder holder, int position) {
        CookView txtCv = cv.get(position);
        CookPriceView txtCpv = cpv.get(position);
//        CookCountView txtCcv = ccv.get(position);

//        System.out.println(txtCv.CookOrder);
//        System.out.println(txtCpv.CookPrice);
        holder.table.setText(txtCv.CookOrder);
        holder.menu.setText(txtCpv.CookPrice);
        //holder.setItem(position);
        createRecycle(ccv,cmv,cov,cContext);
    }

    private void createRecycle(List<CookCountView> ccvList,List<CookMenuView> cmvList,List<CookOrderView> covList,Context cContext){
        recycleCook = listView.findViewById(R.id.re_order);
        recycleCook.setLayoutManager(new LinearLayoutManager(cContext));
        recycleCook.setAdapter(new listmenu_adapter(covList,cmvList,ccvList,cContext));
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
