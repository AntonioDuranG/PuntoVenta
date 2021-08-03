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
public class MyPaths {

    private static final String BASE = "/PuntoVenta/";

    public static String getDashboard() {
        return BASE + "dashboard.xhtml";
    }

    public static String getLogin() {
        return BASE + "login.xhtml";
    }

    public static String getParametros() {
        return BASE + "configuracion/parametros.xhtml";
    }

    public static String getSesiones() {
        return BASE + "configuracion/sesiones.xhtml";
    }
}
