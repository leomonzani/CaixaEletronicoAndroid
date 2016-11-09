package leomonzani.caixaeletronico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import leomonzani.caixaeletronico.Adapter.ADPOperacao;
import leomonzani.caixaeletronico.Base.BaseActivity;
import leomonzani.caixaeletronico.Bean.Operacao;

public class ExtratoActivity extends BaseActivity  {

    private RadioButton rbAtual,
                        rbAnterior,
                        rbNoventa;

    private RadioGroup rgGrupo;

    private ListView lvTransacao;

    private ArrayList<Operacao> listaOp;

    private ADPOperacao adp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extrato);

        lvTransacao = (ListView) findViewById(R.id.lvTransacao);
        listaOp = BaseActivity.listaOperacao;




        rgGrupo = (RadioGroup) findViewById(R.id.rgGrupo);

        rbAtual = (RadioButton) findViewById(R.id.rbAtual);
        rbAnterior = (RadioButton) findViewById(R.id.rbAnterior);
        rbNoventa = (RadioButton) findViewById(R.id.rbNoventa);


        adp =new ADPOperacao(ExtratoActivity.this, listaOp);
        lvTransacao.setAdapter(adp);



        switch (rgGrupo.getCheckedRadioButtonId()){
            case R.id.rbAtual:

                break;
            case R.id.rbAnterior:
                setMsg("Nenhuma Operação Realizada no mês anterior");
                break;
            case R.id.rbNoventa:
                setMsg("Nenhuma Operação Realizada nos Últimos Noventa Dias");
                break;

        }

    }



}
