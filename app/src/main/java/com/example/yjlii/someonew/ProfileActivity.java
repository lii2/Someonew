package com.example.yjlii.someonew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.Profile;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Profile currentUser = Profile.getCurrentProfile();

        setContentView(R.layout.activity_profile);

        TextView FBID=(TextView)findViewById(R.id.FBID);
        FBID.setText(currentUser.getFirstName() + " " + currentUser.getLastName());

        TextView FBname=(TextView)findViewById(R.id.FBname);
        FBID.setText(currentUser.getId());

        ImageView ProfilePic = (ImageView) findViewById(R.id.profileView);
        ProfilePic.setImageURI(currentUser.getProfilePictureUri(500, 500));


    }

    public void goToMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
