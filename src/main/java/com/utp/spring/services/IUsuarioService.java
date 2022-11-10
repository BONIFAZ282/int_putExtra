package com.utp.spring.services;

import com.utp.spring.models.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    Optional<Usuario> findbyId(Long id);
    public List<Usuario> findAll();
    public Usuario save(Usuario usuario);
    public void delete(Usuario usuario);

    Usuario buscarUsuarioPorCorreo(String correo);
}
