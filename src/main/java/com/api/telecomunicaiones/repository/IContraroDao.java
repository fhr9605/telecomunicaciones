package com.api.telecomunicaiones.repository;

import com.api.telecomunicaiones.modelo.Contrato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContraroDao extends JpaRepository<Contrato, Integer> {
    
}
