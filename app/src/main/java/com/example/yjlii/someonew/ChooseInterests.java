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

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        interestManager = new InterestManager();

        prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);

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

        if (interestManager.userInterests.size() >4 ) {

            commit();
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



    public void commit() {

        String[] names = interestManager.getUserInterestNames();
        int[] pics = interestManager.getUserInterestPics();

        //commmits to internal memory
        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("interest_one_name", names[0]);
        editor.putString("interest_two_name", names[1]);
        editor.putString("interest_two_name", names[2]);
        editor.putString("interest_three_name", names[3]);
        editor.putString("interest_four_name", names[4]);

        editor.putInt("interest_one_pic", pics[0]);
        editor.putInt("interest_two_pic", pics[1]);
        editor.putInt("interest_three_pic", pics[2]);
        editor.putInt("interest_four_pic", pics[3]);
        editor.putInt("interest_five_pic", pics[4]);

        editor.commit();

    }
}
