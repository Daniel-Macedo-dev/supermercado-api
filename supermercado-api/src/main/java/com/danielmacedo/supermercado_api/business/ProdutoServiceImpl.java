package com.danielmacedo.supermercado_api.business;

import com.danielmacedo.supermercado_api.infrastructure.entities.Produto;
import com.danielmacedo.supermercado_api.infrastructure.repository.ProdutoRepository;
import com.danielmacedo.supermercado_api.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository _produtorepository;

    public ProdutoServiceImpl(ProdutoRepository produtorepository) {
        _produtorepository = produtorepository;
    }

    @Override
    public Produto save(Produto produto) {
        return _produtorepository.save(produto);
    }

    @Override
    public List<Produto> listarTodos() {
        return _produtorepository.findAll();
    }

    @Override
    public void deletar(Integer id) {
        if (!_produtorepository.existsById(id)) {
            throw new ResourceNotFoundException("Produto com id " + id + " não encontrado.");
        }
        _produtorepository.deleteById(id);
    }

    @Override
    public Produto buscarPorId(Integer id) {
        return _produtorepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto com id " + id + " não encontrado."));
    }
}
