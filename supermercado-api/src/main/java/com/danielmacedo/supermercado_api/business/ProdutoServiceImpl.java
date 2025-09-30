package com.danielmacedo.supermercado_api.business;

import com.danielmacedo.supermercado_api.infrastructure.entities.Produto;
import com.danielmacedo.supermercado_api.infrastructure.repository.ProdutoRepository;
import com.danielmacedo.supermercado_api.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto save(Produto produto) {return produtoRepository.save(produto);}

    @Override
    public List<Produto> listarTodos() {return produtoRepository.findAll();}

    @Override
    public Produto buscarPorId(Integer id) {
        return produtoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Produto com id " + id + " não encontrado."));
    }

    @Override
    public void deletar(Integer id) {
        if (!produtoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produto com id " + id + " não encontrado.");
        }
        produtoRepository.deleteById(id);
    }

    @Override
    public Produto atualizar(Integer id, Produto produtoAtualizado) {
        Produto existente = buscarPorId(id);

        existente.setNome(produtoAtualizado.getNome());
        existente.setPreco(produtoAtualizado.getPreco());

        return produtoRepository.save(existente);
    }

    @Override
    public Produto atualizarParcial(Integer id, Produto produtoParcial) {
        Produto existente = buscarPorId(id);

        if (produtoParcial.getNome() != null) existente.setNome(produtoParcial.getNome());
        if (produtoParcial.getPreco() != null) existente.setPreco(produtoParcial.getPreco());

        return produtoRepository.save(existente);
    }
}
