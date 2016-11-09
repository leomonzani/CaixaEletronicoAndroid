package leomonzani.caixaeletronico.Base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import leomonzani.caixaeletronico.Bean.Operacao;
import leomonzani.caixaeletronico.Bean.Usuario;
import leomonzani.caixaeletronico.MainActivity;
import leomonzani.caixaeletronico.Manager.UsuarioManager;
import leomonzani.caixaeletronico.SaldoActivity;
import leomonzani.caixaeletronico.SplashActivity;
import leomonzani.caixaeletronico.Utils.DSSharePreferenceUtility;


public class BaseActivity extends Activity {
    public static ArrayList<Usuario> listaUsuarios;
    public static ArrayList<Operacao> listaOperacao;

    private static int  versao = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        if (versao == 0){


            listaUsuarios =  new ArrayList<Usuario>();
            listaOperacao =  new ArrayList<Operacao>();

            versao++;
        }

    }

    public void recebeJSON2(){
        try {
            JSONArray jsonArray = new JSONArray(loadJSONFromAsset());

            for(int i = 0; i < jsonArray.length() ; i++){
                JSONObject jObj = jsonArray.getJSONObject(i);
                Usuario cliente = new Usuario();
                cliente.setId(jObj.getInt("id"));
                cliente.setNome(jObj.getString("nome"));
                cliente.setTipoConta(jObj.getInt("tipo_conta"));
                cliente.setAgencia(jObj.getInt("agencia"));
                cliente.setConta(jObj.getInt("conta"));
                cliente.setSenha(jObj.getInt("senha"));
                cliente.setSaldo(jObj.getInt("saldo"));




                BaseActivity.listaUsuarios.add(cliente);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("banco.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    protected void salvarListaUsuarios() {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario usuario = listaUsuarios.get(i);
            new UsuarioManager().addNewUsuario(usuario, BaseActivity.this);
        }
    }

    protected void setMsg(String mensagem) {
        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_LONG).show();
    }



    public boolean alteraVersao(Context context) {
        try {
            int versao = 1;
            DSSharePreferenceUtility.removeSharedPreferences(context, "VERSAO");
            DSSharePreferenceUtility.writeObjectToFile(context, versao, "VERSAO");
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    protected String webserviceCall(String sUrl) {
        try {
            URL url = new URL(sUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                return convertStreamToString(in);

            } finally {
                urlConnection.disconnect();
            }
        } catch (Exception e) {
            //TODO Error
        }
        return null;
    }

    protected String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
