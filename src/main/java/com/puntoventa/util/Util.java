/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoventa.util;

import java.text.DecimalFormat;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author freet
 */
public class Util {

    public static FacesMessage getFacesMessage(FacesMessage.Severity severity, String mensaje) {
        return new FacesMessage(severity, mensaje, null);
    }

    public static String getInformacion(int size) {
        DecimalFormat df = new DecimalFormat("###,###,###,###");
        return " REGISTRO(S): " + df.format(size);
    }
    
    public static void cambiarUbicacion(String ruta) {
        try {
            System.out.println("CambiaUbicacion... " + ruta);
            FacesContext.getCurrentInstance().getExternalContext().redirect(ruta);
        } catch (Exception e) {
        }
    }
}
