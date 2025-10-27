package com.ifood.ifood.dto;

import com.ifood.ifood.model.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class PedidoDTO {
    private Long id;

    @NotNull(message = "Cliente não pode ser nulo")
    private Usuario cliente;
    @NotNull(message = "Entregador não pode ser nulo")
    private Entregador entregador;
    @NotNull(message = "Restaurante não pode ser nulo")
    private Restaurante restaurante;
    @NotNull(message = "O status do pedido não pode ser nulo")
    private StatusPedido status;
    @NotEmpty(message = "O pedido deve ter pelo menos um produto")
    private List<Produto> produtos = new ArrayList<>();
}
