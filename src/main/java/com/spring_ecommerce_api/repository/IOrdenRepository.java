package com.spring_ecommerce_api.repository;

import com.spring_ecommerce_api.model.Orden;
import com.spring_ecommerce_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrdenRepository  extends JpaRepository<Orden, Integer> {


    List<Orden> findByUsuario(Usuario usuario);




}
