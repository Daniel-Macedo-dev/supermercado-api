package com.danielmacedo.supermercado_api.infrastructure.entities;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Eletronico")
public class ProdutoEletronico extends Produto{

    @Column(name = "garantia_meses")
    private Integer _garantiaMeses;

    public ProdutoEletronico(){}

    public ProdutoEletronico(String nome, Double preco, Integer garantiaMeses) {
        super(nome, preco);
        _garantiaMeses = garantiaMeses;
    }

    public Integer getGarantiaMeses() {return _garantiaMeses;}

    public void setGarantiaMeses(Integer garantiaMeses) {_garantiaMeses = garantiaMeses;}
}
