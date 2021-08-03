/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoventa.credenciales;

import com.puntoventa.sesiones.ControladorSesiones;
import com.puntoventa.tos.UsuarioTO;
import com.puntoventa.util.Mensajes;
import com.puntoventa.util.MyPaths;
import com.puntoventa.util.Util;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author freet
 */
@ManagedBean
@SessionScoped
public class Login implements Serializable {

    private String mail;
    private String password;

    private CredencialesDAO controlador;

    public Login() {
        if (this.controlador == null) {
            this.controlador = new CredencialesDAO();
        }
    }

    public void login(ActionEvent e) {
        FacesMessage msg;
//        
        UsuarioTO u = controlador.consultarLogin(mail, password);
        if (u == null) {
            msg = Util.getFacesMessage(FacesMessage.SEVERITY_ERROR, Mensajes.ERROR_CREDENCIALES);
        } else {
            msg = Util.getFacesMessage(FacesMessage.SEVERITY_INFO, Mensajes.EXITOSO_CREDENCIALES + u.getApaterno() + " " + u.getAmaterno() + " " + u.getNombre());
            ControladorSesiones.getInstance().addSession(u);
            Util.cambiarUbicacion(MyPaths.getDashboard());
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void logout(ActionEvent event) {
        boolean isvalidate = ControladorSesiones.getInstance().removeSession();
        if (isvalidate) {
            Util.cambiarUbicacion(MyPaths.getLogin());
        }
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
