package com.g3.controller;


import com.g3.model.Proveedor;
import com.g3.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;

    @GetMapping("/getAll")
    public List<Proveedor> getAll() {
        return proveedorService.getAll();
    }

    @GetMapping("/getByService/{idService}")
    public List<Proveedor> getByService(@PathVariable("idService") final Long idService) {
        return proveedorService.getByService(idService);
    }
}
