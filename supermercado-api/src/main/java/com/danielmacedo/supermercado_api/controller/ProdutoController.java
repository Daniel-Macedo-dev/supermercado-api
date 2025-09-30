package com.danielmacedo.supermercado_api.controller;

import com.danielmacedo.supermercado_api.business.ProdutoService;
import com.danielmacedo.supermercado_api.dto.ProdutoDTO;
import com.danielmacedo.supermercado_api.infrastructure.entities.Produto;
import com.danielmacedo.supermercado_api.mapper.ProdutoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO dto) {
        Produto produto = ProdutoMapper.toEntity(dto);
        Produto salvo = produtoService.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProdutoMapper.toDTO(salvo));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
        List<ProdutoDTO> listaDTO = produtoService.listarTodos()
                .stream()
                .map(ProdutoMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscarProduto(@PathVariable Integer id) {
        Produto produto = produtoService.buscarPorId(id);
        return ResponseEntity.ok(ProdutoMapper.toDTO(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Integer id,
                                                       @RequestBody ProdutoDTO dto) {
        Produto produtoAtualizado = produtoService.atualizar(id, ProdutoMapper.toEntity(dto));
        return ResponseEntity.ok(ProdutoMapper.toDTO(produtoAtualizado));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizarParcial(@PathVariable Integer id,
                                                       @RequestBody ProdutoDTO dto) {
        Produto produtoAtualizado = produtoService.atualizar(id, ProdutoMapper.toEntity(dto));
        return ResponseEntity.ok(ProdutoMapper.toDTO(produtoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Integer id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
