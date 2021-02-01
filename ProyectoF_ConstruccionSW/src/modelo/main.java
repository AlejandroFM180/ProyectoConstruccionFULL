/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.CtrlVistaPrincipal;
import vista.VistaPrincipal;

/**
 * Este sistema consiste en una calculadora de matrices que puede realizar varias operaciones.
 * @author Montserrat, Jafet y Victor
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
