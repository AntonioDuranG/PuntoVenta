/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoventa.util;

/**
 *
 * @author freet
 */
public enum Etiquetas {
//   
    MAIL_PASSWORD("MAIL_PASSWORD"),
    MAIL_PUERTO("MAIL_PUERTO"),
    MAIL_SMTP("MAIL_SMTP"),
    MAIL_USER("MAIL_USER");
//
    private String concepto;

    private Etiquetas(String concepto) {
        this.concepto = concepto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

}
