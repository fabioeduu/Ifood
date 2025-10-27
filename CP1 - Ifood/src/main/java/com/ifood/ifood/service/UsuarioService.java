package com.ifood.ifood.service;

import com.ifood.ifood.dto.UsuarioDTO;
import com.ifood.ifood.model.Usuario;
import com.ifood.ifood.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioDTO criar(UsuarioDTO dto){
        Usuario usuario = toEntity(dto);
        Usuario salvo = usuarioRepository.save(usuario);
        return toDTO(salvo);
    }

    public List<UsuarioDTO>listarTodos(){
        return usuarioRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());


    }
    public UsuarioDTO consultarPorId(long id){
       Usuario usuario = usuarioRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
       return toDTO(usuario);
    }
    public void deletarPorId(long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Usuario não encontrado"));
        usuarioRepository.delete(usuario);
    }
    public UsuarioDTO atualizarPorId(long id,UsuarioDTO dto){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()->new RuntimeException("usuario não encontrado"));
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setTelefone(dto.getTelefone());
        usuario.setEndereco(dto.getEndereco());
        usuario.setTipoUsuario(dto.getTipoUsuario());
        usuario.setCupons(dto.getCupons());

        Usuario atualizado = usuarioRepository.save(usuario);
        return toDTO(atualizado);

    }
    private UsuarioDTO toDTO(Usuario usuario){
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setTelefone(usuario.getTelefone());
        dto.setEndereco(usuario.getEndereco());
        dto.setTipoUsuario(usuario.getTipoUsuario());
        dto.setCupons(usuario.getCupons());
        return dto;
    }
    private Usuario toEntity(UsuarioDTO dto){
        Usuario usuario = new Usuario();
        //usuario.setId(dto.getId());
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setTelefone(dto.getTelefone());
        usuario.setEndereco(dto.getEndereco());
        usuario.setTipoUsuario(dto.getTipoUsuario());
        usuario.setCupons(dto.getCupons());
        return usuario;
    }
}
