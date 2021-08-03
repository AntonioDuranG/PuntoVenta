/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoventa.listener;

import com.puntoventa.sesiones.ControladorSesiones;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author freet
 */
public class AppContextListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Cuando se crea una sesion en Login...");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ControladorSesiones.getInstance().removeSession(se.getSession());
    }

}
