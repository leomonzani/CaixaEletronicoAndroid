package leomonzani.caixaeletronico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

import leomonzani.caixaeletronico.Base.BaseActivity;
import leomonzani.caixaeletronico.Bean.Operacao;
import leomonzani.caixaeletronico.Bean.Usuario;

public class TransferenciaActivity extends BaseActivity implements View.OnClickListener {


    private Button btConfirmar,
                   btCancelar;

    private EditText etValor,
                     etAgenciaDestinatario,
                     etContaDestinatario;
    private Usuario usuario, destinatario;
    private int conta  = 0 ,
            agencia = 0,
            valor = 0 , saldoDest = 0, saldo=0 , id=0;

    private String data;
    private Operacao op;


    private String oper = "transferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transferencia);

        usuario = (Usuario)getIntent().getExtras().get("usuario");
        op = new Operacao();
        btConfirmar = (Button) findViewById(R.id.btConfirmar);
        btCancelar = (Button) findViewById(R.id.btCancelar);
        btConfirmar.setOnClickListener(this);
        btCancelar.setOnClickListener(this);

        etValor = (EditText) findViewById(R.id.etValor);
        etAgenciaDestinatario = (EditText) findViewById(R.id.etAgenciaDestinatario);
        etContaDestinatario = (EditText) findViewById(R.id.etContaDestinatario);

    }



    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btCancelar){
            Intent intent = new Intent(TransferenciaActivity.this, MenuActivity.class);
            intent.putExtra("usuario", usuario);

            startActivity(intent);
        }

        if(v.getId() == R.id.btConfirmar){
            if(validaCamposEmBranco()) {
                if (validaAcesso(conta, agencia)) {
                    saldoDest = destinatario.getSaldo() + valor;
                    destinatario.setSaldo(saldoDest);
                    saldo = usuario.getSaldo() - valor;
                    usuario.setSaldo(saldo);

                    setMsg("" + usuario.getSaldo());


                    id = usuario.getId();
                    this.data = op.getDateTime();
                    BaseActivity.listaOperacao.add(new Operacao(data, oper,valor, id));


                    Intent intent = new Intent(TransferenciaActivity.this, MenuActivity.class);
                    intent.putExtra("usuario", usuario);

                    startActivity(intent);


                }
            }
        }
    }


    public boolean validaAcesso(int conta, int agencia) {
        //UsuarioManager usuarioManager = new UsuarioManager();
        //ArrayList<Usuario> listaUsuarios = usuarioManager.getListaUsuarios(MainActivity.this);
        for(int i = 0; i < BaseActivity.listaUsuarios.size(); i++){

            Usuario usuario = BaseActivity.listaUsuarios.get(i);
            if (conta == usuario.getConta() && agencia == usuario.getAgencia() ){
                this.destinatario = usuario;
                return true;
            }
        }
        return false;
    }

    private boolean validaCamposEmBranco(){
        if (!String.valueOf(etContaDestinatario.getText()).equals("") || !String.valueOf(etAgenciaDestinatario.getText()).equals("") || !String.valueOf(etValor.getText()).equals("")) {
            conta = Integer.parseInt(String.valueOf(etContaDestinatario.getText()));
            agencia = Integer.parseInt(String.valueOf(etAgenciaDestinatario.getText()));
            valor = Integer.parseInt(String.valueOf(etValor.getText()));
            return true;
        }
        return false;
    }
}
