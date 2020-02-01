package com.example.servicestest1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends AppCompatActivity {
    TextView rejectButton;
    Button acceptButton;
    CircleImageView profilePictureOfTheUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rejectButton = findViewById(R.id.reject_button);
        acceptButton = findViewById(R.id.accept_button);
        profilePictureOfTheUser = findViewById(R.id.profile_picture);
        profilePictureOfTheUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileOfTheUser.class);
                startActivity(intent);
            }
        });
        rejectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View dialogView = getLayoutInflater().inflate(R.layout.reject_alert_layout,null);
                TextView rejectButton = dialogView.findViewById(R.id.cancel_button_for_rejecting_service);
                Button doneButtonForRejectNote = dialogView.findViewById(R.id.done_button_rejecting_service);
                EditText rejectNoteEditText = dialogView.findViewById(R.id.reject_note);
                rejectNoteEditText.setSelection(0);

                builder.setView(dialogView);
                final AlertDialog dialog = builder.create();
                dialog.show();

                doneButtonForRejectNote.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this,"Your reason has been registered",Toast.LENGTH_SHORT).show();
                    }
                });
                rejectButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }

        });

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Accept Button Clicked");
            }
        });
    }
}
