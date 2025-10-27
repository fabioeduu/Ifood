package com.ifood.ifood.controller;
import com.ifood.ifood.dto.PedidoDTO;
import com.ifood.ifood.service.PedidoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@AllArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoDTO> criar(@Valid @RequestBody PedidoDTO dto) {
        PedidoDTO salvo = pedidoService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listarTodos() {
        return ResponseEntity.ok(pedidoService.listarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> consultarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.consultarPorId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody PedidoDTO dto) {
        PedidoDTO atualizado = pedidoService.atualizarPorId(id, dto);
        return ResponseEntity.ok(atualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pedidoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
