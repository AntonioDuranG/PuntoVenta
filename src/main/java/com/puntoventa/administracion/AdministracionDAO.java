/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoventa.administracion;

import com.puntoventa.listener.ConnectionUtil;
import com.puntoventa.listener.DBConnectionManager;
import com.puntoventa.tos.UsuarioTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author freet
 */
public class AdministracionDAO {

    public boolean crear(UsuarioTO u) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBConnectionManager.getInstance().getConnection();
            ps = con.prepareStatement(Querys.INSERT_USUARIO);
            int i = 1;
            ps.setString(i++, u.getNombre());
            ps.setString(i++, u.getApaterno());
            ps.setString(i++, u.getAmaterno());
            ps.setString(i++, u.getEmail());
            ps.setString(i++, u.getPassword());
            ps.setInt(i++, 1);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.endConnection(null, ps, con);
        }
        return false;
    }

    public List<UsuarioTO> consultar() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UsuarioTO> usuarios = new ArrayList<>();
        try {
            con = DBConnectionManager.getInstance().getConnection();
            ps = con.prepareStatement(Querys.QUERY_USUARIOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuarios.add(
                        new UsuarioTO(
                                rs.getInt("IDUSUARIO"),
                                rs.getInt("ESTATUS"),
                                rs.getString("NOMBRE"),
                                rs.getString("APATERNO"),
                                rs.getString("AMATERNO"),
                                rs.getString("EMAIL"),
                                rs.getString("RFC"),
                                rs.getString("CURP"),
                                rs.getString("SEXO")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.endConnection(rs, ps, con);
        }
        return usuarios;
    }

    public boolean editar(UsuarioTO u) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBConnectionManager.getInstance().getConnection();
            ps = con.prepareStatement(Querys.UPDATE_USUARIO);
            int i = 1;
            ps.setString(i++, u.getApaterno());
            ps.setString(i++, u.getAmaterno());
            ps.setString(i++, u.getNombre());
            ps.setString(i++, u.getEmail());
            ps.setString(i++, u.getRfc());
            ps.setString(i++, u.getCurp());
            ps.setString(i++, u.getSexo());
            ps.setInt(i++, u.getIdusuario());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.endConnection(null, ps, con);
        }
        return false;
    }

    public boolean editarEstatus(int idusuario, int estatus) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBConnectionManager.getInstance().getConnection();
            ps = con.prepareStatement(Querys.UPDATE_ESTATUS);
            ps.setInt(1, estatus);
            ps.setInt(2, idusuario);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.endConnection(null, ps, con);
        }
        return false;
    }
}
