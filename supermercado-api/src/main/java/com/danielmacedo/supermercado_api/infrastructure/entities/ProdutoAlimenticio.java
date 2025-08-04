package com.danielmacedo.supermercado_api.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Alimenticio")
public class ProdutoAlimenticio extends Produto {

    @Column(name = "validade")
    private String _validade;

    public ProdutoAlimenticio() {}

    public ProdutoAlimenticio(String nome, Double preco, String validade) {
        super(nome, preco);
        _validade = validade;
    }

    public String getValidade() {return _validade;}

    public void setValidade(String validade) {_validade = validade;}
}
