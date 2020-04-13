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

public class listmenu_adapter  extends RecyclerView.Adapter<listmenu_adapter.cookHolder> {

    private List<CookOrderView> cov;
    private List<CookMenuView> cmv;
    private List<CookCountView> ccv;

    public Context cContext;

    public listmenu_adapter(List<CookOrderView> cov,List<CookMenuView> cmv,List<CookCountView> ccv,Context context){
        this.cov = cov;
        this.cmv =cmv;
        this.ccv =ccv;

        this.cContext = context;
//        System.out.println(ccv.size());
//        System.out.println("++++++++++++++++");
    }
    @Override
    public  listmenu_adapter.cookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_listorder,null);
        listmenu_adapter.cookHolder holder = new listmenu_adapter.cookHolder(view);
        return holder;
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull listmenu_adapter.cookHolder holder, int position) {
  //      CookView txtCv = cv.get(position);
    //    CookPriceView txtCpv = cpv.get(position);
        CookMenuView txtCmv=cmv.get(position);
        CookCountView txtCcv=ccv.get(position);
        CookOrderView txtCov=cov.get(position);
//        CookCountView txtCcv = ccv.get(position);

//        System.out.println(txtCmv.CookMenu);
//        System.out.println(txtCcv.CookCount);
//        System.out.println(txtCov.CookOrder);

        holder.name.setText(txtCov.CookOrder);
        holder.menu.setText(txtCmv.CookMenu);
        holder.count.setText(txtCcv.CookCount);
        //holder.setItem(position);
    }


    @Override
    public int getItemCount() {
        return 1;
    }


    class cookHolder extends  RecyclerView.ViewHolder{

        TextView name;
        TextView menu;
        TextView count;

        public cookHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.textView15);
            menu=itemView.findViewById(R.id.textView11);
            count=itemView.findViewById(R.id.textView13);
        }


    }
}
