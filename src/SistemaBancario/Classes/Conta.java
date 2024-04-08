package SistemaBancario.Classes;

import SistemaBancario.Enum.Classificacao;
import SistemaBancario.Enum.Status;
import SistemaBancario.Enum.TipoAcao;

import java.util.Date;

public abstract class Conta {
    private int id;
    private double saldo;
    private Date dataAtualizacao;
    private Status status;
    private Classificacao classificacao;
    private String idUsuario;

    public Conta(int id, String idUsuario) {
        this.id = id;
        this.saldo = 1000.0; // Saldo inicial de mil reais eu criei para facilitar meu entendimento
        this.dataAtualizacao = new Date(); // Data atual
        this.status = Status.ATIVA; // Nova conta é ativa por padrão
        this.classificacao = getClassificacao(); // Nova conta é ativa por padrão
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public Status getStatus() {
        return status;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    protected void adicionarAcao(TipoAcao tipo, double valorPretendido, double valorReal, String usuarioOrigem, String usuarioDestino, String observacao) {

    }

    public abstract void sacar(double valor);

    public abstract void depositar(double valor);

    public abstract void transferir(double valor, String usuarioDestino);

    public abstract void investir(double valor);

    public abstract double consultarSaldo();
}

