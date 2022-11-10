package com.utp.spring.controllers;

import com.utp.spring.models.entity.Cliente;
import com.utp.spring.models.entity.Usuario;
import com.utp.spring.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/registro")
    public String crear(){
        return "registro_usuario";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(Usuario usuario){
        usuario.setRol("USER");
        usuarioService.save(usuario);

    return "redirect:/";
    }

    /*@PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody Usuario t){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1,t.getPassword());
        t.setPassword(hash);
        Usuario o = usuarioService.save(t);
        return new ResponseEntity<Usuario>(o, HttpStatus.OK);
    }

    /*@GetMapping("/buscar/{correo}")
    public ResponseEntity<Usuario> buscarUsuarioPorCorreo(@PathVariable("correo") String correo){

        Usuario o = usuarioService.buscarUsuarioPorCorreo(correo);
        if(o==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Usuario>(o,HttpStatus.OK);
    }*/

}
