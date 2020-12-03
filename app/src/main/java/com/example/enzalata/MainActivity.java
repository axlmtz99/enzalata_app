package com.example.enzalata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.animation.Animator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
private ImageView ball, back;
private TextView textView;
private Button buttonStart;
private Timer tim1; TimerTask timerTask;
private Explode transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setterContent();
        animStart();
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  leaveSplash();

            }
        });
    }
    @SuppressWarnings("unchecked")
    private void startTransitions(){
        transaction.setDuration(1000);
        transaction.setInterpolator(new DecelerateInterpolator());
        getWindow().setExitTransition(transaction);
        Intent intent= new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
        this.finish();
    }
    private void leaveSplash(){
        transaction = new Explode();
        startTransitions();

    }
  public void SeeImage(View view){
      Animator animator = ViewAnimationUtils.createCircularReveal(view,
              0,
              view.getHeight(),
              0,
              view.getWidth() *1.5f);
      animator.setDuration(1000);
      view.setVisibility(View.VISIBLE);
      animator.start();
  }
    private void setterContent(){
        buttonStart = findViewById(R.id.buttonStart);
        ball = findViewById(R.id.pelota);
        back= findViewById(R.id.ball);
        textView = findViewById(R.id.title1);
        ball.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
        buttonStart.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);
    }


    private void animStart(){
        tim1 = new Timer();
        timerTask= new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_right);
                        Animation backanimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_right);
                        SeeImage(ball);
                        back.startAnimation(backanimation);
                        AnimtextIn(textView,1000);
                        AnimtextIn(buttonStart,2000);

                    }
                });
            }
        };
        tim1.schedule(timerTask, 1000);
    }

    private void AnimtextOut(View view, int DURATIONOFFSET) {
        AlphaAnimation fadeOut = new AlphaAnimation(1.0f,0.0f);
        fadeOut.setDuration(1000);
        fadeOut.setStartOffset(DURATIONOFFSET);
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
        view.startAnimation(fadeOut);
    }

    private void AnimtextIn( View view, int DURATIONOFFSET){
        AlphaAnimation fadeIn = new AlphaAnimation(0.f,1.0f);
        fadeIn.setDuration(1000);
        fadeIn.setStartOffset(DURATIONOFFSET);
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



        view.startAnimation(fadeIn);
    }
}