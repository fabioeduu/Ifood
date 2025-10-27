package com.ifood.ifood.dto;

import com.ifood.ifood.model.CategoriaProduto;
import com.ifood.ifood.model.Restaurante;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class ProdutoDTO {
    private Long id;
    @NotBlank(message = "A descrição não pode ser nulo")
    private String descricao;
    @NotNull(message = "A quantidade não pode ser nulo")
    private int quantidade;
    @NotNull(message = "O valor não pode ser nulo")
    @Positive(message = "O valor deve ser positivo")
    private BigDecimal valor;
    @NotNull(message = "O restaurante não pode ser nulo" )
    private Long restauranteId;
    @NotNull(message = "A categoria do produto não pode ser nulo")
    private CategoriaProduto categoriaProduto;
}
