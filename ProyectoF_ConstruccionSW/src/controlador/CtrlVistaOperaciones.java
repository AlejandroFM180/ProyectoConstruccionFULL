/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaOperaciones;
import vista.VistaPrincipal;

/**
 *
 * @author VictorEnrique
 */
public class CtrlVistaOperaciones implements ActionListener {
    private VistaOperaciones vo;
    private VistaPrincipal vp;

    public CtrlVistaOperaciones(VistaOperaciones vo, VistaPrincipal vp) {
        this.vo = vo;
        this.vp = vp;
        
        this.vp.setVisible(false);
        this.vo.getjButtonRegresar().addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(vo.getjButtonRegresar() == e.getSource()){
            vo.setVisible(false);
            vp.setVisible(true);
        }
    }
    
}
