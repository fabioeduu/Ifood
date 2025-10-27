package com.ifood.ifood.service;


import com.ifood.ifood.dto.RestauranteDTO;
import com.ifood.ifood.model.Restaurante;
import com.ifood.ifood.repository.RestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RestauranteService {

    private final RestauranteRepository restauranteRepository;

    public RestauranteDTO criar(RestauranteDTO restauranteDTO) {
        Restaurante restaurante = toEntity(restauranteDTO);
        Restaurante salvo = restauranteRepository.save(restaurante);
        return toDTO(salvo);
    }

    public RestauranteDTO consultarPorId(Long id){
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));
        return toDTO(restaurante);
    }
    public List<RestauranteDTO> listarTodos(){
        return restauranteRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    public void deletarPorId(Long id){
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));
        restauranteRepository.delete(restaurante);
    }
    public RestauranteDTO atualizarPorId(Long id, RestauranteDTO restauranteDTO){
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Restaurante nao encontrado"));
        restaurante.setNome(restauranteDTO.getNome());
        restaurante.setDescricao(restauranteDTO.getDescricao());
        restaurante.setEndereco(restauranteDTO.getEndereco());
        restaurante.setTelefone(restauranteDTO.getTelefone());
        restaurante.setProdutos(restauranteDTO.getProdutos());
        Restaurante atualizado = restauranteRepository.save(restaurante);
        return toDTO(atualizado);
    }
    public RestauranteDTO toDTO(Restaurante restaurante){
        RestauranteDTO dto = new RestauranteDTO();
        dto.setId(restaurante.getId());
        dto.setNome(restaurante.getNome());
        dto.setDescricao(restaurante.getDescricao());
        dto.setEndereco(restaurante.getEndereco());
        dto.setTelefone(restaurante.getTelefone());
        dto.setProdutos(restaurante.getProdutos());
        return dto;
    }
    public Restaurante toEntity(RestauranteDTO dto){
        Restaurante restaurante = new Restaurante();
        restaurante.setNome(dto.getNome());
        restaurante.setDescricao(dto.getDescricao());
        restaurante.setEndereco(dto.getEndereco());
        restaurante.setTelefone(dto.getTelefone());
        restaurante.setProdutos(dto.getProdutos());
        return restaurante;
    }


}
