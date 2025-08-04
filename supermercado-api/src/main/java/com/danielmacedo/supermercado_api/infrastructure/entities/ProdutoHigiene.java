package com.danielmacedo.supermercado_api.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Higiene")
public class ProdutoHigiene extends Produto {

    @Column(name = "indicacao")
    private String _indicacao;

    public ProdutoHigiene(){}

    public ProdutoHigiene(String nome, Double preco, String indicacao) {
        super(nome, preco);
        _indicacao = indicacao;
    }

    public String getIndicacao() {return _indicacao;}

    public void setIndicacao(String indicacao) {_indicacao = indicacao;}
}
