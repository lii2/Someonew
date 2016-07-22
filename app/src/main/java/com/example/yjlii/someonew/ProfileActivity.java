package com.example.yjlii.someonew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class ProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Profile currentUser = Profile.getCurrentProfile();

        setContentView(R.layout.activity_profile);

        try {
            TextView FBname = (TextView) findViewById(R.id.FBname);

            ImageView ProfilePic = (ImageView) findViewById(R.id.profileView);

            FBname.setText(currentUser.getFirstName() + " " + currentUser.getLastName());

            // SetImageURI is used for content URIs that's specific to the Android operating system.
            // Specifying a URI to an internet resource won't work and the image will not be displayed.
            Glide.with(this).load(currentUser.getProfilePictureUri(500,500).toString()).into(ProfilePic);

        }catch(NullPointerException e){
            System.err.println("NullPointerException: " + e.getMessage());
        }

        setInterestBar(R.drawable.placeholderlogo, R.drawable.placeholderlogo, R.drawable.placeholderlogo, R.drawable.placeholderlogo, R.drawable.placeholderlogo);

    }

    public void goToMain (){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToMain (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToChooseInterests(View view){
        Intent intent = new Intent(this, ChooseInterests.class);
        startActivity(intent);
    }

    public void setInterestBar(int[] interest_array){
        //takes resource id array, example R.drawable.football

        ImageView interestlogo1 = (ImageView) findViewById(R.id.logoview1);
        ImageView interestlogo2 = (ImageView) findViewById(R.id.logoview2);
        ImageView interestlogo3 = (ImageView) findViewById(R.id.logoview3);
        ImageView interestlogo4 = (ImageView) findViewById(R.id.logoview4);
        ImageView interestlogo5 = (ImageView) findViewById(R.id.logoview5);

        interestlogo1.setImageResource(interest_array[0]);
        interestlogo2.setImageResource(interest_array[1]);
        interestlogo3.setImageResource(interest_array[2]);
        interestlogo4.setImageResource(interest_array[3]);
        interestlogo5.setImageResource(interest_array[4]);

    }

    public void setInterestBar(int one, int two, int three, int four, int five){
        //takes resource id, example R.drawable.football

        ImageView interestlogo1 = (ImageView) findViewById(R.id.logoview1);
        ImageView interestlogo2 = (ImageView) findViewById(R.id.logoview2);
        ImageView interestlogo3 = (ImageView) findViewById(R.id.logoview3);
        ImageView interestlogo4 = (ImageView) findViewById(R.id.logoview4);
        ImageView interestlogo5 = (ImageView) findViewById(R.id.logoview5);

        interestlogo1.setImageResource(one);
        interestlogo2.setImageResource(two);
        interestlogo3.setImageResource(three);
        interestlogo4.setImageResource(four);
        interestlogo5.setImageResource(five);

    }

}
