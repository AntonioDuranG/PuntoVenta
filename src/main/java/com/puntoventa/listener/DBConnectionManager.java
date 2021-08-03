/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoventa.listener;

import java.sql.Connection;

/**
 *
 * @author freet
 */
public class DBConnectionManager {

    public static int totalconexiones = 0;
//    
    private static DBConnectionManager instance;

    private final ConnectionManager connectionManager;

    private DBConnectionManager(String jndi) {
        this.connectionManager = new ConnectionManager(jndi);
    }

    public static void initInstance(String jndi) {
        if (instance == null) {
            instance = new DBConnectionManager(jndi);
        }
    }

    public static DBConnectionManager getInstance() {
        return instance;
    }

    public Connection getConnection() {
        if (connectionManager == null) {
            throw new IllegalArgumentException("Base de Datos no existe o no inicializada");
        }
        totalconexiones++;
        System.out.println("TotalConexiones: " + totalconexiones);
        return connectionManager.getConexion();
    }
}
