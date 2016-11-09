package leomonzani.caixaeletronico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import leomonzani.caixaeletronico.Base.BaseActivity;

public class ExtMovimentacaoActivity extends BaseActivity {

    private ListView lvTransacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ext_movimentacao);

        lvTransacao = (ListView) findViewById(R.id.lvTransacao);
    }
}
