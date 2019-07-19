package com.g3.service;


import com.g3.model.Recibo;
import com.g3.repository.ReciboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReciboService {

    @Autowired
    ReciboRepository reciboRepository;

    public List<Recibo> getAll() {
        return reciboRepository.findAll();
    }

    public Recibo crearRecibo(Recibo recibo) {
        return reciboRepository.save(recibo);
    }
}
