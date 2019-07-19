package com.g3.service;


import com.g3.model.Pago;
import com.g3.model.Tarjeta;
import com.g3.repository.PagoRepository;
import com.g3.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {

    @Autowired
    PagoRepository pagoRepository;

    @Autowired
    TarjetaRepository tarjetaRepository;

    public List<Pago> getAll() {
        return pagoRepository.findAll();
    }

    public List<Pago> getByTarjeta(final Long tarjetaId) {
        return pagoRepository.findByTarjetaId(tarjetaId);
    }

//    public Pago pay(final Long tarjetaId) {
//        try{
//            Tarjeta tarjeta = tarjetaRepository.findById(tarjetaId).get();
//            try{
//
//            }
//        }catch(Exception e){
//            return null;
//        }
//    }
}
