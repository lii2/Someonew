package com.example.yjlii.someonew;


import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Lii2 on 7/15/2016.
 */
public class InterestManager {

    public HashSet<Interest> userInterests;
    Resources resourcesHandler;

    public InterestManager() {

    }

    public InterestManager(Context context) {
        resourcesHandler = context.getResources();
    }

    public void addInterest(int ID) {
        userInterests.add(new Interest(ID, resourcesHandler.getResourceName(ID)));
    }

    public void removeInterest(int ID) {
        userInterests.remove(new Interest(ID, resourcesHandler.getResourceName(ID)));
    }


    public HashSet<Interest> getUserInterests() {
        return userInterests;
    }

    public void setUserInterests(HashSet<Interest> userInterests) {
        this.userInterests = userInterests;
    }

}
