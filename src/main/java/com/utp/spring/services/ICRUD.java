package com.utp.spring.services;

import java.util.List;

public interface ICRUD <T>{
    List<T> listar();
    T crear(T t);
    T modificar(T t);
    T leerPorId(Long id);
    void eliminarPorId(Long id);
}
