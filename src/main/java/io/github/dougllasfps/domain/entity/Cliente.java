package io.github.dougllasfps.domain.entity;

public class Cliente {

    private Integer id;
    private  String nome;

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
