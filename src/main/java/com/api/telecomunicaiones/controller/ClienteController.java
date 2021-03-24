package com.api.telecomunicaiones.controller;

import java.util.List;

import com.api.telecomunicaiones.modelo.Cliente;
import com.api.telecomunicaiones.service.ClienteServiceImpl;

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
@RequestMapping("/api/telecomunicaciones/clientes/")
public class ClienteController {
    
    @Autowired
    private ClienteServiceImpl clienteService; 

    @GetMapping("obtener-clientes")
    public ResponseEntity<Object> obtenerClientes(){
        return clienteService.obtenerClientes();
    }

    @PostMapping("agregar-cliente")
    public ResponseEntity<Object> agregarCliente(@RequestBody Cliente clienteNuevo){
        return clienteService.agregarCliente(clienteNuevo);
    }

    @PostMapping("agregar-clientes")
    public ResponseEntity<Object> agregarClientes(@RequestBody List<Cliente> lstClientes){
        return clienteService.agregarClientes(lstClientes);
    }

    @PutMapping("actualizar-cliente")
    public ResponseEntity<Object> actualizarCliente (@RequestBody Cliente clienteModificar){
        return clienteService.modificarCliente(clienteModificar);
    }

    @DeleteMapping("eliminar-cliente")
    public ResponseEntity<Object> eliminarCliente(@RequestParam Integer id){
         return clienteService.eliminarCliente(id);
    }

}
