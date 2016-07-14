package com.example.yjlii.someonew;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {
    boolean status = false;
    CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // Go to profile page
                Intent intent = new Intent(this, InterestActivity.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {
                // Do nothing
            }

            @Override
            public void onError(FacebookException exception) {
                // Think about later
            }
        });


        setContentView(R.layout.activity_main);
    }

/*    public void popup(View view){

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(!status) {

            FragmentOne f1 = new FragmentOne();
            fragmentTransaction.add(R.id.fragment_container, f1);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            status = true;
        }

    }*/

    public void goToInterest(View view){
        Intent intent = new Intent(this, InterestActivity.class);
        startActivity(intent);
    }
}
