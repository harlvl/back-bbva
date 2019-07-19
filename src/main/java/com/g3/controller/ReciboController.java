package com.g3.controller;


import com.g3.model.Recibo;
import com.g3.service.ReciboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recibos")
public class ReciboController {

    @Autowired
    private ReciboService reciboService;

    @GetMapping("/getAll")
    public List<Recibo> getAll() {
        return reciboService.getAll();
    }

    @PostMapping("/create")
    public Recibo crearRecibo(@RequestBody Recibo recibo) {
        return reciboService.crearRecibo(recibo);
    }

    @GetMapping("/getByClient/{dni}/{ruc}")
    public List<Recibo> getRecibosPorCliente(@PathVariable("dni") String dni, @PathVariable("ruc") String ruc) {
        return reciboService.getRecibosPorCliente(dni, ruc);
    }
}
