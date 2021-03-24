package com.api.telecomunicaiones.controller;

import java.util.List;

import com.api.telecomunicaiones.modelo.Contrato;
import com.api.telecomunicaiones.service.ContratoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/telecomunicaciones/contratos/")
public class ContratoController {
    
    @Autowired
    private ContratoServiceImpl contratoService; 

    @GetMapping("obtener-contratos")
    public ResponseEntity<Object> obtenerContratos(){
        return contratoService.obtenerContratos();
    }

    @PostMapping("agregar-contrato")
    public ResponseEntity<Object> agregarPlan(@RequestBody Contrato contratoNuevo){
        return contratoService.agregarContrato(contratoNuevo);
    }

    @PostMapping("agregar-contratos")
    public ResponseEntity<Object> agregarPlanes(@RequestBody List<Contrato> lstContratos){
        return contratoService.agregarContratos(lstContratos);
    }

    @PutMapping("actualizar-contrato")
    public ResponseEntity<Object> actualizarPlan (@RequestBody Contrato contratoModificar){
        return contratoService.modificarContrato(contratoModificar);
    }

    @DeleteMapping("eliminar-contrato")
    public ResponseEntity<Object> eliminarPlan(@RequestParam Integer id){
         return contratoService.eliminarContrato(id);
    }
}
