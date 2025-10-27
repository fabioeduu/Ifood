package com.ifood.ifood.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name = "tb_restaurante")
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "resturante_seq_generator")
    @SequenceGenerator(name = "resturante_seq_generator",sequenceName = "resturante_generator",allocationSize = 1)
    private Long id;
    @Column(nullable = false,length = 150)
    private String nome;
    @Column(nullable = false,length = 150)
    private String descricao;
    @OneToMany(mappedBy = "restaurante",fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Produto> produtos = new ArrayList<>();
    @Column(nullable = false,length = 150)
    private String endereco;
    @Column(nullable = false,length = 150)
    private String telefone;
}
