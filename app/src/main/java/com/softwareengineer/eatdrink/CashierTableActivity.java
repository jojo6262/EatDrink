package com.softwareengineer.eatdrink;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
public class CashierTableActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashier_table);
        Button Table1 = findViewById(R.id.Table1);
        Button Table2 = findViewById(R.id.Table2);
        Button Table3 = findViewById(R.id.Table3);
        Button Table4 = findViewById(R.id.Table4);
        Table1.setOnClickListener(this);
        Table2.setOnClickListener(this);
        Table3.setOnClickListener(this);
        Table4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String table="";
        switch(v.getId()){

            case R.id.Table1: /** Start a new Activity Cook.java */
                table="Table1";
                break;

            case R.id.Table2: /** Start a new Activity Customer.java */
                table="Table2";
                break;

            case R.id.Table3: /** Start a new Activity Cashier.java */
                table="Table3";
                break;

            case R.id.Table4: /** Start a new Activity Cashier.java */
                table="Table4";
                break;
        }
        Intent intent = new Intent(this, CashierActivity.class);
        intent.putExtra("Key",table);
        this.startActivity(intent);

    }
}
