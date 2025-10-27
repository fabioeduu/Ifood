package com.ifood.ifood.controller;

import com.ifood.ifood.dto.CupomDTO;
import com.ifood.ifood.service.CupomService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cupons")
@AllArgsConstructor
public class CupomController {

    private final CupomService cupomService;


    @PostMapping
    public ResponseEntity<CupomDTO> criar(@Valid @RequestBody CupomDTO dto) {
        CupomDTO salvo = cupomService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<CupomDTO>> listarTodos() {
        return ResponseEntity.ok(cupomService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CupomDTO> consultarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cupomService.consultarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CupomDTO> atualizar(@PathVariable Long id, @Valid @RequestBody CupomDTO dto) {
        return ResponseEntity.ok(cupomService.atualizarPorId(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cupomService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
