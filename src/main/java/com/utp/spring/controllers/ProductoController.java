package com.utp.spring.controllers;

import com.utp.spring.models.dao.IProductoDAO;
import com.utp.spring.models.entity.Categoria;
import com.utp.spring.models.entity.Producto;
import com.utp.spring.services.ICategoriaService;
import com.utp.spring.services.IProductoService;
import com.utp.spring.services.ProductoServiceImpl;
import com.utp.spring.services.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductoController {


    @Autowired
    private IProductoService productoService;

    @Autowired
    private IProductoDAO IProductoDAO;

    @Autowired
    private ICategoriaService categoriaService;
    @Autowired
    private ProductoServiceImpl productoServiceimpl;

    @Autowired
    private UploadFileService upload;

    @GetMapping("/productos")
    public String VerProductos(){
        return "productos";
    }




    @GetMapping("/listaproductos")
    public String listarProductos(Model modelo){
        List<Producto> listaProductos = productoServiceimpl.findAll();
        modelo.addAttribute("listaProductos", listaProductos);
        return "table_producto";
    }


    @GetMapping("/bizcochos")
    public String filtrarBizcocho(Model modelo){
            String palabraClave = ("1");
            List<Producto> listaProductos = productoServiceimpl.listAll(palabraClave);
            modelo.addAttribute("listaProductos", listaProductos);
            return "categoria/bizcochos";
    }

    @GetMapping("/galletas")
    public String filtrarGalleta(Model modelo){
        String palabraClave = ("2");
        List<Producto> listaProductos = productoServiceimpl.listAll(palabraClave);
        modelo.addAttribute("listaProductos", listaProductos);
        return "categoria/galletas";
    }

    @GetMapping("/pasteles")
    public String filtrarPastel(Model modelo){
        String palabraClave = ( "3");
        List<Producto> listaProductos = productoServiceimpl.listAll(palabraClave);
        modelo.addAttribute("listaProductos", listaProductos);
        return "categoria/pasteles";
    }

    @GetMapping("/dulces")
    public String filtrarDulce(Model modelo){
        String palabraClave = ( "4");
        List<Producto> listaProductos = productoServiceimpl.listAll(palabraClave);
        modelo.addAttribute("listaProductos", listaProductos);
        return "categoria/dulces";
    }

    @GetMapping("/productohome/{id}")
    public String productoHome(@PathVariable Long id,Model modelo){
        Producto producto = new Producto();
        Optional<Producto> productoOptional= productoService.get(id);
        producto = productoOptional.get();
        modelo.addAttribute("producto",producto);

        return "producto_crear";
    }

    @GetMapping("productos/nuevo")
    public String mostrarFormularioDeNuevoProducto(Model modelo){
        List<Categoria>listaCategorias = categoriaService.findAll();

        modelo.addAttribute("producto",new Producto());
        modelo.addAttribute("listaCategorias",listaCategorias);

        return "producto_agregar";
    }

    @PostMapping("/productos/guardar")
    public String guardarProducto(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
        //image
        if(producto.getIdproducto()==null){
            String nombreImagen=upload.saveImage(file);
            producto.setImagen(nombreImagen);
        }
        else {
        }
        productoService.save(producto);
        return "redirect:/listaproductos";
    }

    @GetMapping("/productos/editar/{id}")
    public String edit(@PathVariable Long id,Model modelo){
        Producto producto = new Producto();
        Optional<Producto> optionalProducto=productoService.get(id);
        producto=optionalProducto.get();
        modelo.addAttribute("producto",producto);

        List<Categoria>listaCategorias = categoriaService.findAll();
        modelo.addAttribute("listaCategorias",listaCategorias);
        return "producto_formulario";
    }

    @PostMapping("/productos/update")
    public String update(Producto producto,@RequestParam("img") MultipartFile file) throws IOException {
        Producto p=new Producto();
        p=productoService.get(producto.getIdproducto()).get();
        if (file.isEmpty()){

            producto.setImagen(p.getImagen());
        }else {//cuando se edita tbn la imagen
            //eliminar cuando no sea imagen por defecto
            if(!p.getImagen().equals("default.jpg")){
                upload.deleteImage(p.getImagen());
            }

            String nombreImagen = upload.saveImage(file);
            producto.setImagen(nombreImagen);
        }
        productoService.update(producto);
        return "redirect:/listaproductos";
    }

    @GetMapping("productos/eliminar/{id}")
    public String delete(@PathVariable Long id){

        Producto p =new Producto();
        p=productoService.get(id).get();

        //eliminar cuando no sea imagen por defecto
        if(!p.getImagen().equals("default.jpg")){
            upload.deleteImage(p.getImagen());
        }

        productoService.delete(id);
        return "redirect:/listaproductos";
    }

}
