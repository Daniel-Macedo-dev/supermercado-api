package com.danielmacedo.supermercado_api.infrastructure.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer _id;

    @Column(name = "nome")
    private String _nome;

    @Column(name = "preco")
    private Double _preco;

    public Produto(){}

    public Produto(String nome, Double preco){
        _nome = nome;
        _preco = preco;
    }

    public Integer getId() {return _id;}

    public void setId(Integer id) {_id = id;}

    public String getNome() {return _nome;}

    public void setNome(String nome) {_nome = nome;}

    public Double getPreco() {return _preco;}

    public void setPreco(Double preco) {_preco = preco;}
}
