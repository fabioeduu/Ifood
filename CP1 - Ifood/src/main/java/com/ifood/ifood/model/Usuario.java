package com.ifood.ifood.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "usuario_seq_gen")
    @SequenceGenerator(name = "usuario_seq_gen",sequenceName = "usuario_seq",allocationSize=1)
    private Long id;
    @Column(nullable = false,length = 150)
    private String nome;
    @Column(nullable = false,length = 150)
    private String email;
    @Column(nullable = false,length = 150)
    private String  telefone;
    @Column(nullable = false,length = 150)
    private String endereco;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_usuario_cupom",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "cupom_id")
    )
    private List<Cupom> cupons = new ArrayList<>();
}
