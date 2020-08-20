package com.diplomarbeit.planx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import maes.tech.intentanim.CustomIntent;

public class CalendarActivity extends AppCompatActivity {

    float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
    }

    public boolean onTouchEvent(MotionEvent touchevent){
        switch (touchevent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchevent.getX();
                y2 = touchevent.getY();
                if(x1 > x2){
                    Intent intent = new Intent(this, HomeActivity.class);
                    startActivity(intent);
                    CustomIntent.customType(this, "left-to-right");
                }
                break;
        }
        return false;
    }

    @Override
    public void finish(){
        super.finish();
        CustomIntent.customType(this, "left-to-right");
    }
}