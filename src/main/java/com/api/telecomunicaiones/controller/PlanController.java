package com.api.telecomunicaiones.controller;

import java.util.List;

import com.api.telecomunicaiones.modelo.Plan;
import com.api.telecomunicaiones.service.PlanServiceImpl;

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
@RequestMapping("/api/telecomunicaciones/planes/")
public class PlanController {

    @Autowired
    private PlanServiceImpl planService; 

    @GetMapping("obtener-planes")
    public ResponseEntity<Object> obtenerPlanes(){
        return planService.obtenerPlanes();
    }

    @PostMapping("agregar-plan")
    public ResponseEntity<Object> agregarPlan(@RequestBody Plan planNuevo){
        return planService.agregarPlan(planNuevo);
    }

    @PostMapping("agregar-planes")
    public ResponseEntity<Object> agregarPlanes(@RequestBody List<Plan> lstPlanes){
        return planService.agregarPlanes(lstPlanes);
    }

    @PutMapping("actualizar-plan")
    public ResponseEntity<Object> actualizarPlan (@RequestBody Plan planModificar){
            
        System.out.println("id: " + planModificar.getId());
        return planService.modificarPlan(planModificar);
    }

    @DeleteMapping("eliminar-plan")
    public ResponseEntity<Object> eliminarPlan(@RequestParam String id){
         return planService.eliminarPlan(id);
    }
}
