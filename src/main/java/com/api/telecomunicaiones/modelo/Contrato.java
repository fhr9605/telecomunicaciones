package com.api.telecomunicaiones.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@Entity
@Table(name="contratos")
public class Contrato {

    @Id
    @Column(name = "id_cont")
    private Integer id;
    @Column(name="fec_cont")
    private Date fecha;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cli")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @ManyToOne
	@NotNull(message = "El cliente no debe estar vacio")
	private Cliente cliente;
	@OneToOne
	@NotNull(message = "El plan no debe estar vacio")
	@JoinColumn(name ="id_plan")
	private Plan plan;

    public Contrato() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
