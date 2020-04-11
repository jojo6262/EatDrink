package com.softwareengineer.eatdrink;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;

import java.util.HashMap;
import java.util.Map;

public class CookActivity extends AppCompatActivity {
    DatabaseReference show;
    private String Tag;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook);
        final TextView txttest;
        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference mUsersRef = mRootRef.child("users");
        DatabaseReference mMessagesRef = mRootRef.child("messages");
        mUsersRef.child("id-111").setValue("jojo6262");

        String key = mMessagesRef.push().getKey();
        HashMap<String, Object> postValues = new HashMap<>();
        postValues.put("username", "Jirawatee");
        postValues.put("text", "Hello World!");

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/messages/" + key, postValues);
        childUpdates.put("/user-messages/Jirawatee/" + key, postValues);

        mRootRef.updateChildren(childUpdates);



        txttest = (TextView) findViewById(R.id.editText);


//        private void getData(DataSnapshot dataSnapshot) {
//            for(DataSnapshot ds : dataSnapshot.getChildren()){
//                Log.d(Tag, "User Name inside getData: "+ds.child("text").getValue());
//
////                hospitalCity = String.valueOf(ds.child("city").getValue());
////                Log.d(TAG, "User city inside getData: "+ds.child("city").getValue());
//
//                break;
//            }
        }
//        mRootRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                DataSnapshot singleSnapshot = (DataSnapshot) dataSnapshot.getChildren();
//                Log.d("get data",String.valueOf(singleSnapshot));
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

    }

}