package com.api.telecomunicaiones.controller;

import org.springframework.web.bind.annotation.RestController;

import com.api.telecomunicaiones.modelo.Usuario;
import com.api.telecomunicaiones.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/telecomunicaciones/usuarios/")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("agregar-usuario")
    public ResponseEntity<Object> agregarUsuario(@RequestBody Usuario usuarioNuevo){
        return usuarioService.agregarUsuario(usuarioNuevo);
    }

}
