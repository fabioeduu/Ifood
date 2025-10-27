package com.ifood.ifood.service;

import com.ifood.ifood.dto.PedidoDTO;
import com.ifood.ifood.model.Pedido;
import com.ifood.ifood.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoDTO criar(PedidoDTO dto) {
        Pedido pedido = toEntity(dto);
        Pedido salvo = pedidoRepository.save(pedido);
        return toDTO(salvo);
    }
    public List<PedidoDTO> listarTodos() {
        return pedidoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    public PedidoDTO consultarPorId(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        return toDTO(pedido);
    }

    public void deletarPorId(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedidoRepository.delete(pedido);
    }
    public PedidoDTO atualizarPorId(Long id, PedidoDTO dto) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        pedido.setCliente(dto.getCliente());
        pedido.setEntregador(dto.getEntregador());
        pedido.setRestaurante(dto.getRestaurante());
        pedido.setStatus(dto.getStatus());
        pedido.setProdutos(dto.getProdutos());

        Pedido atualizado = pedidoRepository.save(pedido);
        return toDTO(atualizado);
    }
    private PedidoDTO toDTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        dto.setCliente(pedido.getCliente());
        dto.setEntregador(pedido.getEntregador());
        dto.setRestaurante(pedido.getRestaurante());
        dto.setStatus(pedido.getStatus());
        dto.setProdutos(pedido.getProdutos());
        return dto;
    }
    private Pedido toEntity(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        //pedido.setId(dto.getId());
        pedido.setCliente(dto.getCliente());
        pedido.setEntregador(dto.getEntregador());
        pedido.setRestaurante(dto.getRestaurante());
        pedido.setStatus(dto.getStatus());
        pedido.setProdutos(dto.getProdutos());
        return pedido;
    }

}
