package leomonzani.caixaeletronico;

    import android.app.ProgressDialog;
    import android.content.Context;
    import android.content.Intent;
    import android.os.AsyncTask;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;

    import org.json.JSONArray;
    import org.json.JSONException;
    import org.json.JSONObject;

    import java.util.ArrayList;

    import leomonzani.caixaeletronico.Adapter.ADPOperacao;
    import leomonzani.caixaeletronico.Base.BaseActivity;
    import leomonzani.caixaeletronico.Bean.Usuario;
    import leomonzani.caixaeletronico.Manager.UsuarioManager;

    public class MainActivity extends BaseActivity implements View.OnClickListener {
        private Button  btAcessar,
                btLimpar;
        private EditText etConta,
                etAgencia,
                etSenha;
        public Usuario usuario;
    private int conta = 0,
            agencia = 0,
            senha = 0;

    private int versao = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btLimpar = (Button) findViewById(R.id.btLimpar);
        btAcessar = (Button) findViewById(R.id.btAcessar);
        etConta = (EditText) findViewById(R.id.etConta);
        etAgencia = (EditText) findViewById(R.id.etAgencia);
        etSenha = (EditText) findViewById(R.id.etSenha);
        btAcessar.setOnClickListener(this);
        btLimpar.setOnClickListener(this);




        if (versao == 0){
            new AsyncCaller().execute();
            versao++;
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btAcessar) {
            if(validaCamposEmBranco()) {
                if (validaAcesso(conta, agencia, senha)) {
                    if (validaUsuarioNormal()) {
                        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                        intent.putExtra("usuario", usuario);
                        startActivity(intent);



                    } else {
                        Intent intent = new Intent(MainActivity.this, MenuAdmActivity.class);
                        intent.putExtra("usuario", usuario);
                        startActivity(intent);
                    }
                } else {
                    setMsg("Usuário invalido!");
                }
            } else{
                    setMsg("Preencha todos os Campos!");
            }
        }
        if(v.getId() == R.id.btLimpar){
            etConta.setText("");
            etAgencia.setText("");
            etSenha.setText("");
        }
    }

    private boolean validaCamposEmBranco() {
        if (!String.valueOf(etConta.getText()).equals("") || !String.valueOf(etAgencia.getText()).equals("") || !String.valueOf(etSenha.getText()).equals("")) {
            conta = Integer.parseInt(String.valueOf(etConta.getText()));
            agencia = Integer.parseInt(String.valueOf(etAgencia.getText()));
            senha = Integer.parseInt(String.valueOf(etSenha.getText()));
            return true;
        }
        return false;
    }


    public boolean validaAcesso(int conta, int agencia, int senha) {
        //UsuarioManager usuarioManager = new UsuarioManager();
        //ArrayList<Usuario> listaUsuarios = usuarioManager.getListaUsuarios(MainActivity.this);
        for(int i = 0; i < BaseActivity.listaUsuarios.size(); i++){
            Usuario usuario = BaseActivity.listaUsuarios.get(i);
            if (conta == usuario.getConta() && agencia == usuario.getAgencia() && senha == usuario.getSenha()){
                this.usuario = usuario;
                return true;
            }
        }
        return false;
    }

    public boolean validaUsuarioNormal() {
        if (usuario.getTipoConta() == 1){
            return true;
        }
        return false;
    }

        private class AsyncCaller extends AsyncTask<Void, String, String> {
            ProgressDialog pdLoading = new ProgressDialog(MainActivity.this);

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                pdLoading.setMessage("Carregar...");
                pdLoading.show();
            }

            @Override
            protected String doInBackground(Void... params) {

                String result = webserviceCall("http://www.devpauloaragao.com.br/banco.json");
                if(!result.isEmpty()){

                    try {
                        JSONArray jArray=new JSONArray(result);

                        for(int i=0;i<jArray.length();i++){
                            JSONObject jObj = jArray.getJSONObject(i);
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
                return result;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);


               pdLoading.dismiss();
            }

        }
}
