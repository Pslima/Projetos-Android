package com.example.paulo.am;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.TimerTask;

/**
 * Created by Paulo on 04/10/2016.
 */
public class TarefaCoracao extends TimerTask {

 MenuActivity corracao = new MenuActivity();


    @Override
    public void run() {
        try {
            if(corracao.coracao.getVisibility() == View.VISIBLE){
                Animation out = AnimationUtils.loadAnimation(corracao.getApplicationContext(), android.R.anim.fade_out);
                corracao.coracao.startAnimation(out);
                corracao.coracao.setVisibility(View.INVISIBLE);
            }else{
                Animation in = AnimationUtils.loadAnimation(corracao.getApplicationContext(), android.R.anim.fade_in);
                corracao.coracao.startAnimation(in);
                corracao.coracao.setVisibility(View.VISIBLE);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
