/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoventa.listener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author freet
 */
public class ConnectionUtil {

    public static synchronized void endConnection(ResultSet rs, PreparedStatement ps, Connection con) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.println("ErrorRsCerrar: " + e.getMessage());
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                System.out.println("ErrorPsCerrar: " + e.getMessage());
            }
        }
        if (con != null) {
            try {
                if (!con.isClosed()) {
                    con.close();
                    DBConnectionManager.totalconexiones--;
                    System.out.println("TotalConexiones: " + DBConnectionManager.totalconexiones);
                }
            } catch (Exception e) {
                System.out.println("ErrorConexionCerrar: " + e.getMessage());
            }
        }
    }
}
