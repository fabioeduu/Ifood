package com.ifood.ifood.dto;

import com.ifood.ifood.model.Cupom;
import com.ifood.ifood.model.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UsuarioDTO {
    private long id;
    @NotBlank(message = "O nome não pode ser nulo")
    private String nome;
    @NotBlank(message = "O email não pode ser nulo")
    private String email;
    @NotBlank(message = "O telefone não pode ser nulo")
    private String  telefone;
    @NotBlank(message = "O endereço não pode ser nulo")
    private String endereco;
    @NotNull(message = "O tipo não pode ser nulo")
    private TipoUsuario tipoUsuario;
    private List<Cupom> cupons = new ArrayList<>();
}
