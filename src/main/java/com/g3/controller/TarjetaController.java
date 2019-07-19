package com.g3.controller;


import com.g3.model.Pago;
import com.g3.model.Recibo;
import com.g3.model.Tarjeta;
import com.g3.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarjetas")
public class TarjetaController {

    @Autowired
    TarjetaService tarjetaService;

    @PutMapping("/pagar/{tarjetaId}/{nro_suministro}/{id_pago}")
    public Recibo pagarTarjeta(@PathVariable("id_pago") final Long id_pago, @PathVariable("tarjetaId") final Long tarjetaId, @PathVariable("nro_suministro") final Integer nro_suministro) {
        return tarjetaService.pagar(tarjetaId, id_pago, nro_suministro);
    }

    @GetMapping("/getByClient/{idClient}")
    public List<Tarjeta> getByClient(@PathVariable("idClient") Long idClient) {
        return tarjetaService.getByClient(idClient);
    }
}
