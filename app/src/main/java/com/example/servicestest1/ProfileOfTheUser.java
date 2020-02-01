package com.example.servicestest1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProfileOfTheUser extends AppCompatActivity {
    ImageView closeActivityImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_of_the_user);
        closeActivityImageView = findViewById(R.id.close_profile_activity_button);
        closeActivityImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileOfTheUser.this.finish();
            }
        });
    }
}
