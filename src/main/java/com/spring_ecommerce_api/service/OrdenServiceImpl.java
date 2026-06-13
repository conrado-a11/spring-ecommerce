package com.spring_ecommerce_api.service;


import com.spring_ecommerce_api.model.Orden;
import com.spring_ecommerce_api.repository.IOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenServiceImpl implements IOrdenService{
    @Autowired
    private IOrdenRepository ordenRepository;

    @Override
    public Orden save(Orden orden){
        return ordenRepository.save(orden);

    }


}
