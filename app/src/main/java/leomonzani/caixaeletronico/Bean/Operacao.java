package leomonzani.caixaeletronico.Bean;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Operacao implements Serializable{

    private String data;
    private String tipo_operacao;
    private int valor;
    private int id_usuario;




    public  Operacao(String data, String tipo_operacao, int valor, int id_usuario) {

        this.setData(data);
        this.setTipo_operacao(tipo_operacao);
        this.setValor(valor);
        this.setI_usuario(id_usuario);

    }
    public Operacao(){}

    public String getDateTime() {


        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatar;
        formatar = new SimpleDateFormat("dd/MM/yyyy");
        return formatar.format(data);
    }

    public String getTipo_operacao() {
        return tipo_operacao;
    }

    public void setTipo_operacao(String tipo_operacao) {
        this.tipo_operacao = tipo_operacao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setI_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}