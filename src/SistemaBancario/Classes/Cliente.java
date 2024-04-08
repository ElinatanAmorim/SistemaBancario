package SistemaBancario.Classes;

import SistemaBancario.Enum.Status;

import java.util.Date;

public class Cliente {
    private String id;
    private String classificacao;
    private String nome;
    private Date dataCadastro;
    private Status status;

    public Cliente(String id, String classificacao, String nome) {
        this.id = id;
        this.nome = nome;
        this.dataCadastro = new Date(); // Data atual
        this.status = Status.ATIVA; // Novos clientes são ativos por padrão
        this.classificacao = classificacao;
    }

    public String getId() {
        return id;
    }

    public String getClassificacao() {
        return classificacao;
    }
}
