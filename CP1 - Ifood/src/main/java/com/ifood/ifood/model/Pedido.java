package com.ifood.ifood.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tb_pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pedido_seq_generator")
    @SequenceGenerator(name = "pedido_seq_generator",sequenceName = "pedido_generator",allocationSize=1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;
    @ManyToOne
    @JoinColumn(name = "entregador_id")
    private Entregador entregador;
    @ManyToOne
    private Restaurante restaurante;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPedido status;
    @ManyToMany
    @JoinTable(
            name = "tb_pedido_produto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos = new ArrayList<>();

}
