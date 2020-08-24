package com.diplomarbeit.planx;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    LoginButton buttonLoginFb;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLoginFb = findViewById(R.id.buttonLoginFb);

        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance()
                .logInWithReadPermissions(this,
                        Arrays.asList("email, instagram_basic, pages_read_engagement, pages_show_list, " +
                                "user_birthday, ads_management, business_management, instagram_manage_insights," +
                                "pages_manage_posts"));

        buttonLoginFb.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.i("BERECHTIGUNGEN", AccessToken.getCurrentAccessToken().getPermissions().toString());
                Log.i("ABGELEHNT", AccessToken.getCurrentAccessToken().getDeclinedPermissions().toString());
                Log.i("ACCESS_TOKEN", AccessToken.getCurrentAccessToken().getToken());
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Log.i("ERR-BERECHTIGUNGEN", AccessToken.getCurrentAccessToken().getPermissions().toString());
                Log.i("ERR-ABGELEHNT", AccessToken.getCurrentAccessToken().getDeclinedPermissions().toString());
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}