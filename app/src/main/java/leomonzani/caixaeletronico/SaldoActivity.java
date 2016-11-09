package leomonzani.caixaeletronico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import leomonzani.caixaeletronico.Base.BaseActivity;
import leomonzani.caixaeletronico.Bean.Usuario;

public class SaldoActivity extends BaseActivity implements View.OnClickListener {


    private Button btSair;
    public Usuario usuario;

    private TextView txtSaldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saldo);

        btSair = (Button) findViewById(R.id.btSair);
        btSair.setOnClickListener(this);

        usuario = (Usuario)getIntent().getExtras().get("usuario");

        txtSaldo = (TextView) findViewById(R.id.txtSaldo);
        txtSaldo.setText("" + usuario.getSaldo());
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btSair){
            Intent intent = new Intent(SaldoActivity.this, MenuActivity.class);
            intent.putExtra("usuario", usuario);

            startActivity(intent);
        }
    }
}
