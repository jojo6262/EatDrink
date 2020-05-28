package com.softwareengineer.eatdrink;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.softwareengineer.eatdrink.view.CookCountView;
import com.softwareengineer.eatdrink.view.CookMenuView;
import com.softwareengineer.eatdrink.view.CookOrderView;
import com.softwareengineer.eatdrink.view.CookPriceView;
import com.softwareengineer.eatdrink.view.CookView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CookActivity extends AppCompatActivity {
    DatabaseReference show;
    private String Tag;
    private TextView txttest;
    protected List<CookView> cvList;
    protected List<CookPriceView> cpvList;
    protected List<CookOrderView> covList;
    protected List<CookMenuView> cmvList;
    protected List<CookCountView> ccvList;
    RecyclerView recycleCook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook);

   //     txttest = findViewById(R.id.txttest);

        // init firebase root reference
        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference().child("");

        // [WORKED] init a child ref from firebase ref (mRootRef)
//        DatabaseReference mUsersRef = mRootRef.child("users");
 //       mUsersRef.child("id-111").setValue("jojo626262626262626262626262626262");

        // [WORKED] init another child ref from firebase ref (mRootRef)
   //     DatabaseReference mMessagesRef = mRootRef.child("messages");
    //    String key = mMessagesRef.push().getKey();

        final HashMap<String, Object> postValues = new HashMap<>();
//        postValues.put("username", "Jirawatee");
 //       postValues.put("text", "Hello World!");
        Map<String, Object> childUpdates = new HashMap<>();
//        childUpdates.put("/messages/" + key, postValues);
      //  childUpdates.put("/user-messages/Jirawatee/" + key, postValues);
        mRootRef.updateChildren(childUpdates);

        cvList = new ArrayList<>();
        cpvList = new ArrayList<>();
        covList = new ArrayList<>();
        cmvList = new ArrayList<>();
        ccvList = new ArrayList<>();
        mRootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                /*
                 *  eatdrink-se
                 *  |__ messages
                 *  |   |_ -M4in3Cr-s8yGSztc2-z
                 *  |       |__ text : "Hello, World!"   # <--- Say you want this data
                 *  |       |__ username: "Jirawatee"
                 *  |__ user-messages
                 *  |   |_ ...
                 *  |__ users
                 *  |   |_ ...
                 *
                 *
                 *  To get the data:
                 *  String s = snapshot.child("messages/-M4in3Cr-s8yGSztc2-z/text").getValue();
                 *  >> Hello, World
                 *
                 * */

               // String s = snapshot.child("user-messages").getValue().toString();

                String na = "";
                String price = "";
                String order="";
                String menu="";
                String count="";


                for (DataSnapshot postSnapshot: snapshot.getChildren()) {

                 //    postSnapshot => ['messages']
        //            s += postSnapshot.getKey() + ":" + postSnapshot.hasChild("allmenu") + "\n";
          //         s += postSnapshot.getKey() + ":" + postSnapshot.hasChild("allmenu") ;
         //           s += postSnapshot.child("").getValue() + "\n";


//                    DataSnapshot messagesSnapshot =postSnapshot.child("");
//                    for (DataSnapshot postMS: messagesSnapshot.getChildren()) {
//                        if (postSnapshot.hasChild("allmenu") == true) {
//                            s += postMS.getChildrenCount() + "\n";
//                        }
//                    }
                  //   user-messages
                    DataSnapshot userMessagesSnapshot = postSnapshot.child("allmenu");
                    for (DataSnapshot postMS: userMessagesSnapshot.getChildren()){
                        na = postMS.child("name").getValue().toString();
                        System.out.println(na);
                        if (na.equals("0") ) { }else{
                            price = postMS.child("price").getValue().toString();
                            order = postMS.child("idorder").getValue().toString();
                            //menu = postMS.child("IDMenu").getValue().toString();
                            count = postMS.child("countOrder").getValue().toString();
                            cvList.add(new CookView(na));
                            cpvList.add(new CookPriceView(price));
                            covList.add(new CookOrderView(order));
                            //cmvList.add(new CookMenuView(menu));
                            ccvList.add(new CookCountView(count));
                        }


//                        count = postMS.child("CountOrder").getValue().toString();
//                        name = postMS.child("Name").getValue().toString();
//                        menu = postMS.child("IDMenu").getValue().toString();
//                        ccvList.add(new CookCountView(count));
//                        covList.add(new CookOrderView(name));
//                        cmvList.add(new CookMenuView(menu));
//                        System.out.println(count);
//                        DataSnapshot userFood = postMS.child("Food");
//                        for(DataSnapshot listfood: userFood.getChildren()){
//                            count = listfood.child("Count").getValue().toString();
//                            name = listfood.child("Name").getValue().toString();
//                            menu = listfood.child("IDFood").getValue().toString();
//                            ccvList.add(new CookCountView(count));
//                            covList.add(new CookOrderView(name));
//                            cmvList.add(new CookMenuView(menu));

  //                      }
                    }

     /*
                  Log.d("list", cvList.toString());
                    System.out.println(ccvList.toString());
   */
//                    System.out.println(ccvList.get(1));
//                    System.out.println("++++++++++++++++");



                  //   users
                    DataSnapshot usersSnapshot = postSnapshot.child("");
                    for (DataSnapshot postMS: usersSnapshot.getChildren()){
    ///                    s += postMS.getKey();
                    }
                }
                System.out.println(cvList.size());
                createRecycle(cvList,cpvList,covList,ccvList);
               //txttest.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

  //      System.out.println("+++++++++ >>>"+cvList.size());
        //txttest.setText("...");


    }

    public void freshTime(){

    }


    private void createRecycle(List<CookView> cvList,List<CookPriceView> cpvList,List<CookOrderView> covList,List<CookCountView> ccvList){
        recycleCook = findViewById(R.id.rc_cook);
        recycleCook.setLayoutManager(new LinearLayoutManager(this));
        recycleCook.setAdapter(new cook_adapter(cvList,cpvList,covList,ccvList,this));
    }

    private void getData(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()){
//            Log.d(Tag, "User Name inside getData: "+ds.child("user-messages").getChildrenCount());
  //          txttest.setText(s);
//            int size = (int) dataSnapshot.getChildrenCount();
  //          txttest.setText(size);
        }
        Log.d(Tag, "--------------------------------------------------------------");
    }

}