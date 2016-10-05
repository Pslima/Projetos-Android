package com.example.paulo.am;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;

public class MenuActivity extends AppCompatActivity implements Animation.AnimationListener {

    ImageView coracao;
    Intent servico;

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        coracao = (ImageView) findViewById(R.id.imvCoracao);
        servico = new Intent(this, CoracaoService.class);
        //startService(servico);

        timer = new Timer();
        //timer.schedule(coracaoB(), 5000, 1000);

    }

    public void coracaoB(){
        if(coracao.getVisibility() == View.VISIBLE){
            Animation out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
            coracao.startAnimation(out);
            coracao.setVisibility(View.INVISIBLE);
        }else{
            Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
            coracao.startAnimation(in);
            coracao.setVisibility(View.VISIBLE);

        }
    }
    public void aaa(View view){
        coracaoB();
    }

    @Override
    public void finish() {
        super.finish();
        stopService(servico);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        if(coracao.getVisibility() == View.VISIBLE){
            Animation out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
            coracao.startAnimation(out);
            coracao.setVisibility(View.INVISIBLE);
        }else{
            Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
            coracao.startAnimation(in);
            coracao.setVisibility(View.VISIBLE);

        }
    }
}
