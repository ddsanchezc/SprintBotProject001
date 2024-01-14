package com.rimac.apirest.model;

import jakarta.persistence.*;

@Entity
@Table(name = "currency")
public class Currency {
    @Id //Este campo serÃ¡ la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generar automaticamente el valor del id
    private Long id;
    @Column(name = "ncurrency")
    private String ncurrency;

    @Column(name = "nexchange")
    private String nexchange;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNcurrency() {
        return ncurrency;
    }

    public void setNcurrency(String ncurrency) {
        this.ncurrency = ncurrency;
    }

    public String getNexchange() {
        return nexchange;
    }

    public void setNexchange(String nexchange) {
        this.nexchange = nexchange;
    }
}
