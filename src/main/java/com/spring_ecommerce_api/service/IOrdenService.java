package com.spring_ecommerce_api.service;

import com.spring_ecommerce_api.model.Orden;

import java.util.List;

public interface IOrdenService {
    List<Orden> findAll();
    Orden save(Orden orden);
    String generarNumeroOrden();

}
