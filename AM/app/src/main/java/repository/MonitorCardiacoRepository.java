package repository;


import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entity.MonitorCardiaco;

/**
 * Created by Paulo on 30/09/2016.
 */
public class MonitorCardiacoRepository {
    public List<MonitorCardiaco> listar(){

        try {
            URL url = new URL("http://localhost:8080/WSRest-AM/rest/rUsuario");
            HttpURLConnection conecta = (HttpURLConnection) url.openConnection();
            //configuração do request
            conecta.setRequestMethod("GET");
            conecta.setRequestProperty("charset", "UTF-8");
            // status da resposta
            int status = conecta.getResponseCode();
            // ler Json
            if(status == 200){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conecta.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();

                String linha;
                //ler linha do json
                while((linha = bufferedReader.readLine()) != null){
                    stringBuilder.append(linha);
                }
                bufferedReader.close();

                MonitorCardiaco [] array = new Gson().fromJson(stringBuilder.toString(), MonitorCardiaco[].class);
                return Arrays.asList(array);
            }

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            System.out.println("Erro de url : " + e.getStackTrace());
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Erro ao conectar : " + e.getStackTrace());
            e.printStackTrace();
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Erro deconhesido : " + e.getStackTrace());
            e.printStackTrace();
        }
        return new ArrayList<MonitorCardiaco>();
    }
}
