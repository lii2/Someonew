package com.example.yjlii.someonew;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.HashSet;

public class ChooseInterests extends AppCompatActivity {

    InterestManager interestManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        interestManager = new InterestManager();

        setContentView(R.layout.activity_choose_interests);

        FlexboxLayout interestsContainer = (FlexboxLayout) findViewById(R.id.interestsContainer);

        for (Interest interest : interestManager.allInterests) {
            interestsContainer.addView(createButton(interest));
        }
    }

    public void goToProfile(View view){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void goToProfile(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void addInterest(Interest interest) {
        interestManager.userInterests.add(interest);

        if (interestManager.userInterests.size() > 4) {
            /*SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(interest.name, "figure this out");
            editor.commit();*/

            goToProfile();
        }
    }


    private Button createButton(Interest interest) {

        final Interest temp = new Interest(interest.name, interest.pictureID);

        Button button = new Button(this);
        button.setBackgroundResource(interest.pictureID);
        button.setText(String.valueOf(interest.name));

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                addInterest(temp);
            }


        });

        return button;
    }
}
