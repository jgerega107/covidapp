package com.jgerega107.covidapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        TextView welcomeText = findViewById(R.id.welcome_text);
        welcomeText.setText("Welcome, " + currentUser.getDisplayName() + "!");
    }

    public void toAboutActivity(View view){
        startActivity(new Intent(getApplicationContext(), AboutActivity.class));
    }

    public void toChecklistActivity(View view){
        startActivity(new Intent(getApplicationContext(), ChecklistActivity.class));
    }
}