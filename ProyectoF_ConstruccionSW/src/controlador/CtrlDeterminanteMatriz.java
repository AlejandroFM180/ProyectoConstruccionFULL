/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.DeterminanteMatriz;
import vista.VistaOperaciones;

/**
 * Clase controladora de DeterminanteMatriz
 * @author 
 */
public class CtrlDeterminanteMatriz implements ActionListener {
    private VistaOperaciones vo;
    private List<JTextField> valoresDeMatrizA;
    private int filas, columnas;

    public CtrlDeterminanteMatriz(VistaOperaciones vo) {
        this.vo = vo;
        
        valoresDeMatrizA = new ArrayList<>();
        
        adaptarDiseñoDeVista();

        vo.getjButtonRegresar().addActionListener(this);
        vo.getjButtonResolver().addActionListener(this);
        vo.getjButtonGenerarMatrices().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(vo.getjButtonGenerarMatrices() == ae.getSource()) {
            generarMatrices();
        } 
        if(vo.getjButtonResolver() == ae.getSource()) {
            try {
                imprimirResultado(resolverDeterminante());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "HUBO UN ERROR, VERIFIQUE QUE HAYA LLENADO TODO EL FORMULARIO, \n"
                        + "RECUERDA IGUAL QUE SOLO SE ADMITEN VALORES NUMERICOS.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(vo.getjButtonRegresar() == ae.getSource()) {
            vo.setVisible(false);
        }
    }
    
    public void adaptarDiseñoDeVista() {
        vo.getjLabelTituloVista().setText("DETERMINANTE DE UNA MATRIZ");
        vo.getColumnasMatrizA().setVisible(false);
        vo.getColumnasMatrizB().setVisible(false);
        vo.getFilasMatrizB().setVisible(false);
        vo.getjLabeMatrizB().setText("");
    }
    
    public void generarMatrices() {  
        limpiarMatrices();
        obtenerValoresFilasColumnas();
        
        vo.getPanelMatrizA().setLayout( new GridLayout(filas, columnas) ); 
        
        int totalDeValores = filas * columnas;
        for (int i = 0; i < totalDeValores; i++) {
            JTextField valorMatrizA = new JTextField("valorMatrizA" + i);
            valorMatrizA.setPreferredSize( new Dimension( 35, 35 ) );
            valorMatrizA.setText("");
            vo.getPanelMatrizA().add(valorMatrizA);
            valoresDeMatrizA.add(valorMatrizA);
            vo.getPanelMatrizA().updateUI();
        }
    }
    
    public void limpiarMatrices() {
        vo.getPanelMatrizA().removeAll();
        valoresDeMatrizA.clear();
    }
    
    public void obtenerValoresFilasColumnas() {
        filas = 1;
        columnas = 1;
        try {
            filas = Integer.parseInt(vo.getFilasMatrizA().getSelectedItem().toString());
            columnas = filas;
        } catch (NumberFormatException e) {
        }
    }
    
    public void imprimirResultado(double determinanteResultante) {
        String strDeterminante = String.valueOf(determinanteResultante);
        JOptionPane.showMessageDialog(vo, "El determinante es igual a: " + strDeterminante);
        vo.getjTextAreaResultado().setText(strDeterminante);
    }
    
    public double resolverDeterminante() {     
        double[][] matrizA = new double[filas][columnas];
        int i = 0, j = 0;
        for (JTextField valorMatrizA : valoresDeMatrizA) {
            if(j == columnas){
                i++;
                j = 0;
            }
            matrizA[i][j] = Integer.parseInt(valorMatrizA.getText());
            j++; 
        } 
        
        double determinanteResultante;
        DeterminanteMatriz determinante = new DeterminanteMatriz();
        determinanteResultante = determinante.Determinante(matrizA);
        return determinanteResultante;
    }
}