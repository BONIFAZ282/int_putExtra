package com.utp.spring.models.dao;

import com.utp.spring.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUsuarioDAO extends JpaRepository<Usuario,Long> {

    @Query(value="FROM Usuario us WHERE us.correo=?1")
    Usuario buscarUsuarioPorCorreo(String correo);
}
