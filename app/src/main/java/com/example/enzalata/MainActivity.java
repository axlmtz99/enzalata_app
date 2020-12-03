package com.example.enzalata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
ImageView ball, back;
TextView textView;
Timer tim1; TimerTask timerTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ball = findViewById(R.id.pelota);
        back= findViewById(R.id.ball);
        textView = findViewById(R.id.title1);
        ball.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);
        tim1 = new Timer();
        timerTask= new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_right);
                        Animation backanimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_right);
                        ball.startAnimation(animation);
                        back.startAnimation(backanimation);

                        textView.setVisibility(View.VISIBLE);
                    }
                });
            }
        };
        tim1.schedule(timerTask, 1000);

    }
    private void Animtext(){
        AlphaAnimation fadeIn = new AlphaAnimation(0.f,1.0f);
        fadeIn.setDuration(1000);
        fadeIn.setStartOffset(2000);
        fadeIn.setFillAfter(true);
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        AlphaAnimation fadeOut = new AlphaAnimation(1.0f,0.0f);
        fadeOut.setDuration(1000);
        fadeOut.setStartOffset(2000);
        fadeOut.setFillAfter(true);
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}