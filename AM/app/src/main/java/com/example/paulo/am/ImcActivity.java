package com.example.paulo.am;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ImcActivity extends AppCompatActivity {

    TextView resultado;
    Button btnCalcularIMC;
    EditText peso;
    EditText altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_imc);

        resultado = (TextView) findViewById(R.id.lblResultadoIMC);
        peso = (EditText) findViewById(R.id.edtPeso);
        altura = (EditText) findViewById(R.id.edtAltura);
    }

    public void calcularIMC (View view){
        float result;
        String texto = "";

        result = (Float.parseFloat(peso.getText().toString()) / (Float.parseFloat(altura.getText().toString()) * 2 ));

        if(result <=17){
            texto = "Muito abaixo do peso";
        }
        if(result >=17.01 && result <=18.49){
            texto = "Abaixo do peso";
        }
        if(result >=18.50 && result <=24.99){
            texto = "Peso Normal";
        }
        if(result >=25 && result <=29.99){
            texto = "Acima do peso";
        }
        if(result >=30 && result <=34.99){
            texto = "Obesidade I";
        }
        if(result >=35 && result <=39.99){
            texto = "Obesidade II (severa)";
        }
        if(result >=40){
            texto = "Obesidade III (morbida)";
        }
        resultado.setText(String.valueOf(texto) + "\nIMC = " + result);
    }
}
