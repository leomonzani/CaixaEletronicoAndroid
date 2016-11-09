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

public class OutroValorActivity extends BaseActivity implements View.OnClickListener {


    private Button btConfirmar,
            btLimpar,
            btCancelar;

    private EditText etValor;
    public Usuario usuario;
    private String data;
    private Operacao op;

    private int saldo, valor, id;
    private String oper = "saque";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outro_valor);

        usuario = (Usuario)getIntent().getExtras().get("usuario");

        btConfirmar = (Button) findViewById(R.id.btConfirmar);
        btLimpar = (Button) findViewById(R.id.btLimpar);
        btCancelar = (Button) findViewById(R.id.btCancelar);
        btConfirmar.setOnClickListener(this);
        btLimpar.setOnClickListener(this);
        btCancelar.setOnClickListener(this);

        etValor = (EditText) findViewById(R.id.etValor);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btCancelar){
            Intent intent = new Intent(OutroValorActivity.this, MenuActivity.class);
            intent.putExtra("usuario", usuario);

            startActivity(intent);
        }

        if(v.getId() == R.id.btConfirmar){
            valor = Integer.parseInt(String.valueOf(etValor.getText()));
          saldo = usuario.getSaldo() -  valor ;
            usuario.setSaldo(saldo);
            setMsg("Saque concluido");

            id = usuario.getId();
            this.data = op.getDateTime();
            BaseActivity.listaOperacao.add(new Operacao(data, oper,valor, id));
            Intent intent = new Intent(OutroValorActivity.this, MenuActivity.class);
            intent.putExtra("usuario", usuario);

            startActivity(intent);

        }

        if(v.getId() == R.id.btLimpar){

            etValor.setText("");
        }
    }
}
