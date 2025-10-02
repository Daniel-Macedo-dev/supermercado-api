package com.danielmacedo.supermercado_api.controller;

import com.danielmacedo.supermercado_api.business.ProdutoService;
import com.danielmacedo.supermercado_api.dto.ProdutoDTO;
import com.danielmacedo.supermercado_api.infrastructure.entities.Produto;
import com.danielmacedo.supermercado_api.mapper.ProdutoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
@Slf4j
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO dto) {
        log.info("Requisição POST /produtos para criar produtos");
        Produto produto = ProdutoMapper.toEntity(dto);
        Produto salvo = produtoService.save(produto);
        log.debug("Produto criado com id {}", salvo.getId());
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
        log.info("Requisição PUT /produtos/{} para atualização completa", id);
        Produto produtoAtualizado = produtoService.atualizar(id, ProdutoMapper.toEntity(dto));
        log.debug("Produto atualizado com sucesso", produtoAtualizado.getId());
        return ResponseEntity.ok(ProdutoMapper.toDTO(produtoAtualizado));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizarParcial(@PathVariable Integer id,
                                                       @RequestBody ProdutoDTO dto) {
        log.info("Requisição PATCH /produtos/{} para atualização parcial", id);
        Produto produtoAtualizado = produtoService.atualizar(id, ProdutoMapper.toEntity(dto));
        log.debug("Produto atualizado parcialmente", produtoAtualizado.getId());
        return ResponseEntity.ok(ProdutoMapper.toDTO(produtoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Integer id) {
        log.info("Requisição DELETE /produtos/{}", id);
        produtoService.deletar(id);
        log.info("Produto criado com id {} deletado com sucesso", id);
        return ResponseEntity.noContent().build();
    }
}
