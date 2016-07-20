package com.example.yjlii.someonew;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class ChooseInterests extends AppCompatActivity {

    InterestManager interestManager = new InterestManager();
    public int[] INTEREST_ARRAY = new int[19];
    {
        INTEREST_ARRAY[0] = R.drawable.cars;
        INTEREST_ARRAY[1] = R.drawable.comics;
        INTEREST_ARRAY[2] = R.drawable.cooking;
        INTEREST_ARRAY[3] = R.drawable.country;
        INTEREST_ARRAY[4] = R.drawable.currentevents;
        INTEREST_ARRAY[5] = R.drawable.edmdance;
        INTEREST_ARRAY[6] = R.drawable.entrepreneurship;
        INTEREST_ARRAY[7] = R.drawable.football;
        INTEREST_ARRAY[8] = R.drawable.healthfitness;
        INTEREST_ARRAY[9] = R.drawable.meaningoflife;
        INTEREST_ARRAY[10] = R.drawable.movies;
        INTEREST_ARRAY[11] = R.drawable.outdoor;
        INTEREST_ARRAY[12] = R.drawable.partystories;
        INTEREST_ARRAY[13] = R.drawable.pokemon;
        INTEREST_ARRAY[14] = R.drawable.politics;
        INTEREST_ARRAY[15] = R.drawable.rock;
        INTEREST_ARRAY[16] = R.drawable.soccer;
        INTEREST_ARRAY[17] = R.drawable.technology;
        INTEREST_ARRAY[19] = R.drawable.videogames;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_choose_interests);
    }

    public void addInterest(View view) {


        if (interestManager.getUserInterests().size() >= 5) {
            goToProfile(view);
        }
    }

    public void goToProfile(View view){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

}
