/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoventa.configuracion;

import com.puntoventa.listener.ConnectionUtil;
import com.puntoventa.listener.DBConnectionManager;
import com.puntoventa.tos.ParametroTO;
import com.puntoventa.util.Mapas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author freet
 */
public class ConfiguracionDAO {

    public List<ParametroTO> consultarParametros() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ParametroTO> parametros = new ArrayList<>();
        Mapas.MAPA_CONFIGURACION = new HashMap<>();
        try {
            con = DBConnectionManager.getInstance().getConnection();
            ps = con.prepareStatement(Querys.QUERY_PARAMETROS);
            rs = ps.executeQuery();
            while (rs.next()) {
                parametros.add(
                        new ParametroTO(
                                rs.getInt("IDPARAMETRO"),
                                rs.getString("PARAMETRO"),
                                rs.getString("DESCRIPCION"),
                                rs.getString("VALOR")));
//                
                System.out.println("Parametro: " + rs.getString("PARAMETRO") + " | " + rs.getString("VALOR"));
                Mapas.MAPA_CONFIGURACION.put(rs.getString("PARAMETRO"), rs.getString("VALOR"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.endConnection(rs, ps, con);
        }
        return parametros;
    }

    public boolean editar(ParametroTO p) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBConnectionManager.getInstance().getConnection();
            ps = con.prepareStatement(Querys.UPDATE_PARAMETRO);
            ps.setString(1, p.getValor());
            ps.setInt(2, p.getIdparametro());
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
