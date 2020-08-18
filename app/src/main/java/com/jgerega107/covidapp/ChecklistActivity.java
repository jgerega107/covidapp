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

public class ChecklistActivity extends AppCompatActivity {

    Animation blink;
    ImageView fever;
    ImageView cough;
    ImageView breath;
    ImageView fatigue;
    ImageView muscle;
    ImageView headache;
    ImageView taste;
    ImageView sore;
    ImageView con;
    ImageView vomit;
    ImageView dir;
    ImageView check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);
        blink = AnimationUtils.loadAnimation(this, R.anim.blink);
        fever = (ImageView) findViewById(R.id.fever_img);
        cough = (ImageView) findViewById(R.id.cough_img);
        breath = (ImageView) findViewById(R.id.breath_img);
        fatigue = (ImageView) findViewById(R.id.fatigue_img);
        muscle = (ImageView) findViewById(R.id.muscle_img);
        headache = (ImageView) findViewById(R.id.headache_img);
        taste = (ImageView) findViewById(R.id.taste_img);
        sore = (ImageView) findViewById(R.id.sore_img);
        con = (ImageView) findViewById(R.id.con_img);
        vomit = (ImageView) findViewById(R.id.vomit_img);
        dir = (ImageView) findViewById(R.id.dir_img);


    }
    public void onClicked(View v){
        switch (v.getId()) {
                case R.id.fever_img:
                    fever.startAnimation(blink);
                    fever.setImageResource(R.drawable.ic_baseline_check_24);
                    break;
                case R.id.cough_img:
                    cough.startAnimation(blink);
                    cough.setImageResource(R.drawable.ic_baseline_check_24);
                    break;
                case R.id.breath_img:
                    breath.startAnimation(blink);
                    breath.setImageResource(R.drawable.ic_baseline_check_24);
                    break;
                case R.id.fatigue_img:
                    fatigue.startAnimation(blink);
                    fatigue.setImageResource(R.drawable.ic_baseline_check_24);
                    break;
                case R.id.muscle_img:
                    muscle.startAnimation(blink);
                    muscle.setImageResource(R.drawable.ic_baseline_check_24);
                    break;
                case R.id.headache_img:
                    headache.startAnimation(blink);
                    headache.setImageResource(R.drawable.ic_baseline_check_24);
                    break;
                case R.id.taste_img:
                    taste.startAnimation(blink);
                    taste.setImageResource(R.drawable.ic_baseline_check_24);
                    break;
                case R.id.sore_img:
                    sore.startAnimation(blink);
                    sore.setImageResource(R.drawable.ic_baseline_check_24);
                    break;
                case R.id.con_img:
                    con.startAnimation(blink);
                    con.setImageResource(R.drawable.ic_baseline_check_24);
                    break;
                case R.id.vomit_img:
                    vomit.startAnimation(blink);
                    vomit.setImageResource(R.drawable.ic_baseline_check_24);
                    break;
                case R.id.dir_img:
                    dir.startAnimation(blink);
                    dir.setImageResource(R.drawable.ic_baseline_check_24);
                    break;
        }


        }

}