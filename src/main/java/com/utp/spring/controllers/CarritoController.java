package com.utp.spring.controllers;

import com.utp.spring.models.entity.Carrito;
import com.utp.spring.services.ICarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carritos")
public class CarritoController {

    @Autowired
    private ICarritoService service;

    /*@PostMapping
    public ResponseEntity<Carrito> crear(@RequestBody Carrito carrito){
        Carrito o = service.crear(carrito);
        return new ResponseEntity<Carrito>(o, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Carrito>> listar(){
        List<Carrito> lista = service.listar();
        return new ResponseEntity<List<Carrito>>(lista,HttpStatus.OK);
    }*/

}
