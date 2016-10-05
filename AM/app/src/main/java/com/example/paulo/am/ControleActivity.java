package com.example.paulo.am;


import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class ControleActivity extends AppCompatActivity {


    TextView batimento = null;
    BluetoothAdapter meuBluetooth = null;
    BluetoothSocket btSocket = null;
    private boolean btConectado = false;
    private ProgressDialog progress;

    String address = null;

    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controle);
        new ConectaBT().execute();

        batimento = (TextView) findViewById(R.id.lblBATIMENTOS);

        Intent newInt = getIntent();
        //Recebe o address enviado pela ListaDispositivos
        address = newInt.getStringExtra(ListaDispositivosActivity.EXTRA_ADDRESS);
    }
    private class ConectaBT extends AsyncTask<Void, Void, Void>  // UI thread
    {
        private boolean conectado = true; //conectado

        //O método onPreExecute é opcional e executado sempre antes da Thread ser iniciada e é executado na Thread da UI
        @Override
        protected void onPreExecute() {
            progress = ProgressDialog.show(ControleActivity.this, "Conectando...", "Por favor, aguarde!!!");  //exibe progress dialog
        }

        //O método obrigatório doInBackground execiuta o processamento pesado.
        // Roda em uma Thread separada da UI
        @Override
        protected Void doInBackground(Void... devices) //Conecta enquanto progress dialog aparece
        {
            try {
                if (btSocket == null || !btConectado) {
                    meuBluetooth = BluetoothAdapter.getDefaultAdapter();//pega o dispositivo bluetooth
                    BluetoothDevice dispositivo = meuBluetooth.getRemoteDevice(address);//conecta no endereço "address" e checa se ele está disponível
                    btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);//cria uma conexão RFCOMM (SPP)
                    meuBluetooth.cancelDiscovery(); //cancela o processo de descoberta

                    btSocket.connect();

                }
            } catch (IOException e) {
                conectado = false;
                Log.e("Conexão ", e.getMessage());
            }
            return null;
        }

        //O método onPostExecute é executado na Thread da UI e recebe o retorno do doInBackground.
        @Override
        protected void onPostExecute(Void result)
        {
            super.onPostExecute(result);

            //Informa ao usuário o ststus da conexão
            if (!conectado) {
               // msg("Falha na Conexão. É uma conexão SPP Bluetooth? Tente novamente.");
                finish();
            } else {
               // msg("Conectado!");
                btConectado = true;
            }
            progress.dismiss();
        }





    }
    public void capturarBatimentos(View view){
        try {
            InputStream  receiver = btSocket.getInputStream();
            byte [] chegada = new byte[3];
            receiver.read(chegada);
            batimento.setText(new String(chegada).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
