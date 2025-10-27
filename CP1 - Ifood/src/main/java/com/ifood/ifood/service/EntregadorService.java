package com.ifood.ifood.service;


import com.ifood.ifood.dto.EntregadorDTO;
import com.ifood.ifood.model.Entregador;
import com.ifood.ifood.repository.EntregadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EntregadorService {

    private final EntregadorRepository entregadorRepository;

    public EntregadorDTO criar(EntregadorDTO dto) {
        Entregador entregador = toEntity(dto);
        Entregador salvo = entregadorRepository.save(entregador);
        return toDTO(salvo);
    }
    public List<EntregadorDTO> listarTodos() {
        return entregadorRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    public EntregadorDTO consultarPorId(Long id) {
        Entregador entregador = entregadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entregador não encontrado"));
        return toDTO(entregador);
    }
    public EntregadorDTO atualizarPorId(Long id, EntregadorDTO dto) {
        Entregador entregador = entregadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entregador não encontrado"));

        entregador.setNome(dto.getNome());
        entregador.setTelefone(dto.getTelefone());
        entregador.setEmail(dto.getEmail());
        entregador.setStatusEntregador(dto.getStatusEntregador());
        entregador.setVeiculo(dto.getVeiculo());

        Entregador atualizado = entregadorRepository.save(entregador);
        return toDTO(atualizado);
    }
    public void deletarPorId(Long id) {
        Entregador entregador = entregadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entregador não encontrado"));
        entregadorRepository.delete(entregador);
    }
    private EntregadorDTO toDTO(Entregador entregador) {
        EntregadorDTO dto = new EntregadorDTO();
        dto.setId(entregador.getId());
        dto.setNome(entregador.getNome());
        dto.setTelefone(entregador.getTelefone());
        dto.setEmail(entregador.getEmail());
        dto.setStatusEntregador(entregador.getStatusEntregador());
        dto.setVeiculo(entregador.getVeiculo());
        return dto;
    }
    private Entregador toEntity(EntregadorDTO dto) {
        Entregador entregador = new Entregador();
        //entregador.setId(dto.getId());
        entregador.setNome(dto.getNome());
        entregador.setTelefone(dto.getTelefone());
        entregador.setEmail(dto.getEmail());
        entregador.setStatusEntregador(dto.getStatusEntregador());
        entregador.setVeiculo(dto.getVeiculo());
        return entregador;
    }
}
