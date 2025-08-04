package com.danielmacedo.supermercado_api.mapper;

import com.danielmacedo.supermercado_api.dto.ProdutoDTO;
import com.danielmacedo.supermercado_api.infrastructure.entities.*;

public class ProdutoMapper {

    public static Produto toEntity(ProdutoDTO dto) {
        if (dto.getTipoProdutoClasse() == null) {
            throw new IllegalArgumentException("Tipo de produto não pode ser nulo");
        }

        switch(dto.getTipoProdutoClasse().toLowerCase()) {
            case "bebida":
                ProdutoBebida bebida = new ProdutoBebida();
                bebida.setId(dto.getId());
                bebida.setNome(dto.getNome());
                bebida.setPreco(dto.getPreco());
                bebida.setVolumeMl(dto.getVolumeMl());
                return bebida;

            case "alimenticio":
                ProdutoAlimenticio ali = new ProdutoAlimenticio();
                ali.setId(dto.getId());
                ali.setNome(dto.getNome());
                ali.setPreco(dto.getPreco());
                ali.setValidade(dto.getValidade());
                return ali;

            case "eletronico":
                ProdutoEletronico ele = new ProdutoEletronico();
                ele.setId(dto.getId());
                ele.setNome(dto.getNome());
                ele.setPreco(dto.getPreco());
                ele.setGarantiaMeses(dto.getGarantiaMeses());
                return ele;

            case "higiene":
                ProdutoHigiene hig = new ProdutoHigiene();
                hig.setId(dto.getId());
                hig.setNome(dto.getNome());
                hig.setPreco(dto.getPreco());
                hig.setIndicacao(dto.getIndicacao());
                return hig;

            case "limpeza":
                ProdutoLimpeza limp = new ProdutoLimpeza();
                limp.setId(dto.getId());
                limp.setNome(dto.getNome());
                limp.setPreco(dto.getPreco());
                limp.setTipoProduto(dto.getTipoProduto());
                return limp;

            default:
                throw new IllegalArgumentException("Tipo de produto desconhecido: " + dto.getTipoProdutoClasse());
        }
    }

    public static ProdutoDTO toDTO(Produto entity) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setPreco(entity.getPreco());

        if (entity instanceof ProdutoBebida) {
            dto.setTipoProdutoClasse("bebida");
            dto.setVolumeMl(((ProdutoBebida) entity).getVolumeMl());
        } else if (entity instanceof ProdutoAlimenticio) {
            dto.setTipoProdutoClasse("alimenticio");
            dto.setValidade(((ProdutoAlimenticio) entity).getValidade());
        } else if (entity instanceof ProdutoEletronico) {
            dto.setTipoProdutoClasse("eletronico");
            dto.setGarantiaMeses(((ProdutoEletronico) entity).getGarantiaMeses());
        } else if (entity instanceof ProdutoHigiene) {
            dto.setTipoProdutoClasse("higiene");
            dto.setIndicacao(((ProdutoHigiene) entity).getIndicacao());
        } else if (entity instanceof ProdutoLimpeza) {
            dto.setTipoProdutoClasse("limpeza");
            dto.setTipoProduto(((ProdutoLimpeza) entity).getTipoProduto());
        } else {
            dto.setTipoProdutoClasse("produto");
        }
        return dto;
    }
}
