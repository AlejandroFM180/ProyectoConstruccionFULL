/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.CtrlVistaPrincipal;
import vista.VistaPrincipal;

/**
 *
 * @author Iván Aguilar
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VistaPrincipal vp = new VistaPrincipal();
        CtrlVistaPrincipal cvp = new CtrlVistaPrincipal(vp);
        vp.setVisible(true);
    }
    
}
