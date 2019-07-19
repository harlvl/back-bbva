package com.g3.repository;

import com.g3.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long> {

    public List<Pago> findByTarjetaId(Long tarjetaId);
}
