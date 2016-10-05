package com.example.paulo.am;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class ListaDispositivosActivity extends AppCompatActivity {

    //Viewa
    Button btbPareado;
    ListView listaDeDispositivos;
    //Bluetooth
    private BluetoothAdapter meuBlootooth = null;
    private Set<BluetoothDevice> dispsositivosPareados;
    public static String EXTRA_ADDRESS = "device_address";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dispositivos);

        //Localiza as Views
        listaDeDispositivos = (ListView) findViewById(R.id.listView);

        //Se o dispositivo tem Bluetooth
        meuBlootooth = BluetoothAdapter.getDefaultAdapter();

        if (meuBlootooth == null) {
            //Mostra uma mensagem se o dispositivo não tem Bluetooth
            Toast.makeText(getApplicationContext(), "Bluetooth não disponível.", Toast.LENGTH_LONG).show();
            //Finaliza apk
            finish();
        } else if (!meuBlootooth.isEnabled()) {
            //Solicita a ligação do Bluetooth
            Intent turnBTon = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnBTon, 1);
        }
    }


    public void listar (View view ) {
        listaDispositivosPareados();
    }




    private void listaDispositivosPareados()
    {
        dispsositivosPareados = meuBlootooth.getBondedDevices();
        ArrayList list = new ArrayList();

        if (dispsositivosPareados.size()>0)
        {
            for(BluetoothDevice bt : dispsositivosPareados)
            {
                list.add(bt.getName() + "\n" + bt.getAddress()); //Get nome e endereço dos dispositivos
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Nenhum dispositivo Bluetooth pareado foi encontrado.", Toast.LENGTH_LONG).show();
        }

        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
        listaDeDispositivos.setAdapter(adapter);
        listaDeDispositivos.setOnItemClickListener(meuDispositivoSelecionado); //Método chamado quando um dispositivo da lista foi selecionado

    }

    private AdapterView.OnItemClickListener meuDispositivoSelecionado = new AdapterView.OnItemClickListener()
    {
        public void onItemClick (AdapterView<?> av, View v, int arg2, long arg3)
        {
            // Pega o MAC address do dispositivo selecionado, últimos 17 chars na View
            String info = ((TextView) v).getText().toString();
            String address = info.substring(info.length() - 17);

            // Instancia a activity Controle.
            Intent intentControle = new Intent(ListaDispositivosActivity.this, ControleActivity.class);

            //Envia o address.
            intentControle.putExtra(EXTRA_ADDRESS, address);
            //Inicia activity Controle.
            startActivity(intentControle);
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Menu para vocês implementarem alguma funcionalidade|
        getMenuInflater().inflate(R.menu.menu_lista_dispositivos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
