package com.ifood.ifood.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_entregador")
public class Entregador {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "entregador_seq_generator")
    @SequenceGenerator(name = "entregador_seq_generator",sequenceName = "entregador_generator",allocationSize = 1)
    private Long id;
    @Column(nullable = false,length = 150)
    private String nome;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false, unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEntregador statusEntregador;
    @Column(nullable = false,length = 150)
    private String veiculo;
}
