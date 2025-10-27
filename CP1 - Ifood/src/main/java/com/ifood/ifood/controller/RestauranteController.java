package com.ifood.ifood.controller;


import com.ifood.ifood.dto.RestauranteDTO;
import com.ifood.ifood.service.RestauranteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
@AllArgsConstructor
public class RestauranteController {
    private final RestauranteService restauranteService;

    @PostMapping
    public ResponseEntity<RestauranteDTO> criar(@Valid @RequestBody RestauranteDTO dto) {
        RestauranteDTO salvo = restauranteService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<RestauranteDTO>> listarTodos() {
        return ResponseEntity.ok(restauranteService.listarTodos());
    }


    @GetMapping("/{id}")
    public ResponseEntity<RestauranteDTO> consultarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(restauranteService.consultarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestauranteDTO> atualizar(@PathVariable Long id, @Valid @RequestBody RestauranteDTO dto) {
        RestauranteDTO atualizado = restauranteService.atualizarPorId(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        restauranteService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }



}
