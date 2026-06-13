package com.spring_ecommerce_api.service;


import com.spring_ecommerce_api.model.Usuario;
import com.spring_ecommerce_api.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UsuarioServiceImpl implements IUsuarioService {
        @Autowired
        private IUsuarioRepository usuarioRepository;


    @Override
    public Optional<Usuario> findById(Integer id) {


        return usuarioRepository.findById(id);
    }
}
