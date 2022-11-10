package com.utp.spring.models.dao;

import com.utp.spring.models.entity.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarritoDAO extends JpaRepository<Carrito,Long> {
}
