package com.g3.service;


import com.g3.model.Servicio;
import com.g3.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {

    @Autowired
    ServicioRepository servicioRepository;

    public List<Servicio> getAll() {
        return servicioRepository.findAll();
    }

}
