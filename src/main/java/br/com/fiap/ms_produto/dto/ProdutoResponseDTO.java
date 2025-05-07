package br.com.fiap.ms_produto.dto;

import br.com.fiap.ms_produto.entities.Produto;

import java.util.Set;
import java.util.stream.Collectors;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        String descricao,
        Double valor,
        CategoriaDTO categoria,
        Set<LojaDTO> lojas
) {

    public ProdutoResponseDTO(Produto entity) {
        this(entity.getId(),
                entity.getNome(),
                entity.getDescricao(),
                entity.getValor(),
                new CategoriaDTO((entity.getCategoria())),
                entity.getLojas().stream().map(LojaDTO::new).collect(Collectors.toSet())
        );
    }
}
