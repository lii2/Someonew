package com.example.yjlii.someonew;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {
    boolean status = false;
    CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        //measure installs on your mobile app ads, create high value audiences for targeting, and view analytics

        callbackManager = CallbackManager.Factory.create();

        final LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // If login succeeds, the LoginResult parameter has the new AccessToken, and the most recently granted or declined permissions.
                        // Go to profiles
                        goToProfile(loginButton);
                    }

                    @Override
                    public void onCancel() {
                        // Stay here
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // Send error code
                    }
                });


        setContentView(R.layout.activity_main);

        if (Profile.getCurrentProfile() != null) {
            goToProfile(loginButton);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


    public void goToProfile(View view){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    /*
    public void popup(View view) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (!status) {

            FragmentOne f1 = new FragmentOne();
            fragmentTransaction.add(R.id.fragment_container, f1);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            status = true;
        }else {

        }
        }
        */
}
