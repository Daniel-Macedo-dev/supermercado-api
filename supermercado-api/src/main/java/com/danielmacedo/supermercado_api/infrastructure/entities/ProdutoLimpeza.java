package com.danielmacedo.supermercado_api.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Limpeza")
public class ProdutoLimpeza extends Produto {

    @Column(name = "tipo_produto")
    private String _tipoProduto;

    public ProdutoLimpeza() {}

    public ProdutoLimpeza(String nome, Double preco, String tipoProduto) {
        super(nome, preco);
        _tipoProduto = tipoProduto;
    }

    public String getTipoProduto() {return _tipoProduto;}

    public void setTipoProduto(String tipoProduto) {_tipoProduto = tipoProduto;}
}
