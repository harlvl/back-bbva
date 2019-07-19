package com.g3.service;


import com.g3.model.Recibo;
import com.g3.repository.ReciboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Recibo> getRecibosPorCliente(String dni, String codigo_empresa) {
        List<Recibo> recibos = reciboRepository.findAll();
        List<Recibo> result = new ArrayList<>();
        for (Recibo r : recibos) {
            String r_dni = r.getDni();
            String r_ruc = r.getCodigo_empresa();

            if (r_dni.equals(dni) && r_ruc.equals(codigo_empresa)) {
                result.add(r);
            }
        }
        return result;
    }

    public List<Recibo> getAllByClient(String dni) {
        List<Recibo> recibos = reciboRepository.findAll();
        List<Recibo> result = new ArrayList<>();
        for (Recibo r : recibos) {
            String r_dni = r.getDni();

            if (r_dni.equals(dni)) {
                result.add(r);
            }
        }
        return result;
    }
}
