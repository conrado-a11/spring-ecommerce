package com.spring_ecommerce_api.controller;


import com.spring_ecommerce_api.model.Producto;
import com.spring_ecommerce_api.model.Usuario;
import com.spring_ecommerce_api.service.ProductoService;
import com.spring_ecommerce_api.service.UploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;


@Controller
@RequestMapping("/administrador/productos")
public class ProductoController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
    @Autowired
    private ProductoService productoService;

    @Autowired
    private UploadFileService upload;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "administrador/productos/show";
    }

    @GetMapping("/create")
    public String create() {
        return "administrador/productos/create";
    }

    @PostMapping("/save")
    public String save(Producto producto, @RequestParam("img")MultipartFile file) throws IOException {
        LOGGER.info("Este es el objeto Producto{}", producto);
        productoService.save(producto);
        Usuario u = new Usuario(1, "", "", "", "", "", "", "");
       // producto.setUsuario(u);
        //imagen
       // if (producto.getId()==null){ // cuando se crea el producto
               // String nombreImagen= upload.saveImage(file);
               // producto.setImagen(nombreImagen);
       // }else {


       // }


        productoService.save(producto);
        return "redirect:/administrador/productos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Producto producto = new Producto();
        Optional<Producto> optionalProducto = productoService.get(id);
        producto = optionalProducto.get();


        LOGGER.info("Producto Buscado: {}", producto);
        model.addAttribute("producto", producto);
        return "administrador/productos/edit";

    }

    @PostMapping("/update")
    public String update(Producto producto, @RequestParam("img")MultipartFile file) throws IOException {

        Producto p = new Producto();
        p=productoService.get(producto.getId()).get();

        if (file.isEmpty()){   //editamos el producto pero no cambiamos la imagen

            producto.setImagen(p.getImagen());
        }else {// cuando se edita también la imagen


            //Eliminar cuando no sea la imagen por defecto
            if (!p.getImagen().equals("default.jpg")){
                upload.deleteImage(p.getImagen());

            }

            String nombreImagen = upload.saveImage(file);
            producto.setImagen(nombreImagen);
        }
        producto.setUsuario(p.getUsuario());
        productoService.update(producto);
        return "redirect:/administrador/productos";
    }
    @GetMapping("/delete/{id}")
    public String delete (@PathVariable Integer id){

        Producto p = new Producto();
        p=productoService.get(id).get();

        //Eliminar la imagen solo si existe y no es la imagen por defecto
        if (p.getImagen() !=null && !p.getImagen().isEmpty() && p.getImagen().equals("default.jpg")){
            upload.deleteImage(p.getImagen());

        }


        productoService.delete(id);
        return "redirect:/administrador/productos";
    }




}
