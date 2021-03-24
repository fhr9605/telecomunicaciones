package com.api.telecomunicaiones.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "planes")
public class Plan {
    @Id
    @Column(name = "id_plan")
    private String id;
    @Column(name = "nom_plan", length = 30)
    private String nombre;
    @Column(name = "car_plan", length = 75)
    private String caracteristicas;
    @Column(name = "per_plan", length = 20)
    private double precio;
    
    public Plan() {
        super();
    }

    public Plan(String id, String nombre, String caracteristicas, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.caracteristicas = caracteristicas;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCaracteristicas() {
        return caracteristicas;
    }
    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
