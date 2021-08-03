/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoventa.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author freet
 */
@ManagedBean
@SessionScoped
public class AppBean implements Serializable {

    public List<SelectItem> getComboSexo() {
        List<SelectItem> combo = new ArrayList<>();
        combo.add(new SelectItem("F", "Femenino"));
        combo.add(new SelectItem("M", "Masculino"));
        return combo;
    }

    public String getMensajeErrorIngresar() {
        return Mensajes.MENSAJE_ERROR_INGRESAR;
    }

    public void cambiarParametros() {
        Util.cambiarUbicacion(MyPaths.getParametros());
    }
}
