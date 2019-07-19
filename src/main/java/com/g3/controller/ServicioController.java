package com.g3.controller;


import com.g3.model.Servicio;
import com.g3.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    ServicioService servicioService;

    @GetMapping("/getAll")
    public List<Servicio> getAll() {
        return servicioService.getAll();
    }
}
