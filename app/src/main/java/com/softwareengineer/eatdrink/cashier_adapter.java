package com.softwareengineer.eatdrink;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class cashier_adapter extends RecyclerView.Adapter<cashier_adapter.cashierHolder> {
    private List<CashierCount> cc;
    private List<CashierOrder> co;
    private List<CashierPrice> cp;
//    private List<CookMenuView> cmv;
//    private List<CookCountView> ccv;
    RecyclerView recycleCook;
    public Context cContext;
    View listView;

    public cashier_adapter(List<CashierCount> cc, List<CashierOrder> co,List<CashierPrice> cp,Context context){
        this.cc = cc;
        this.co = co;
        this.cp = cp;
//        this.cmv =cmv;
//        this.ccv =ccv;

        this.cContext = context;
    }
    @Override
    public  cashier_adapter.cashierHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_cashier,parent,false);
        cashier_adapter.cashierHolder holder = new cashier_adapter.cashierHolder(view);
        this.listView = view;
        return holder;
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull cashierHolder holder, int position) {
        CashierCount txtcc = cc.get(position);
        CashierOrder txtco = co.get(position);
        CashierPrice txtcp =cp.get(position);
//        CookMenuView txtcmv=cmv.get(position);
//        CookCountView txtccv=ccv.get(position);
//        CookCountView txtCcv = ccv.get(position);

 //       System.out.println(txtCv.CookName);


 //       holder.name.setText(txtCv.CookName);


//        holder.menu.setText(txtcmv.CookMenu);
        holder.count.setText(txtcc.CashierCount);
        holder.order.setText(txtco.CashierOrder);
        holder.price.setText(txtcp.CashierPrice);
        //holder.setItem(position);
    }

    @Override
    public int getItemCount() {

        return cp.size();
    }


    class cashierHolder extends  RecyclerView.ViewHolder{

        TextView count;
        TextView price;
        TextView name;
        TextView menu;
        TextView order;

        public cashierHolder(@NonNull View itemView) {
            super(itemView);
            count=itemView.findViewById(R.id.txtcount);
 //           menu=itemView.findViewById(R.id.txtorder);
 //           name=itemView.findViewById(R.id.txtfoodname);
            price=itemView.findViewById(R.id.txtprice);
            order=itemView.findViewById(R.id.txtorder);
        }
        public void setItem(int position)
        {

        }

    }
}
