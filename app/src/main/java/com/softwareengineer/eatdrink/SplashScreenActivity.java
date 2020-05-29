package com.softwareengineer.eatdrink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {

    protected ImageView aaaaaa;
    private String Table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Bundle table = getIntent().getExtras();
        Table =table.getString("Key");
        aaaaaa = findViewById(R.id.imageView4);
        aaaaaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashScreenActivity.this,MenuActivity.class);
                intent.putExtra("Key",Table);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
    }
}
