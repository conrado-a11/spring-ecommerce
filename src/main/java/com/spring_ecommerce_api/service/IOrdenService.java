package com.spring_ecommerce_api.service;

import com.spring_ecommerce_api.model.Orden;
import com.spring_ecommerce_api.model.Usuario;

import java.util.List;

public interface IOrdenService {
    List<Orden> findAll();
    Orden save(Orden orden);
    String generarNumeroOrden();
    List<Orden> findByUsuario(Usuario usuario);

}
