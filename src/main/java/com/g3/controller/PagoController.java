package com.g3.controller;

import com.g3.model.Pago;
import com.g3.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    PagoService pagoService;

    @GetMapping("/getByTarjeta/{tarjetaId}")
    public List<Pago> getByTarjeta(@PathVariable("tarjetaId") final Long tarjetaId) {
        return pagoService.getByTarjeta(tarjetaId);
    }

    @PutMapping("/pagar/{tarjetaId}")
    public Pago pay(@PathVariable("tarjetaId") final Long tarjetaId) {
        return null;
    }
}
