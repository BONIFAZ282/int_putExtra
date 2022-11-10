package com.utp.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("")
    public String verIndex(){
        return "index";
    }

    @GetMapping("/inicio")
    public String verInicio(){
        return "inicio";
    }

}
