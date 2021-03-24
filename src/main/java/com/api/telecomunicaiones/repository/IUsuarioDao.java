package com.api.telecomunicaiones.repository;

import com.api.telecomunicaiones.modelo.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Integer> {
    public Usuario findByNombre(String nombre);
}
