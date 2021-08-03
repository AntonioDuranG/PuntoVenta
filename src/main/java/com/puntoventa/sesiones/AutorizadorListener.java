/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoventa.sesiones;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author freet
 */
public class AutorizadorListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent pe) {
        modificarUbicacion(pe.getFacesContext().getViewRoot().getViewId());
    }

    private void modificarUbicacion(String currentPage) {
        if (currentPage.contains("dashboard")) {
            System.out.println("Se Encuentra en: Dashboard");
        }
        if (currentPage.contains("administracion/usuarios.xhtml")) {
            System.out.println("Se Encuentra en: Administración-Usuarios");
        }
        if (currentPage.contains("administracion/perfiles.xhtml")) {
            System.out.println("Se Encuentra en: Administración-Perfiles");
        }
        if (currentPage.contains("administracion/parametros.xhtml")) {
            System.out.println("Se Encuentra en: Configuración-Parámetros");
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
