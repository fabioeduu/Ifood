package com.ifood.ifood.service;


import com.ifood.ifood.dto.CupomDTO;
import com.ifood.ifood.model.Cupom;
import com.ifood.ifood.repository.CupomRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class CupomService {

    private final CupomRepository cupomRepository;

    public CupomDTO criar(CupomDTO dto) {
        Cupom cupom = toEntity(dto);
        Cupom salvo = cupomRepository.save(cupom);
        return toDTO(salvo);
    }
    public List<CupomDTO> listarTodos() {
        return cupomRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public CupomDTO consultarPorId(Long id) {
        Cupom cupom = cupomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cupom não encontrado"));
        return toDTO(cupom);
    }
    public CupomDTO atualizarPorId(Long id, CupomDTO dto) {
        Cupom cupom = cupomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cupom não encontrado"));

        cupom.setValor(dto.getValor());
        cupom.setCodigo(dto.getCodigo());
        cupom.setValidade(dto.getValidade());
        cupom.setDesconto(dto.getDesconto());
        cupom.setAtivo(dto.isAtivo());
        cupom.setClientes(dto.getClientes());

        Cupom atualizado = cupomRepository.save(cupom);
        return toDTO(atualizado);
    }
    public void deletarPorId(Long id) {
        Cupom cupom = cupomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cupom não encontrado"));
        cupomRepository.delete(cupom);
    }
    private CupomDTO toDTO(Cupom cupom) {
        CupomDTO dto = new CupomDTO();
        dto.setId(cupom.getId());
        dto.setValor(cupom.getValor());
        dto.setCodigo(cupom.getCodigo());
        dto.setValidade(cupom.getValidade());
        dto.setDesconto(cupom.getDesconto());
        dto.setAtivo(cupom.isAtivo());
        dto.setClientes(cupom.getClientes());
        return dto;
    }
    private Cupom toEntity(CupomDTO dto) {
        Cupom cupom = new Cupom();
        //cupom.setId(dto.getId());
        cupom.setValor(dto.getValor());
        cupom.setCodigo(dto.getCodigo());
        cupom.setValidade(dto.getValidade());
        cupom.setDesconto(dto.getDesconto());
        cupom.setAtivo(dto.isAtivo());
        cupom.setClientes(dto.getClientes());
        return cupom;
    }


}
