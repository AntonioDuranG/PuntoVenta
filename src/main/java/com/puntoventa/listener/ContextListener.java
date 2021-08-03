/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoventa.listener;

import com.puntoventa.configuracion.ConfiguracionDAO;
import java.util.Date;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author freet
 */
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String jndi = sce.getServletContext().getInitParameter("JNDI_Servicio");
        System.out.println("ContextListener JNDI: " + jndi);
        DBConnectionManager.initInstance(jndi);
//        
        new ConfiguracionDAO().consultarParametros();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Encontro contextDestroyed: " + new Date());
    }

}
