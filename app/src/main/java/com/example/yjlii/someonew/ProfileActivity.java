package com.example.yjlii.someonew;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
import com.google.android.flexbox.FlexboxLayout;

import java.util.HashSet;


public class ProfileActivity extends AppCompatActivity {

    InterestManager interestManager;
    Profile currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        interestManager = new InterestManager();

        currentUser = Profile.getCurrentProfile();

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

        setContentView(R.layout.activity_profile);

        retrieveOrChoose();

        FlexboxLayout interestsContainer = (FlexboxLayout) findViewById(R.id.interestsContainer);

        for (Interest interest : interestManager.allInterests) {
            interestsContainer.addView(createInterest(interest));
        }

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

    public void goToChooseInterests(){
        Intent intent = new Intent(this, ChooseInterests.class);
        startActivity(intent);
    }


    public void retrieveOrChoose() {
        String[] names = new String[5];
        int[] pics = new int[5];

        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);

        names[0] = prefs.getString("interest_one_name", "default");
        names[1] = prefs.getString("interest_two_name", "default");
        names[2] = prefs.getString("interest_three_name", "default");
        names[3] = prefs.getString("interest_four_name", "default");
        names[4] = prefs.getString("interest_five_name", "default");

        pics[0] = prefs.getInt("interest_one_pic", 0);
        pics[1] = prefs.getInt("interest_two_pic", 0);
        pics[2] = prefs.getInt("interest_three_pic", 0);
        pics[3] = prefs.getInt("interest_four_pic", 0);
        pics[4] = prefs.getInt("interest_five_pic", 0);


        if (names[0] == "default") {
            goToChooseInterests();
        }else{

            HashSet<Interest> userInterests = new HashSet<Interest>();
            for(int i = 0; i<5; i++) {

                userInterests.add(new Interest(names[i], pics[i]));

            }

            interestManager.setUserInterests(userInterests);

        }
    }

    private ImageView createInterest(Interest interest) {

        ImageView image = new ImageView(this);
        image.setBackgroundResource(interest.pictureID);

        return image;
    }

}
