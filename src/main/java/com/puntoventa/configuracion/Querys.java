/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoventa.configuracion;

/**
 *
 * @author freet
 */
public class Querys {

    public static final String QUERY_PARAMETROS = "SELECT IDPARAMETRO,PARAMETRO,DESCRIPCION,VALOR FROM parametros ORDER BY PARAMETRO ASC";

    public static final String UPDATE_PARAMETRO = "update parametros set VALOR = ? where IDPARAMETRO = ?";
}
