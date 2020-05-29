package com.softwareengineer.eatdrink;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.softwareengineer.eatdrink.view.CookCountView;
import com.softwareengineer.eatdrink.view.CookOrderView;
import com.softwareengineer.eatdrink.view.CookPriceView;
import com.softwareengineer.eatdrink.view.CookView;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    protected Button btnCook , btnCustomer, btnCasheir;
    protected String table;
    EditText ee;
    TextView noti;
    int i=0;
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
        noti = findViewById(R.id.txtnoti);

        freshTime();

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.button_cook: /** Start a new Activity Cook.java */
                Intent intent = new Intent(this, CookActivity.class);
                this.startActivity(intent);
                break;

            case R.id.button_customer: /** Start a new Activity Customer.java */
                Intent intent1 = new Intent(this, SplashScreenActivity.class);
                ee = findViewById(R.id.inputTxtTablu);
                table = ee.getText().toString();
                intent1.putExtra("Key",table);
                this.startActivity(intent1);
                finish();
                break;

            case R.id.button_cashier: /** Start a new Activity Cashier.java */
                Intent intent2 = new Intent(this, CashierTableActivity.class);
                this.startActivity(intent2);
                break;
        }
    }

    public void freshTime(){
        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference().child("");
        final HashMap<String, Object> postValues = new HashMap<>();

        Map<String, Object> childUpdates = new HashMap<>();

        mRootRef.updateChildren(childUpdates);
        mRootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {


                    DataSnapshot userMessagesSnapshot = postSnapshot.child("allmenu");
                    for (DataSnapshot postMS: userMessagesSnapshot.getChildren()){
                        i=i+1;
                        if (i==1 ) {
                            noti.setText("");
                        }
                        else
                        {
                           noti.setText("New Order!!!!");

                        }
                    }
                    DataSnapshot usersSnapshot = postSnapshot.child("");
                    for (DataSnapshot postMS: usersSnapshot.getChildren()){

                    }
                }
                i=0;
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        freshTime();
                    }
                });
            }
        },2000);
    }
}
