package com.ifood.ifood.controller;


import com.ifood.ifood.dto.ProdutoDTO;
import com.ifood.ifood.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDTO> criar(@Valid @RequestBody ProdutoDTO dto) {
        ProdutoDTO salvo = produtoService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarTodos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> consultarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.consultarPorId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ProdutoDTO dto) {
        ProdutoDTO atualizado = produtoService.atualizarPorId(id, dto);
        return ResponseEntity.ok(atualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
