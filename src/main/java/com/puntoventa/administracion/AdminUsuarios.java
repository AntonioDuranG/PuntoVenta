/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoventa.administracion;

import com.puntoventa.tos.UsuarioTO;
import com.puntoventa.util.Etiquetas;
import com.puntoventa.util.Mapas;
import com.puntoventa.util.Mensajes;
import com.puntoventa.util.Util;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author freet
 */
@ManagedBean(eager = true)
@ViewScoped
public class AdminUsuarios implements Serializable {

    private UsuarioTO usuario;
//    
    private UsuarioTO selectedusuario;

    private List<UsuarioTO> usuarios;
    private List<UsuarioTO> filteredusuarios;

    private AdministracionDAO controlador;

    public AdminUsuarios() {
        if (this.controlador == null) {
            this.controlador = new AdministracionDAO();
        }
        if (this.usuario == null) {
            this.usuario = new UsuarioTO();
        }
    }

    @PostConstruct
    public void init() {
        usuarios = controlador.consultar();
    }

    public void limpiar() {
        usuario = new UsuarioTO();
    }

    public void crear() {
        FacesMessage msg = controlador.crear(usuario)
                ? Util.getFacesMessage(FacesMessage.SEVERITY_INFO, Mensajes.MENSAJE_EXITOSO)
                : Util.getFacesMessage(FacesMessage.SEVERITY_ERROR, Mensajes.MENSAJE_ERROR);
//        
        RequestContext.getCurrentInstance().addCallbackParam("esvalido", FacesMessage.SEVERITY_INFO.equals(msg.getSeverity()));
        if (msg.getSeverity().equals(FacesMessage.SEVERITY_INFO)) {
            System.out.println("Enviar Notificación snmpt: " + Mapas.MAPA_CONFIGURACION.get(Etiquetas.MAIL_SMTP.getConcepto()));
            System.out.println("Enviar Notificación user: " + Mapas.MAPA_CONFIGURACION.get(Etiquetas.MAIL_USER.getConcepto()));
            System.out.println("Enviar Notificación puerto: " + Mapas.MAPA_CONFIGURACION.get(Etiquetas.MAIL_PUERTO.getConcepto()));
        }
//        
        validarMsg(msg);
    }

    public void editar(UsuarioTO u) {
        FacesMessage msg = controlador.editar(u)
                ? Util.getFacesMessage(FacesMessage.SEVERITY_INFO, Mensajes.MENSAJE_EXITOSO)
                : Util.getFacesMessage(FacesMessage.SEVERITY_ERROR, Mensajes.MENSAJE_ERROR);
//        
        validarMsg(msg);
    }

    public void editarEstatus(int estatus) {
        FacesMessage msg = controlador.editarEstatus(selectedusuario.getIdusuario(), estatus)
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

    public UsuarioTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioTO usuario) {
        this.usuario = usuario;
    }

    public List<UsuarioTO> getUsuarios() {
        return usuarios;
    }
//

    public List<UsuarioTO> getFilteredusuarios() {
        return filteredusuarios;
    }

    public void setFilteredusuarios(List<UsuarioTO> filteredusuarios) {
        this.filteredusuarios = filteredusuarios;
    }

    public String getInformacion() {
        if (this.usuarios == null) {
            return Util.getInformacion(0);
        }
        return Util.getInformacion(this.usuarios.size());
    }

    public UsuarioTO getSelectedusuario() {
        return selectedusuario;
    }

    public void setSelectedusuario(UsuarioTO selectedusuario) {
        this.selectedusuario = selectedusuario;
    }

}
