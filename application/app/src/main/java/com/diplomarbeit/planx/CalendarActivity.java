package com.diplomarbeit.planx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;

import maes.tech.intentanim.CustomIntent;

public class CalendarActivity extends AppCompatActivity {

    float x1, x2, y1, y2;

    CalendarView calendar;

    ListView listView;

    ArrayList events;

    PostActivity postActivity;

    Button buttonGetPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        //calendar = findViewById(R.id.calendarView);
        //listView = findViewById(R.id.listView);
        //events = new ArrayList<>();

        /*events.add("Test1");
        events.add("Test2");
        events.add("Test3");
        events.add(12);*/

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, events);

        listView.setAdapter(arrayAdapter);

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