/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoventa.tos;

/**
 *
 * @author freet
 */
public class UsuarioTO {

    private int idusuario;
    private boolean estatus;

    private String nombre;
    private String apaterno;
    private String amaterno;
    private String email;
    private String password;
    private String rfc;
    private String curp;
    private String sexo;

    public UsuarioTO(int idusuario, int estatus, String nombre, String apaterno, String amaterno, String email, String rfc, String curp, String sexo) {
        this.idusuario = idusuario;
        this.estatus = estatus == 1;
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.email = email;
        this.rfc = rfc;
        this.curp = curp;
        this.sexo = sexo;
    }

    public UsuarioTO(int idusuario, String nombre, String apaterno, String amaterno) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
    }

    public UsuarioTO() {
    }

    public int getIdusuario() {
        return idusuario;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.trim().toUpperCase();
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno.trim().toUpperCase();
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno == null ? null : amaterno.trim().toUpperCase();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc == null ? null : rfc.trim().toUpperCase();
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp == null ? null : curp.trim().toUpperCase();
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
