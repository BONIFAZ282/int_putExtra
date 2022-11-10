package com.utp.spring.models.entity;

import javax.persistence.*;

@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcarrito")
    private Long idcarrito;

    @ManyToOne
    @JoinColumn(name="idusuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="idproducto")
    private Producto producto;

    @Column(name="cantidad",nullable = false)
    private Integer cantidad;

    public Long getIdcarrito() {
        return idcarrito;
    }

    public void setIdcarrito(Long idcarrito) {
        this.idcarrito = idcarrito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
