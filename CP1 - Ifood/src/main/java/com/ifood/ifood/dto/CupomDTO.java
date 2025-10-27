package com.ifood.ifood.dto;

import com.ifood.ifood.model.TipoDesconto;
import com.ifood.ifood.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class CupomDTO {
    private  Long id;
    @NotNull(message = "O valor não pode ser nulo")
    private BigDecimal valor;
    @NotBlank(message = "O codigo não pode estar vazio")
    private String codigo;
    @NotNull(message = "A validade é obrigatória")
    private LocalDate validade;
    @NotNull(message = "O tipo de desconto é obrigatório")
    private TipoDesconto desconto;
    private boolean ativo = true;
    private List<Usuario> clientes = new ArrayList<>();
}
