package com.danielmacedo.supermercado_api.business;

import com.danielmacedo.supermercado_api.infrastructure.entities.Produto;
import java.util.List;

public interface ProdutoService {
    Produto save(Produto produto);
    List<Produto> listarTodos();
    void deletar(Integer id);
    Produto buscarPorId(Integer id);
}
