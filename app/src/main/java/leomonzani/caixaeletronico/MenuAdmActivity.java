package leomonzani.caixaeletronico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import leomonzani.caixaeletronico.Base.BaseActivity;

public class MenuAdmActivity extends BaseActivity implements View.OnClickListener {

    private Button btOperacao,
                   btNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_adm);

        btOperacao = (Button) findViewById(R.id.btOperacao);
        btNotas = (Button) findViewById(R.id.btNotas);
        btOperacao.setOnClickListener(this);
        btNotas.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btOperacao){
            Intent intent = new Intent(MenuAdmActivity.this, ExtMovimentacaoActivity.class);
            startActivity(intent);
        }

        if(v.getId() == R.id.btNotas){
            Intent intent = new Intent(MenuAdmActivity.this, ExtNotasActivity.class);
            startActivity(intent);
        }
    }
}
