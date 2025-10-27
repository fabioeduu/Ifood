package com.ifood.ifood.service;


import com.ifood.ifood.dto.ProdutoDTO;
import com.ifood.ifood.model.Produto;
import com.ifood.ifood.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoDTO criar(ProdutoDTO dto) {
        Produto produto = toEntity(dto);
        Produto salvo = produtoRepository.save(produto);
        return toDTO(salvo);
    }


    public void deletarPorId(Long id){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produtoRepository.delete(produto);
    }
    public ProdutoDTO consultarPorId(Long id){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Produto não encontrado"));
        return toDTO(produto);
    }
    public List<ProdutoDTO> listarTodos() {
        return produtoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    public ProdutoDTO atualizarPorId(Long id, ProdutoDTO dto) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setDescricao(dto.getDescricao());
        produto.setQuantidade(dto.getQuantidade());
        produto.setValor(dto.getValor());
        produto.setCategoriaProduto(dto.getCategoriaProduto());

        Produto atualizado = produtoRepository.save(produto);
        return toDTO(atualizado);
    }

    private ProdutoDTO toDTO(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setDescricao(produto.getDescricao());
        dto.setQuantidade(produto.getQuantidade());
        dto.setValor(produto.getValor());
        dto.setCategoriaProduto(produto.getCategoriaProduto());
        dto.setRestauranteId(produto.getRestaurante().getId());
        return dto;
    }
    private Produto toEntity(ProdutoDTO dto){
        Produto produto = new Produto();
        produto.setId(dto.getId());
        produto.setDescricao(dto.getDescricao());
        produto.setQuantidade(dto.getQuantidade());
        produto.setValor(dto.getValor());
        produto.setCategoriaProduto(dto.getCategoriaProduto());
        return produto;
    }
}
