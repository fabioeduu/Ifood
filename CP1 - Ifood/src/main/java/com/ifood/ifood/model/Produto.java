package com.ifood.ifood.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;


@Entity
@Data
@Table(name = "tb_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq_generator")
    @SequenceGenerator(name = "produto_seq_generator", sequenceName = "produto_generator",allocationSize = 1)
    private Long id;
    @Column(nullable = false,length = 100)
    private String descricao;
    @Column(nullable = false,length = 100)
    private int quantidade;
    @Column(nullable = false,length = 30)
    private BigDecimal valor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurante_id")
    @JsonBackReference
    private Restaurante restaurante;
    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoriaProduto;

}
