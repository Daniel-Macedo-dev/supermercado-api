package com.danielmacedo.supermercado_api.business;

import com.danielmacedo.supermercado_api.infrastructure.entities.Produto;

import java.util.List;

public interface ProdutoService {
    Produto save(Produto produto);
    List<Produto> listarTodos();
    Produto buscarPorId(Integer id);
    void deletar(Integer id);
    Produto atualizar(Integer id, Produto produtoAtualizado);
    Produto atualizarParcial(Integer id, Produto produtoParcial);
}
