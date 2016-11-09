package leomonzani.caixaeletronico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import leomonzani.caixaeletronico.Base.BaseActivity;

public class DebAutoActivity extends BaseActivity implements View.OnClickListener {

    private Button btCancelar,
            btConfirmar;

    private EditText etData,
                     etCodigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deb_auto);

        btCancelar = (Button) findViewById(R.id.btCancelar);
        btConfirmar = (Button) findViewById(R.id.btConfirmar);
        btCancelar.setOnClickListener(this);
        btConfirmar.setOnClickListener(this);
        etData = (EditText) findViewById(R.id.etData);
        etCodigo = (EditText) findViewById(R.id.etCodigo);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btConfirmar){
            //Intent intent = new Intent(MenuAdmActivity.this, ExtMovimentacaoActivity.class);
            //startActivity(intent);
        }

        if(v.getId() == R.id.btCancelar){
            Intent intent = new Intent(DebAutoActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
