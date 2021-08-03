/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoventa.credenciales;

/**
 *
 * @author freet
 */
public class Querys {

    public static final String QUERY_LOGIN = "select IDUSUARIO,APATERNO,AMATERNO,NOMBRE from usuarios where EMAIL = ? and PASSWORD = ? and ESTATUS = 1";
}
