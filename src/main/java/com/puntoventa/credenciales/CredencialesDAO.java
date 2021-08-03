/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoventa.credenciales;

import com.puntoventa.listener.ConnectionUtil;
import com.puntoventa.listener.DBConnectionManager;
import com.puntoventa.tos.UsuarioTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author freet
 */
public class CredencialesDAO {

    public UsuarioTO consultarLogin(String email, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            con = DBConnectionManager.getInstance().getConnection();
            ps = con.prepareStatement(Querys.QUERY_LOGIN);
            System.out.println("Login: " + Querys.QUERY_LOGIN + " | " + email + " | " + password);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new UsuarioTO(
                        rs.getInt("IDUSUARIO"),
                        rs.getString("NOMBRE"),
                        rs.getString("APATERNO"),
                        rs.getString("AMATERNO"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.endConnection(rs, ps, con);
        }
        return null;
    }
}
