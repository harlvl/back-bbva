package com.g3.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "recibo")
public class Recibo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "DNI")
    private String dni;

    @Column(name = "Codigo_empresa")
    private String codigo_empresa;

    @Column(name = "nro_suministro")
    private Integer nro_suministro;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "fecha_vencimiento")
    private Date fecha_vencimiento;

    @Column(name = "descripcion")
    private String descripcion;

    public Recibo() {
    }

    public Recibo(String dni, String codigo_empresa, Integer nro_suministro, Double monto, Integer estado, Date fecha_vencimiento, String descripcion) {
        this.dni = dni;
        this.codigo_empresa = codigo_empresa;
        this.nro_suministro = nro_suministro;
        this.monto = monto;
        this.estado = estado;
        this.fecha_vencimiento = fecha_vencimiento;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCodigo_empresa() {
        return codigo_empresa;
    }

    public void setCodigo_empresa(String codigo_empresa) {
        this.codigo_empresa = codigo_empresa;
    }

    public Integer getNro_suministro() {
        return nro_suministro;
    }

    public void setNro_suministro(Integer nro_suministro) {
        this.nro_suministro = nro_suministro;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
