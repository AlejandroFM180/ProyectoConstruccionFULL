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
import modelo.MultiplicacionMatrices;
import vista.VistaOperaciones;

/**
 *
 * @author Iván Aguilar
 */
public final class CtrlMultiplicacionMatrices implements ActionListener {

    private VistaOperaciones vo;
    private List<JTextField> valoresDeMatrizA, valoresDeMatrizB;
    private int filasA, columnasA, filasB, columnasB;

    public CtrlMultiplicacionMatrices(VistaOperaciones vo) {
        this.vo = vo;
        valoresDeMatrizA = new ArrayList<>();
        valoresDeMatrizB = new ArrayList<>();

        adaptarDiseñoDeVista();

        vo.getjButtonRegresar().addActionListener(this);
        vo.getjButtonResolver().addActionListener(this);
        vo.getjButtonGenerarMatrices().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (vo.getjButtonGenerarMatrices() == ae.getSource()) {
            generarMatrices();
        }
        if (vo.getjButtonResolver() == ae.getSource()) {
            try {
                imprimirResultado(resolverMultiplicacion());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "HUBO UN ERROR, VERIFIQUE QUE HAYA LLENADO TODO EL FORMULARIO, \n"
                        + "RECUERDA IGUAL QUE SOLO SE ADMITEN VALORES NUMERICOS.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (vo.getjButtonRegresar() == ae.getSource()) {
            vo.setVisible(false);
        }
    }

    public void adaptarDiseñoDeVista() {
        vo.getjLabelTituloVista().setText("MULTIPLICACIÓN DE MATRICES");
        vo.getFilasMatrizB().setVisible(false);
    }

    public void generarMatrices() {
        limpiarMatrices();
        obtenerValoresFilasColumnas();

        vo.getPanelMatrizA().setLayout(new GridLayout(filasA, columnasA));
        vo.getPanelMatrizB().setLayout(new GridLayout(filasB, columnasB));

        int totalDeValoresA = filasA * columnasA;
        for (int i = 0; i < totalDeValoresA; i++) {
            JTextField valorMatrizA = new JTextField("valorMatrizA" + i);
            valorMatrizA.setPreferredSize(new Dimension(35, 35));
            valorMatrizA.setText("");
            vo.getPanelMatrizA().add(valorMatrizA);
            valoresDeMatrizA.add(valorMatrizA);
            vo.getPanelMatrizA().updateUI();
        }

        int totalDeValoresB = filasB * columnasB;
        for (int i = 0; i < totalDeValoresB; i++) {
            JTextField valorMatrizB = new JTextField("valorMatrizB" + i);
            valorMatrizB.setPreferredSize(new Dimension(35, 35));
            valorMatrizB.setText("");
            vo.getPanelMatrizB().add(valorMatrizB);
            valoresDeMatrizB.add(valorMatrizB);
            vo.getPanelMatrizB().updateUI();
        }
    }

    public void limpiarMatrices() {
        vo.getPanelMatrizA().removeAll();
        valoresDeMatrizA.clear();
        vo.getPanelMatrizB().removeAll();
        valoresDeMatrizB.clear();
    }

    public void obtenerValoresFilasColumnas() {
        filasA = 1;
        columnasA = 1;
        filasB = 1;
        columnasB = 1;
        try {
            filasA = Integer.parseInt(vo.getFilasMatrizA().getSelectedItem().toString());
            columnasA = Integer.parseInt(vo.getColumnasMatrizA().getSelectedItem().toString());
            filasB = columnasA;
            columnasB = Integer.parseInt(vo.getColumnasMatrizB().getSelectedItem().toString());
        } catch (NumberFormatException e) {
        }
    }

    public void imprimirResultado(int[][] matrizResultante) {
        vo.getjTextAreaResultado().setText("");
        String resultado = "";
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                resultado += "          " + matrizResultante[i][j] + "  ";
            }
            resultado += "\n";
        }
        vo.getjTextAreaResultado().setText(resultado);
    }

    public int[][] resolverMultiplicacion() {
        int[][] matrizA = new int[filasA][columnasA];
        int i = 0, j = 0;
        for (JTextField valorMatrizA : valoresDeMatrizA) {
            if (j == columnasA) {
                i++;
                j = 0;
            }
            matrizA[i][j] = Integer.parseInt(valorMatrizA.getText());
            j++;
        }

        int[][] matrizB = new int[filasB][columnasB];
        i = 0;
        j = 0;
        for (JTextField valorMatrizB : valoresDeMatrizB) {
            if (j == columnasB) {
                i++;
                j = 0;
            }
            matrizB[i][j] = Integer.parseInt(valorMatrizB.getText());
            j++;
        }

        int[][] matrizResultante;
        MultiplicacionMatrices multiplicacion = new MultiplicacionMatrices();
        matrizResultante = multiplicacion.multiplicarMatriz(matrizA, matrizB);
        return matrizResultante;
    }
}
