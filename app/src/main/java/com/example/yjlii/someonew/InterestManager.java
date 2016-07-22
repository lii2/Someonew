package com.example.yjlii.someonew;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Lii2 on 7/15/2016.
 */
public class InterestManager {

    public HashSet<Interest> allInterests;
    public HashSet<Interest> userInterests;

    public InterestManager() {

        userInterests = new HashSet<Interest>();
        allInterests = new HashSet<Interest>();
        fillAllInterests();

    }

    public void addInterest(Interest interest) {

        userInterests.add(interest);

    }

    public void removeInterest(Interest interest) {

        userInterests.remove(interest);

    }


    public HashSet<Interest> getUserInterests() {
        return userInterests;
    }


    public void setUserInterests(HashSet<Interest> userInterests) {

        this.userInterests = userInterests;

    }

    public void fillAllInterests() {

        allInterests.add(new Interest("cars", R.drawable.placeholderlogo));
        allInterests.add(new Interest("comics", R.drawable.placeholderlogo));
        allInterests.add(new Interest("rnb", R.drawable.placeholderlogo));
        allInterests.add(new Interest("blah", R.drawable.placeholderlogo));
        allInterests.add(new Interest("fashion", R.drawable.placeholderlogo));
        allInterests.add(new Interest("skiing", R.drawable.placeholderlogo));
        allInterests.add(new Interest("country", R.drawable.placeholderlogo));
        allInterests.add(new Interest("politics", R.drawable.placeholderlogo));
        allInterests.add(new Interest("football", R.drawable.placeholderlogo));
        allInterests.add(new Interest("videogames", R.drawable.placeholderlogo));
        allInterests.add(new Interest("partystories", R.drawable.placeholderlogo));
        allInterests.add(new Interest("travel", R.drawable.placeholderlogo));
        allInterests.add(new Interest("got", R.drawable.placeholderlogo));
        allInterests.add(new Interest("fitness", R.drawable.placeholderlogo));
        allInterests.add(new Interest("soccer", R.drawable.placeholderlogo));
        allInterests.add(new Interest("movies", R.drawable.placeholderlogo));
        allInterests.add(new Interest("rock", R.drawable.placeholderlogo));
        allInterests.add(new Interest("currentevents", R.drawable.placeholderlogo));
        allInterests.add(new Interest("technology", R.drawable.placeholderlogo));
        allInterests.add(new Interest("edm", R.drawable.placeholderlogo));
    }


}
