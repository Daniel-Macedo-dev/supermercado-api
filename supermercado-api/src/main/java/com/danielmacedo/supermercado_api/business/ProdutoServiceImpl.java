package com.danielmacedo.supermercado_api.business;

import com.danielmacedo.supermercado_api.infrastructure.entities.Produto;
import com.danielmacedo.supermercado_api.infrastructure.repository.ProdutoRepository;
import com.danielmacedo.supermercado_api.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private static final Logger log = LoggerFactory.getLogger(ProdutoServiceImpl.class);

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto save(Produto produto) {
        log.info("Salvando produto: {}", produto.getNome());
        Produto salvo = produtoRepository.save(produto);
        log.debug("Produto salvo com ID: {}", salvo.getId());
        return salvo;
    }

    @Override
    public List<Produto> listarTodos() {return produtoRepository.findAll();}

    @Override
    public Produto buscarPorId(Integer id) {
        return produtoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Produto com id " + id + " não encontrado."));
    }

    @Override
    public void deletar(Integer id) {
        log.info("Tentando deletar produto com id: {}", id);
        if (!produtoRepository.existsById(id)) {
            log.error("Falha ao deletar, produto com id {} não existe", id);
            throw new ResourceNotFoundException("Produto com id " + id + " não encontrado.");
        }
        produtoRepository.deleteById(id);
        log.info("Produto com id {} deletado com sucesso", id);
    }

    @Override
    public Produto atualizar(Integer id, Produto produtoAtualizado) {
        log.info("Atualizado produto com id: {}", id);
        Produto existente = buscarPorId(id);

        existente.setNome(produtoAtualizado.getNome());
        existente.setPreco(produtoAtualizado.getPreco());

        Produto atualizado = produtoRepository.save(existente);
        log.info("Produto com id {} atualizado com sucesso", atualizado.getId());
        return atualizado;
    }

    @Override
    public Produto atualizarParcial(Integer id, Produto produtoParcial) {
        log.info("Atualização parcial do produto cmo id: {}", id);
        Produto existente = buscarPorId(id);

        if (produtoParcial.getNome() != null) existente.setNome(produtoParcial.getNome());
        if (produtoParcial.getPreco() != null) existente.setPreco(produtoParcial.getPreco());

        Produto atualizado = produtoRepository.save(existente);
        log.info("Produto com id {} atualizado parcialmente com sucesso", atualizado.getId());
        return atualizado;
    }
}
