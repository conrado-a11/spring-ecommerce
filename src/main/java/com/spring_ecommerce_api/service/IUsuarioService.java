package com.spring_ecommerce_api.service;

import com.spring_ecommerce_api.model.Usuario;

import java.util.Optional;


public interface IUsuarioService {
    Optional<Usuario> findById(Integer id);
}
