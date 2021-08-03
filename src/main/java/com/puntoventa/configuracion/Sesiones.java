/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoventa.configuracion;

import com.puntoventa.sesiones.ControladorSesiones;
import com.puntoventa.tos.UsuarioTO;
import com.puntoventa.util.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author freet
 */
@ManagedBean(eager = true)
@ViewScoped
public class Sesiones implements Serializable {

    List<UsuarioTO> usuarios;

    public Sesiones() {
    }

    public void init() {
        System.out.println("ActualizaSesiones... " + new Date());
        this.usuarios = new ArrayList<>(ControladorSesiones.getInstance().getMAPA_SESIONES_USUARIOS().values());
    }

    public void eliminar(UsuarioTO usuario) {
        if (ControladorSesiones.getInstance().removeSession(usuario.getSession())) {
            init();
        }
    }

    public String getInformacion() {
        if (this.usuarios == null) {
            return Util.getInformacion(0);
        }
        return Util.getInformacion(this.usuarios.size());
    }

    public List<UsuarioTO> getUsuarios() {
        return usuarios;
    }

}
