package leomonzani.caixaeletronico.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import leomonzani.caixaeletronico.Bean.Operacao;
import leomonzani.caixaeletronico.R;


public class ADPOperacao extends BaseAdapter {
    private Context context;
    private List<Operacao> items;


    public ADPOperacao (Context context, List<Operacao> items){
        this.items = items;
        this.context = context;

    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.adp_operacao, null);
        TextView txtData = (TextView) view.findViewById(R.id.txtData);
        TextView txtOperacao = (TextView) view.findViewById(R.id.txtOperacao);
        TextView txtValor = (TextView) view.findViewById(R.id.txtValor);
        txtData.setText(items.get(position).getData());
        txtOperacao.setText(items.get(position).getTipo_operacao());
        txtValor.setText("R$"+items.get(position).getValor()+",00");
        return view;



    }
}
