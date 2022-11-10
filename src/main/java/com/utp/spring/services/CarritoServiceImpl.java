package com.utp.spring.services;

import com.utp.spring.models.dao.ICarritoDAO;
import com.utp.spring.models.entity.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoServiceImpl implements ICarritoService{
    @Autowired
    private ICarritoDAO dao;

    @Override
    public List<Carrito> listar() {
        return dao.findAll();
    }

    @Override
    public Carrito crear(Carrito carrito) {
        return dao.save(carrito);
    }

    @Override
    public Carrito modificar(Carrito carrito) {
        return dao.save(carrito);
    }

    @Override
    public Carrito leerPorId(Long id) {
        Optional<Carrito> oCarrito =  dao.findById(id);
        return oCarrito.isPresent()?oCarrito.get(): null;
    }

    @Override
    public void eliminarPorId(Long id) {
        Carrito obj = new Carrito();
        obj.setIdcarrito(id);
        dao.delete(obj);
    }
}
