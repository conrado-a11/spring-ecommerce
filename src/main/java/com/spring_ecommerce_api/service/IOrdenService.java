package com.spring_ecommerce_api.service;

import com.spring_ecommerce_api.model.Orden;
import com.spring_ecommerce_api.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IOrdenService {
    List<Orden> findAll();
    Optional<Orden> findyById(Integer id);
    Orden save(Orden orden);
    String generarNumeroOrden();
    List<Orden> findByUsuario(Usuario usuario);

}
