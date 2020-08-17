package com.jgerega107.covidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ChecklistActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);

        final Animation blink = AnimationUtils.loadAnimation(this, R.anim.blink);
        ImageView fever = (ImageView) findViewById(R.id.fever_img);
        ImageView cough = (ImageView) findViewById(R.id.cough_img);
        ImageView breathe = (ImageView) findViewById(R.id.breath_img);
        fever.setOnClickListener((View.OnClickListener) this);
        cough.setOnClickListener((View.OnClickListener) this);
        breathe.setOnClickListener((View.OnClickListener) this);

        //final GridLayout symptomGrid = (GridLayout) findViewById(R.id.symptomGrid);
        //final int count = symptomGrid.getChildCount();
        //final ImageView fever = (ImageView) findViewById(R.id.fever_img);
        //fever.setOnClickListener(new View.OnClickListener() {
    }
    @Override
    public void onClick(View v){
        switch (v.getId()) {
                case R.id.fever_img:
                    ImageView fever = (ImageView) findViewById(R.id.fever_img);
                    final Animation blink = AnimationUtils.loadAnimation(this, R.anim.blink);
                    fever.startAnimation(blink);
                    fever.setImageResource(R.drawable.ic_baseline_check_24);

            }


        }

}