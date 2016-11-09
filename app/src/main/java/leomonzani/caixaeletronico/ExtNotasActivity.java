package leomonzani.caixaeletronico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import leomonzani.caixaeletronico.Base.BaseActivity;

public class ExtNotasActivity extends BaseActivity {

    private ListView lvNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ext_notas);

        lvNotas = (ListView) findViewById(R.id.lvNotas);

    }
}
