package com.api.telecomunicaiones.repository;

import com.api.telecomunicaiones.modelo.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteDao extends JpaRepository<Cliente,Integer> {
    
}
