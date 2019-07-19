package com.g3.repository;

import com.g3.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  ProveedorRepository extends JpaRepository<Proveedor, Long> {

    public List<Proveedor> findByServicioId(Long servicioId);
}
