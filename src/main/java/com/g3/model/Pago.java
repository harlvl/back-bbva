package com.g3.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;


@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "monto")
    private Double monto;

    @Autowired
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tarjeta_id", nullable = false)
    private Tarjeta tarjeta;


    public Pago() {
    }

    public Pago(Double monto) {
        this.monto = monto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}
