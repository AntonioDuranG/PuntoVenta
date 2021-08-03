/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoventa.sesiones;

import com.puntoventa.listener.ConnectionUtil;
import com.puntoventa.listener.DBConnectionManager;
import com.puntoventa.tos.UsuarioTO;
import com.puntoventa.util.MyPaths;
import com.puntoventa.util.Util;
import java.sql.Connection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author freet
 */
public class ControladorSesiones {

    private static final Map<String, UsuarioTO> MAPA_SESIONES = Collections.synchronizedMap(new HashMap<String, UsuarioTO>());
    private static final Map<String, UsuarioTO> MAPA_SESIONES_USUARIOS = Collections.synchronizedMap(new HashMap<String, UsuarioTO>());
    private static final Map<String, Connection> MAPA_SESIONES_CONEXIONES = Collections.synchronizedMap(new HashMap<String, Connection>());

    private ControladorSesiones() {
    }

    public static ControladorSesiones getInstance() {
        return ControladorSesionesHolder.INSTANCE;
    }

    private static class ControladorSesionesHolder {

        private static final ControladorSesiones INSTANCE = new ControladorSesiones();
    }

    public void addSession(UsuarioTO usuario) {
        Date fechasesion = new Date();
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        System.out.println("SesionAdd... " + request.getRemoteAddr() + " | " + session.getId() + " | " + fechasesion);
        usuario.setSesion(session, request.getRemoteAddr(), fechasesion);
        MAPA_SESIONES.put(session.getId(), usuario);
        MAPA_SESIONES_USUARIOS.put(usuario.getIdusuario().toString(), usuario);
        MAPA_SESIONES_CONEXIONES.put(session.getId(), DBConnectionManager.getInstance().getConnection());
    }

    public boolean removeSession() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        if (ControladorSesiones.MAPA_SESIONES.get(session.getId()) != null) {
            ConnectionUtil.endConnection(null, null,
                    ControladorSesiones.MAPA_SESIONES_CONEXIONES.get(session.getId()));
//            
            ControladorSesiones.MAPA_SESIONES_CONEXIONES.remove(session.getId());
//            
            UsuarioTO usuario = ControladorSesiones.MAPA_SESIONES.get(session.getId());

            ControladorSesiones.MAPA_SESIONES.remove(session.getId());
            ControladorSesiones.MAPA_SESIONES_USUARIOS.remove(usuario.getIdusuario().toString());
            System.out.println("LogoutUsuario: " + usuario.getNombre() + " " + usuario.getApaterno() + " | " + new Date());
            session.invalidate();
        }
//        
        return true;
    }

    public boolean removeSession(HttpSession session) {

        if (ControladorSesiones.MAPA_SESIONES.get(session.getId()) != null) {
//          
            ConnectionUtil.endConnection(null, null,
                    ControladorSesiones.MAPA_SESIONES_CONEXIONES.get(session.getId()));
//            
            ControladorSesiones.MAPA_SESIONES_CONEXIONES.remove(session.getId());
//            
            UsuarioTO usuario = ControladorSesiones.MAPA_SESIONES.get(session.getId());
            ControladorSesiones.MAPA_SESIONES.remove(session.getId());
//            
            ControladorSesiones.MAPA_SESIONES_USUARIOS.remove(usuario.getIdusuario().toString());
            System.out.println("TimeOutUsuario: " + usuario.getNombre() + " " + usuario.getApaterno() + " | " + new Date());
            session.invalidate();
        }
//        
        return true;
    }

    public void cambioUbicacion(String ubicacion) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        if (MAPA_SESIONES.get(session.getId()) != null) {
            MAPA_SESIONES.get(session.getId()).setUbicacion(ubicacion);
        }
    }

    public Connection getConnection() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        if (MAPA_SESIONES_CONEXIONES.get(session.getId()) != null) {
            return ControladorSesiones.MAPA_SESIONES_CONEXIONES.get(session.getId());
        }
        return null;
    }

    public Map<String, UsuarioTO> getMAPA_SESIONES_USUARIOS() {
        return MAPA_SESIONES_USUARIOS;
    }
}
