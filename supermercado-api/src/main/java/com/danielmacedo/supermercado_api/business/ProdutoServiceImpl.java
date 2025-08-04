package com.danielmacedo.supermercado_api.business;

import com.danielmacedo.supermercado_api.infrastructure.entities.Produto;
import com.danielmacedo.supermercado_api.infrastructure.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository _produtorepository;

    public ProdutoServiceImpl(ProdutoRepository produtorepository) {_produtorepository = produtorepository;}

    @Override
    public Produto save(Produto produto) {return _produtorepository.save(produto);}

    @Override
    public List<Produto> listarTodos() {return _produtorepository.findAll();}

    @Override
    public void deletar(Integer id) {_produtorepository.deleteById(id);}

    @Override
    public Produto buscarPorId(Integer id) {
        Optional<Produto> produto = _produtorepository.findById(id);
        return produto.orElse(null);
    }
}
