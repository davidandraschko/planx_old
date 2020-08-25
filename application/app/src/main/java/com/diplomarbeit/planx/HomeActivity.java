package com.diplomarbeit.planx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONException;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import maes.tech.intentanim.CustomIntent;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    float x1, x2, y1, y2;

    private ImageView imageViewPb;
    String profilePictureUrl;

    TextView textView;

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

        imageViewPb = findViewById(R.id.profile_image);
        getInstagramData(AccessToken.getCurrentAccessToken());

        textView = findViewById(R.id.textView);

    }

    private void getInstagramData(AccessToken accessToken) {
        final GraphRequest request = GraphRequest.newGraphPathRequest(accessToken,
                "17841438891721670?fields=biography,followers_count,media_count,username,profile_picture_url,follows_count,name", new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {
                        Log.i("RESPONSE", response.toString());
                        try {
                            profilePictureUrl = response.getJSONObject().getString("profile_picture_url");
                            textView.setText("Hello, " + response.getJSONObject().getString( "username"));
                            Log.i("PROFILBILD", profilePictureUrl);
                            ProfilePictureDownloader pictureDownloader = new ProfilePictureDownloader();
                            Bitmap profilePicture;
                            try {
                                profilePicture = pictureDownloader.execute(profilePictureUrl).get();
                                imageViewPb.setImageBitmap(profilePicture);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
        request.executeAsync();
    }

    public class ProfilePictureDownloader extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(inputStream);
                return myBitmap;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
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
                if(x1 < x2){
                    Intent intent = new Intent(this, CalendarActivity.class);
                    startActivity(intent);
                    CustomIntent.customType(this, "right-to-left");
                }
                 if(x1 > x2){
                     Intent intent = new Intent(this, PostActivity.class);
                     startActivity(intent);
                     CustomIntent.customType(this, "left-to-right");
                 }
                break;
        }
        return false;
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