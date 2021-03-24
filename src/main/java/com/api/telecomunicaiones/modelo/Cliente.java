package com.api.telecomunicaiones.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @Column(name = "id_cli")
    private Integer cedula;
    @Column(name = "nom_cli", length = 75)
    private String nombre;
    @Column(name = "tel_cli", length = 15)
    private int telefono;
    @Column(name = "ciu_cli", length = 20)
    private String cuidad;
    @Column(name = "dir_cli", length = 35)
    private String direccion;
    @Column(name = "email_cli", length = 40)
    private String email;

    public Cliente() {
        super();
    }

    public Cliente(Integer cedula, String nombre, int telefono, String cuidad, String direccion, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.cuidad = cuidad;
        this.direccion = direccion;
        this.email = email;
    }

    public Integer getCedula() {
        return cedula;
    }
    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getCuidad() {
        return cuidad;
    }
    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    

    
}
