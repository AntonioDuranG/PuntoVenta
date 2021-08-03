/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoventa.listener;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author freet
 */
public class ConnectionManager {

    private final String jndi;

    public ConnectionManager(String jndi) {
        this.jndi = jndi;
    }

    public Connection getConexion() {
        try {
            Context ctxContexto = new InitialContext();
            DataSource dsOrigenDatos = (DataSource) ctxContexto.lookup(jndi);
            ctxContexto.close();
            return dsOrigenDatos.getConnection();
        } catch (NamingException | SQLException e) {
            System.out.println("ErrorBD: " + e.getMessage());
            return null;
        }
    }
}
