package com.ifood.ifood.controller;
import com.ifood.ifood.dto.EntregadorDTO;
import com.ifood.ifood.service.EntregadorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregadores")
@AllArgsConstructor
public class EntregadorController {
    private final EntregadorService entregadorService;

    @PostMapping
    public ResponseEntity<EntregadorDTO> criar(@Valid @RequestBody EntregadorDTO dto) {
        EntregadorDTO salvo = entregadorService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
    @GetMapping
    public ResponseEntity<List<EntregadorDTO>> listarTodos() {
        return ResponseEntity.ok(entregadorService.listarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<EntregadorDTO> consultarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(entregadorService.consultarPorId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EntregadorDTO> atualizar(@PathVariable Long id, @Valid @RequestBody EntregadorDTO dto) {
        EntregadorDTO atualizado = entregadorService.atualizarPorId(id, dto);
        return ResponseEntity.ok(atualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        entregadorService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
