package com.utp.spring.models.dao;

import com.utp.spring.models.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaDAO extends JpaRepository<Categoria,Long>{
}
