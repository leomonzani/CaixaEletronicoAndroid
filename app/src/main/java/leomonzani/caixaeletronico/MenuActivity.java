package leomonzani.caixaeletronico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import leomonzani.caixaeletronico.Base.BaseActivity;
import leomonzani.caixaeletronico.Bean.Usuario;

public class MenuActivity extends BaseActivity implements View.OnClickListener {


    private Button btDebito,
            btTransferencia,
            btSacar,
            btExtrato,
            btSair,
            btSaldo;
    public Usuario usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        usuario = (Usuario)getIntent().getExtras().get("usuario");

        btDebito = (Button) findViewById(R.id.btDebito);
        btTransferencia = (Button) findViewById(R.id.btTransferencia);
        btSacar = (Button) findViewById(R.id.btSacar);
        btExtrato = (Button) findViewById(R.id.btExtrato);
        btSair = (Button) findViewById(R.id.btSair);
        btSaldo = (Button) findViewById(R.id.btSaldo);
        btDebito.setOnClickListener(this);
        btTransferencia.setOnClickListener(this);
        btSacar.setOnClickListener(this);
        btExtrato.setOnClickListener(this);
        btSair.setOnClickListener(this);
        btSaldo.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btSacar){
            Intent intent = new Intent(MenuActivity.this, SaqueActivity.class);
            intent.putExtra("usuario", usuario);
            startActivity(intent);


        }

        if(v.getId() == R.id.btSaldo){
            Intent intent = new Intent(MenuActivity.this, SaldoActivity.class);
            intent.putExtra("usuario", usuario);
            startActivity(intent);
        }

        if(v.getId() == R.id.btTransferencia){
            Intent intent = new Intent(MenuActivity.this, TransferenciaActivity.class);
            intent.putExtra("usuario", usuario);
            startActivity(intent);
        }

        if(v.getId() == R.id.btExtrato){
            Intent intent = new Intent(MenuActivity.this, ExtratoActivity.class);
            intent.putExtra("usuario", usuario);
            startActivity(intent);
        }

        if(v.getId() == R.id.btDebito){
            Intent intent = new Intent(MenuActivity.this, DebAutoActivity.class);
            intent.putExtra("usuario", usuario);
            startActivity(intent);
        }

        if(v.getId() == R.id.btSair){
            Intent intent = new Intent(MenuActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
