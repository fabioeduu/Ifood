package com.ifood.ifood.dto;


import com.ifood.ifood.model.Produto;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RestauranteDTO {
    private long id;
    @NotBlank(message = "O nome não pode ser nulo")
    private String nome;
    @NotBlank(message = "A descrição não pode ser nulo")
    private String descricao;
    @NotEmpty(message = "O restaurante tem que ter pelo menos um produto")
    private List<Produto> produtos = new ArrayList<>();
    @NotBlank(message = "O endereço não pode ser nulo")
    private String endereco;
    @NotBlank(message = "O telefone não pode ser nulo")
    private String telefone;
}
