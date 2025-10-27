package com.ifood.ifood.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tb_cupom")
public class Cupom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "cupom_seq_generator")
    @SequenceGenerator(name = "cupom_seq_generator",sequenceName = "cupom_generator", allocationSize = 1)
    private  Long id;
    @Column(nullable = false)
    private BigDecimal valor;
    @Column(nullable = false, length = 10)
    private String codigo;
    @Column(nullable = false)
    private LocalDate validade;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDesconto desconto;
    @Column(nullable = false)
    private boolean ativo = true;
    @ManyToMany(mappedBy = "cupons", fetch = FetchType.EAGER)
    private List<Usuario> clientes = new ArrayList<>();
}
