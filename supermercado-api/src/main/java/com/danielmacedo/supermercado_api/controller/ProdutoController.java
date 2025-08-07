package com.danielmacedo.supermercado_api.controller;

import com.danielmacedo.supermercado_api.business.ProdutoService;
import com.danielmacedo.supermercado_api.dto.ProdutoDTO;
import com.danielmacedo.supermercado_api.exceptions.ResourceNotFoundException;
import com.danielmacedo.supermercado_api.infrastructure.entities.Produto;
import com.danielmacedo.supermercado_api.mapper.ProdutoMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService _produtoService;

    public ProdutoController(ProdutoService produtoService) {_produtoService = produtoService;}

    @PostMapping
    public ProdutoDTO criarProduto(@RequestBody ProdutoDTO dto) {
        Produto produto = ProdutoMapper.toEntity(dto);
        Produto salvo = _produtoService.save(produto);
        return ProdutoMapper.toDTO(salvo);
    }

    @GetMapping
    public List<ProdutoDTO> listarProdutos() {
        List<Produto> lista = _produtoService.listarTodos();
        return lista.stream()
                .map(ProdutoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProdutoDTO buscarProduto(@PathVariable Integer id) {
        Produto produto = _produtoService.buscarPorId(id);
        if (produto == null) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }
        return ProdutoMapper.toDTO(produto);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Integer id) {
        _produtoService.deletar(id);
    }
}
