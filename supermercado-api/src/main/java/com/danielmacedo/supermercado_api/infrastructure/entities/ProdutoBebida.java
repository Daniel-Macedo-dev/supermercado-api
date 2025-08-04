package com.danielmacedo.supermercado_api.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Bebida")
public class ProdutoBebida extends Produto{

    @Column(name = "volume_ml")
    private Integer _volumeMl;

    public ProdutoBebida(){}

    public ProdutoBebida(String nome, Double preco, Integer volumeMl) {
        super(nome, preco);
        _volumeMl = volumeMl;
    }

    public Integer getVolumeMl() {return _volumeMl;}

    public void setVolumeMl(Integer volumeMl) {_volumeMl = volumeMl;}
}
