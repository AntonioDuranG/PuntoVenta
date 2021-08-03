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
        String modulo = "";
        if (currentPage.contains("dashboard")) {
            modulo = "Dashboard";
        }
        if (currentPage.contains("administracion/usuarios.xhtml")) {
            modulo = "Administración-Usuarios";
        }
        if (currentPage.contains("administracion/perfiles.xhtml")) {
            modulo = "Administración-Perfiles";
        }
        if (currentPage.contains("configuracion/parametros.xhtml")) {
            modulo = "Configuración-Parámetros";
        }
        if (currentPage.contains("configuracion/sesiones.xhtml")) {
            modulo = "Configuración-Sesiones";
        }
        ControladorSesiones.getInstance().cambioUbicacion(modulo);
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
