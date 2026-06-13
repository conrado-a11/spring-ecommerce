package com.spring_ecommerce_api.repository;

import com.spring_ecommerce_api.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdenRepository  extends JpaRepository<Orden, Integer> {
}
