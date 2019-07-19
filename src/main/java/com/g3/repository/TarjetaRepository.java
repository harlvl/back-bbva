package com.g3.repository;

import com.g3.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {

    public List<Tarjeta> findByClienteId(Long clientId);
}
