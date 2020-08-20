package com.diplomarbeit.planx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import maes.tech.intentanim.CustomIntent;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button buttonLogout = findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(this);

        ImageView imageViewCalendar = findViewById(R.id.imageViewCalendar);
        imageViewCalendar.setOnClickListener(this);

        ImageView imageViewPost = findViewById(R.id.imageViewPost);
        imageViewPost.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonLogout) {
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
        }

        if(view.getId() == R.id.imageViewCalendar){
            Intent intent = new Intent(this, CalendarActivity.class);
            this.startActivity(intent);
            CustomIntent.customType(this, "right-to-left");
        }

        if(view.getId() == R.id.imageViewPost){
            Intent intent = new Intent(this, PostActivity.class);
            this.startActivity(intent);
            CustomIntent.customType(this, "left-to-right");
        }
    }
}