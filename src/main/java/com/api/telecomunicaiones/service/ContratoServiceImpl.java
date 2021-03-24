package com.api.telecomunicaiones.service;

import java.util.List;

import com.api.telecomunicaiones.modelo.Contrato;
import com.api.telecomunicaiones.repository.IContraroDao;
import com.api.telecomunicaiones.response.RespuestaPersonalizada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ContratoServiceImpl {
    
    @Autowired
    IContraroDao contraroDao;

    //---------------------------------
    //METODOS GET
    //---------------------------------

    public ResponseEntity<Object> obtenerContratos(){
        ResponseEntity<Object> respuesta;
        try {
            List<Contrato> lstContratos = contraroDao.findAll();
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(lstContratos, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Problemas al cargar los contratos",HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    //---------------------------------
    //METODOS POST 
    //---------------------------------

    public ResponseEntity<Object> agregarContrato (Contrato contratoNuevo){
        ResponseEntity<Object> respuesta;
        try {
            contraroDao.save(contratoNuevo);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Contrato generado correctamente", HttpStatus.OK);
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al generar el plan ", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    public ResponseEntity<Object> agregarContratos (List<Contrato> lstContratosNuevos){
        ResponseEntity<Object> respuesta;
        try {
            for (Contrato contrato : lstContratosNuevos) {
                contraroDao.save(contrato);
            }
            RespuestaPersonalizada res = new RespuestaPersonalizada("Contratos generados correctamente", HttpStatus.OK);
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al generar los contratos", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    //---------------------------------
    //METODOS PUT
    //---------------------------------

    public ResponseEntity<Object> modificarContrato (Contrato contratoModificar){
        ResponseEntity<Object> respuesta;
        try {
            contraroDao.save(contratoModificar);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Contrato fue modificado correctamente", HttpStatus.OK);
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al modificar el contrato ", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    //---------------------------------
    //METODOS DETELE
    //---------------------------------

    public ResponseEntity<Object> eliminarContrato (Integer id){
        ResponseEntity<Object> respuesta;
        try {
            contraroDao.deleteById(id);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Contrato fue eliminado correctamente", HttpStatus.OK);
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al eliminar el Contrato ", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
