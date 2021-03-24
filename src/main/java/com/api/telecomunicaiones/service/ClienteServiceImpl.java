package com.api.telecomunicaiones.service;

import java.util.List;

import com.api.telecomunicaiones.modelo.Cliente;
import com.api.telecomunicaiones.repository.IClienteDao;
import com.api.telecomunicaiones.response.RespuestaPersonalizada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl {
    
    @Autowired
    IClienteDao clienteDao;

    //---------------------------------
    //METODOS GET
    //---------------------------------

    public ResponseEntity<Object> obtenerClientes(){
        ResponseEntity<Object> respuesta;
        try {
            List<Cliente> lstClientes = clienteDao.findAll();
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(lstClientes, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Problemas al cargar los clientes",HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    //---------------------------------
    //METODOS POST 
    //---------------------------------

    public ResponseEntity<Object> agregarCliente(Cliente clienteNuevo){
        ResponseEntity<Object> respuesta;
        try {
            clienteDao.save(clienteNuevo);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Cliente generado correctamente", HttpStatus.OK);
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al generar el cliente ", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    public ResponseEntity<Object> agregarClientes (List<Cliente> lstClientesNuevos){
        ResponseEntity<Object> respuesta;
        try {
            for (Cliente cliente : lstClientesNuevos) {
                clienteDao.save(cliente);
            }
            RespuestaPersonalizada res = new RespuestaPersonalizada("Clientes generados correctamente", HttpStatus.OK);
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al generar los clientes ", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    //---------------------------------
    //METODOS PUT
    //---------------------------------

    public ResponseEntity<Object> modificarCliente (Cliente clienteModificar){
        ResponseEntity<Object> respuesta;
        try {
            clienteDao.save(clienteModificar);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Cliente fue modificado correctamente", HttpStatus.OK);
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al modificar el cliente ", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    //---------------------------------
    //METODOS DETELE
    //---------------------------------

    public ResponseEntity<Object> eliminarCliente (Integer id){
        ResponseEntity<Object> respuesta;
        try {
            clienteDao.deleteById(id);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Cliente fue eliminado correctamente", HttpStatus.OK);
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al eliminar el cliente ", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
