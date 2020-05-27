package com.softwareengineer.eatdrink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    protected Button btnCook , btnCustomer, btnCasheir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCook = findViewById(R.id.button_cook);
        btnCustomer = findViewById(R.id.button_customer);
        btnCasheir = findViewById(R.id.button_cashier);
        btnCook.setOnClickListener(this);
        btnCustomer.setOnClickListener(this);
        btnCasheir.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.button_cook: /** Start a new Activity Cook.java */
                Intent intent = new Intent(this, CookActivity.class);
                this.startActivity(intent);
                break;

            case R.id.button_customer: /** Start a new Activity Customer.java */
                Intent intent1 = new Intent(this, MenuActivity.class);
                this.startActivity(intent1);
                break;

            case R.id.button_cashier: /** Start a new Activity Cashier.java */
                Intent intent2 = new Intent(this, CashierTableActivity.class);
                this.startActivity(intent2);
                break;
        }
    }
}
