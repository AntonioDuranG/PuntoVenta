/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoventa.administracion;

/**
 *
 * @author freet
 */
public class Querys {

    public static final String INSERT_USUARIO = "insert into usuarios (NOMBRE,APATERNO,AMATERNO,EMAIL,PASSWORD,ESTATUS) values (?,?,?,?,?,?)";

    public static final String UPDATE_USUARIO = "UPDATE usuarios SET APATERNO = ?,AMATERNO = ?,NOMBRE = ?,EMAIL = ?,RFC = ?,CURP = ?,SEXO = ? WHERE IDUSUARIO = ?";

    public static final String QUERY_USUARIOS = "SELECT IDUSUARIO,NOMBRE,APATERNO,AMATERNO,EMAIL,ESTATUS,RFC,CURP,SEXO FROM usuarios ORDER BY APATERNO ASC";

    public static final String UPDATE_ESTATUS = "update usuarios set ESTATUS = ? where IDUSUARIO = ?";
}
