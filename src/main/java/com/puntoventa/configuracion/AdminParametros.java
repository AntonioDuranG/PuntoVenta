/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoventa.configuracion;

import com.puntoventa.tos.ParametroTO;
import com.puntoventa.util.Mensajes;
import com.puntoventa.util.Util;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author freet
 */
@ManagedBean(eager = true)
@ViewScoped
public class AdminParametros implements Serializable {

    private List<ParametroTO> parametros;
    private List<ParametroTO> filteredparametros;
//    
    private ConfiguracionDAO controlador;

    public AdminParametros() {
        if (this.controlador == null) {
            this.controlador = new ConfiguracionDAO();
        }
    }

    @PostConstruct
    public void init() {
        parametros = controlador.consultarParametros();
    }

    public void editar(ParametroTO p) {
        FacesMessage msg = controlador.editar(p)
                ? Util.getFacesMessage(FacesMessage.SEVERITY_INFO, Mensajes.MENSAJE_EXITOSO)
                : Util.getFacesMessage(FacesMessage.SEVERITY_ERROR, Mensajes.MENSAJE_ERROR);
        validarMsg(msg);
    }

    private void validarMsg(FacesMessage msg) {
        FacesContext.getCurrentInstance().addMessage(null, msg);
//        
        if (msg.getSeverity().equals(FacesMessage.SEVERITY_INFO)) {
            init();
        }
    }

    public String getInformacion() {
        if (parametros == null) {
            return Util.getInformacion(0);
        }
        return Util.getInformacion(parametros.size());
    }

    public List<ParametroTO> getParametros() {
        return parametros;
    }

    public List<ParametroTO> getFilteredparametros() {
        return filteredparametros;
    }

    public void setFilteredparametros(List<ParametroTO> filteredparametros) {
        this.filteredparametros = filteredparametros;
    }

}
