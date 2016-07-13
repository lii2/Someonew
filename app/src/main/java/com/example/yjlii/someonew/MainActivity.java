package com.example.yjlii.someonew;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    boolean status = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void popup(View view){

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(!status) {

            FragmentOne f1 = new FragmentOne();
            fragmentTransaction.add(R.id.fragment_container, f1);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            status = true;
        }



    }

    public void goToInterest(View view){
        Intent intent = new Intent(this, InterestActivity.class);
        startActivity(intent);
    }
}
