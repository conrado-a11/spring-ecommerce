package com.spring_ecommerce_api.controller;


import com.spring_ecommerce_api.model.Producto;
import com.spring_ecommerce_api.model.Usuario;
import com.spring_ecommerce_api.service.ProductoService;
import org.slf4j.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("administrador/productos")
public class ProductoController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String show(Model model){
        model.addAttribute("productos", productoService.findAll());
        return "administrador/productos/show";
    }
    @GetMapping("/create")
    public String create(){
        return "administrador/productos/create";
    }
    @PostMapping("/save")
    public String save(Producto producto){
        LOGGER.info("Este es el objeto Producto{}", producto);
        productoService.save(producto);
        Usuario u = new Usuario(1,"","","","","","", "");
        producto.setUsuario(u);
        productoService.save(producto);
            return "redirect:/administrador/productos";
    }



}
