package com.g3.service;

import com.g3.model.Proveedor;
import com.g3.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    public List<Proveedor> getAll() {
        return proveedorRepository.findAll();
    }

    public List<Proveedor> getByService(final Long servicioId) {
        return proveedorRepository.findByServicioId(servicioId);
    }
}
