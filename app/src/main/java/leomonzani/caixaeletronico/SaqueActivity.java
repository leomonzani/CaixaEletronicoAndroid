package leomonzani.caixaeletronico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

import leomonzani.caixaeletronico.Base.BaseActivity;
import leomonzani.caixaeletronico.Bean.Operacao;
import leomonzani.caixaeletronico.Bean.Usuario;

public class SaqueActivity extends BaseActivity implements View.OnClickListener {


    private Button btCinco,
            btDez,
            btVinte,
            btCinquenta,
            btCem,
            btOutro,
            btSair;
        private String data;
    private Operacao op;

     private int saldo, valor, id;
    private String oper = "saque";

    public Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saque);
        op = new Operacao();
        usuario = (Usuario)getIntent().getExtras().get("usuario");

        btCinco = (Button) findViewById(R.id.btCinco);
        btDez = (Button) findViewById(R.id.btDez);
        btVinte = (Button) findViewById(R.id.btVinte);
        btCinquenta = (Button) findViewById(R.id.btCinquenta);
        btOutro = (Button) findViewById(R.id.btOutro);
        btSair = (Button) findViewById(R.id.btSair);
        btCem = (Button) findViewById(R.id.btCem);
        btCinco.setOnClickListener(this);
        btDez.setOnClickListener(this);
        btVinte.setOnClickListener(this);
        btCinquenta.setOnClickListener(this);
        btOutro.setOnClickListener(this);
        btSair.setOnClickListener(this);
        btCem.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btCinco){
            saldo = usuario.getSaldo() - 5;
            usuario.setSaldo(saldo);
            setMsg("Saque concluido");

            id = usuario.getId();
            this.data = op.getDateTime();
            valor = 5;
            BaseActivity.listaOperacao.add(new Operacao(data, oper,valor, id));


            Intent intent = new Intent(SaqueActivity.this, MenuActivity.class);
            intent.putExtra("usuario", usuario);

            startActivity(intent);

        }

        if(v.getId() == R.id.btDez){
            saldo = usuario.getSaldo() - 10;
            usuario.setSaldo(saldo);
            setMsg("Saque concluido");

            id = usuario.getId();
            this.data = op.getDateTime();
            valor = 10;
            BaseActivity.listaOperacao.add(new Operacao(data, oper,valor, id));
            Intent intent = new Intent(SaqueActivity.this, MenuActivity.class);
            intent.putExtra("usuario", usuario);

            startActivity(intent);

        }

        if(v.getId() == R.id.btVinte){
            saldo = usuario.getSaldo() - 20;
            usuario.setSaldo(saldo);
            setMsg("Saque concluido");

            id = usuario.getId();
            this.data = op.getDateTime();
            valor = 20;
            BaseActivity.listaOperacao.add(new Operacao(data, oper,valor, id));
            Intent intent = new Intent(SaqueActivity.this, MenuActivity.class);
            intent.putExtra("usuario", usuario);

            startActivity(intent);

        }

        if(v.getId() == R.id.btCinquenta){
            saldo = usuario.getSaldo() - 50;
            usuario.setSaldo(saldo);
            setMsg("Saque concluido");

            id = usuario.getId();
            this.data = op.getDateTime();
            valor = 50;
            BaseActivity.listaOperacao.add(new Operacao(data, oper,valor, id));
            Intent intent = new Intent(SaqueActivity.this, MenuActivity.class);
            intent.putExtra("usuario", usuario);

            startActivity(intent);

        }

        if(v.getId() == R.id.btCem){
            saldo = usuario.getSaldo() - 100;
            usuario.setSaldo(saldo);
            setMsg("Saque concluido");

            id = usuario.getId();
            this.data = op.getDateTime();
            valor = 100;
            BaseActivity.listaOperacao.add(new Operacao(data, oper,valor, id));
            Intent intent = new Intent(SaqueActivity.this, MenuActivity.class);
            intent.putExtra("usuario", usuario);

            startActivity(intent);

        }

        if(v.getId() == R.id.btOutro){
            Intent intent = new Intent(SaqueActivity.this, OutroValorActivity.class);
            intent.putExtra("usuario", usuario);

            startActivity(intent);
        }

        if(v.getId() == R.id.btSair){
            Intent intent = new Intent(SaqueActivity.this, MainActivity.class);
            intent.putExtra("usuario", usuario);

            startActivity(intent);
        }

    }
}
