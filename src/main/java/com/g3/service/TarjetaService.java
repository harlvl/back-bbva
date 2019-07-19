package com.g3.service;


import com.g3.model.Pago;
import com.g3.model.Recibo;
import com.g3.model.Tarjeta;
import com.g3.repository.PagoRepository;
import com.g3.repository.ReciboRepository;
import com.g3.repository.TarjetaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarjetaService {

    @Autowired
    TarjetaRepository tarjetaRepository;

    @Autowired
    ReciboRepository reciboRepository;

    @Autowired
    PagoRepository pagoRepository;

    Logger log = LoggerFactory.getLogger(this.getClass());

    public Recibo pagar(final Long tarjetaId, Long id_pago, Integer nro_suministro) {
        try {
            Tarjeta tarjeta = tarjetaRepository.findById(tarjetaId).get();
            log.info("Found tarjeta");
            Double result;
            try {
                Pago pago = pagoRepository.findById(id_pago).get();
                Double montoAPagar = pago.getMonto();
                Double saldoActual = tarjeta.getSaldo();
                result = saldoActual - montoAPagar;
                log.info("Found pago");
            } catch (Exception e5) {
                log.error("No se pudo encontrar el pago");
                log.error(e5.getMessage());
                return null;
            }


            if (result != null && result >= 0) {
                log.info("Se cuenta con saldo suficiente");
                log.info("Valor de result: " + result);
                try{
                    tarjeta.setSaldo(result); // update
                    tarjetaRepository.save(tarjeta);
                    log.info("Saved tarjeta");
                }catch (Exception e2){
                    log.error("No se pudo realizar el pago");
                    log.error(e2.getMessage());
                    return null;
                }
                // actualizar el recibo
                List<Recibo> recibos = reciboRepository.findAll();
                Recibo recibo_updated = new Recibo();
                recibo_updated.setEstado(0);
                log.info("Buscando numero: " + nro_suministro);
                for (Recibo r : recibos) {
                    log.info("Testing recibo: " + r.getNro_suministro());
                    if (nro_suministro.intValue() == r.getNro_suministro().intValue()) {
                        recibo_updated = r;
                        log.info("Found numero de suministro");
                        recibo_updated.setId(r.getId());
                        recibo_updated .setEstado(1);
                        log.info("updated recibo");
                        try {
                            recibo_updated = reciboRepository.save(recibo_updated);
                            log.info("Pagado");
                            break;
                        } catch (Exception e3) {
                            log.error("No se pudo guardar el recibo");
                            log.error(e3.getMessage());
                            return null;
                        }
                    }
                }
                if (recibo_updated.getEstado() == 1) {
                    log.info("Se cambio el estado a 1");
                    return recibo_updated;
                }else{
                    log.info("El estado no se cambio");
                    return null;
                }
            }else{
                log.error("No se cuenta con saldo suficiente");
                return null;
            }
        } catch (Exception e) {
            log.error("No se pudo encontrar la tarjeta");
            log.error(e.getMessage());
            return null;
        }
    }
}
