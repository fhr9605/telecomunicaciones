package com.api.telecomunicaiones.service;

import java.util.List;

import com.api.telecomunicaiones.modelo.Plan;
import com.api.telecomunicaiones.repository.IPlanDao;
import com.api.telecomunicaiones.response.RespuestaPersonalizada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl {
    
    @Autowired
    private IPlanDao planDao;

    //---------------------------------
    //METODOS GET
    //---------------------------------

    public ResponseEntity<Object> obtenerPlanes(){
        ResponseEntity<Object> respuesta;
        try {
            List<Plan> lstPlanes = planDao.findAll();
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(lstPlanes, HttpStatus.OK);
        } catch (Exception e) {
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Problemas al cargar los planes",HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    //---------------------------------
    //METODOS POST 
    //---------------------------------

    public ResponseEntity<Object> agregarPlan (Plan planNuevo){
        ResponseEntity<Object> respuesta;
        try {
            planDao.save(planNuevo);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Plan generado correctamente", HttpStatus.OK);
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al generar el plan ", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    public ResponseEntity<Object> agregarPlanes (List<Plan> lstPlanesNuevos){
        ResponseEntity<Object> respuesta;
        try {
            for (Plan plan : lstPlanesNuevos) {
                planDao.save(plan);
            }
            RespuestaPersonalizada res = new RespuestaPersonalizada("Planes generados correctamente", HttpStatus.OK);
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al generar los planes", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    //---------------------------------
    //METODOS PUT
    //---------------------------------

    public ResponseEntity<Object> modificarPlan (Plan planModificar){
        ResponseEntity<Object> respuesta;
        try {
            planDao.save(planModificar);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Plan fue modificado correctamente", HttpStatus.OK);
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al modificar el plan ", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    //---------------------------------
    //METODOS DETELE
    //---------------------------------

    public ResponseEntity<Object> eliminarPlan (String id){
        ResponseEntity<Object> respuesta;
        try {
            planDao.deleteByIdString(id);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Plan fue eliminado correctamente", HttpStatus.OK);
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al eliminar el plan ", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}

