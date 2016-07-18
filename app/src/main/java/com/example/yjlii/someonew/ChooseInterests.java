package com.example.yjlii.someonew;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class ChooseInterests extends AppCompatActivity {

    ArrayList<Integer> userInterests = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_choose_interests);
    }

    public void onCreate(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.logoview1);
        //add to userInterests

    }
}
