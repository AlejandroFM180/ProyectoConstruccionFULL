/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.VistaOperaciones;
import vista.VistaPrincipal;

/**
 * Esta clase es el controlador de la vista principal
 * @author Victor, Montserrat y Jafet
 */
public class CtrlVistaPrincipal implements ActionListener {

    private VistaPrincipal vp;
    private VistaOperaciones vo;

    /*
     * Agrega un listener a la vista principal para el botón de cerrar y la caja para seleccionar operaciones.
    */
    public CtrlVistaPrincipal(VistaPrincipal vp) {
        this.vp = vp;

        vp.getjButtonCerrar().addActionListener(this);
        vp.getjComboBoxOperaciones().addActionListener(this);
    }

    /*
     * Abre una ventana de Vista Operaciones con la operación correspondiente que seleccione el usuario.
    */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (vp.getjButtonCerrar() == ae.getSource()) {
            System.exit(0);
        }
        if (vp.getjComboBoxOperaciones().getSelectedItem().equals("Suma de matrices")) {
            vo = new VistaOperaciones();
            CtrlSumaMatrices cms = new CtrlSumaMatrices(vo);
            CtrlVistaOperaciones cvo = new CtrlVistaOperaciones(vo, vp);
            vo.setVisible(true);
        }
        if (vp.getjComboBoxOperaciones().getSelectedItem().equals("Multiplicación de matriz por escalar")) {
            vo = new VistaOperaciones();
            CtrlEscalarMatrices cmm = new CtrlEscalarMatrices(vo);
            CtrlVistaOperaciones cvo = new CtrlVistaOperaciones(vo, vp);
            vo.setVisible(true);
        }
        if (vp.getjComboBoxOperaciones().getSelectedItem().equals("Multiplicación de matrices")) {
            vo = new VistaOperaciones();
            CtrlMultiplicacionMatrices cmm = new CtrlMultiplicacionMatrices(vo);
            CtrlVistaOperaciones cvo = new CtrlVistaOperaciones(vo, vp);
            vo.setVisible(true);
        }

        if (vp.getjComboBoxOperaciones().getSelectedItem().equals("Obtención de la inversa de una matriz (Gauss)")) {
            vo = new VistaOperaciones();
            CtrlInversaMatrizGauss cim = new CtrlInversaMatrizGauss(vo);
            CtrlVistaOperaciones cvo = new CtrlVistaOperaciones(vo, vp);
            vo.setVisible(true);
        }
        if (vp.getjComboBoxOperaciones().getSelectedItem().equals("Sistema de ecuaciones por Gauss-Jordan")) {
            vo = new VistaOperaciones();
            CtrlSistemaEcuaciones cse = new CtrlSistemaEcuaciones(vo);
            CtrlVistaOperaciones cvo = new CtrlVistaOperaciones(vo, vp);
            vo.setVisible(true);
        }
        if (vp.getjComboBoxOperaciones().getSelectedItem().equals("Determinante de una matriz")) {
            vo = new VistaOperaciones();
            CtrlDeterminanteMatriz cdm = new CtrlDeterminanteMatriz(vo);
            CtrlVistaOperaciones cvo = new CtrlVistaOperaciones(vo, vp);
            vo.setVisible(true);
        }
        if (vp.getjComboBoxOperaciones().getSelectedItem().equals("Sistema de ecuaciones por Cramer")) {
            vo = new VistaOperaciones();
            CtrlEcuacionesCramer cdm = new CtrlEcuacionesCramer(vo);
            CtrlVistaOperaciones cvo = new CtrlVistaOperaciones(vo, vp);
            vo.setVisible(true);
        }
    }
}
