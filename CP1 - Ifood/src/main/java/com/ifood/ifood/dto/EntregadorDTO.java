package com.ifood.ifood.dto;


import com.ifood.ifood.model.StatusEntregador;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EntregadorDTO {
    private Long id;
    @NotBlank(message = "O nome não pode ser nulo")
    private String nome;
    @NotBlank(message = "O telefone não pode ser nulo")
    private String telefone;
    @NotBlank(message = "O email não pode ser nulo")
    @Email(message = "Email inválido")
    private String email;
    @NotNull(message = " O status do entregador não pode ser nulo")
    private StatusEntregador statusEntregador;
    @NotBlank(message = "O veiculo não pode ser nulo")
    private String veiculo;

}
