package leomonzani.caixaeletronico.Bean;

import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;

import leomonzani.caixaeletronico.Manager.UsuarioManager;



public class Usuario implements Serializable{
    private int conta;
    private int id;
    private int saldo;
    private int agencia;
    private int senha;
    private int tipoConta; // 1 cliente 2 adm
    private String nome;


    public Usuario(){

    }

    public Usuario(int conta, int agencia, int senha, int tipoConta){
        setConta(conta);
        setAgencia(agencia);
        setSenha(senha);
        setTipoConta(tipoConta);
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public int getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}

