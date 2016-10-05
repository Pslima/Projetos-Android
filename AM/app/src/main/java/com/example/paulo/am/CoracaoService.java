package com.example.paulo.am;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Timer;

public class CoracaoService extends Service {

    private Timer timer;
    private TarefaCoracao tarefa;

    public CoracaoService() {
    }

    @Override
    public void onCreate() {
        timer = new Timer();
        tarefa = new TarefaCoracao();
        timer.schedule(tarefa, 5000, 1000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
        tarefa.cancel();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
