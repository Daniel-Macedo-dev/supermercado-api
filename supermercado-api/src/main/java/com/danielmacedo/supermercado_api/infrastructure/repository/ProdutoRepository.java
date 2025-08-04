package com.danielmacedo.supermercado_api.infrastructure.repository;

import com.danielmacedo.supermercado_api.infrastructure.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
