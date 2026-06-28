package com.spring_ecommerce_api.service;


import com.spring_ecommerce_api.model.DetalleOrden;
import com.spring_ecommerce_api.repository.IDetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleOrdenServiceImpl implements IDetalleOrdenService {
    @Autowired
    private IDetalleOrdenRepository detalleOrdenRepository;
    @Override
    public DetalleOrden save(DetalleOrden detalleOrden){
        return detalleOrdenRepository.save(detalleOrden);
    }




}
