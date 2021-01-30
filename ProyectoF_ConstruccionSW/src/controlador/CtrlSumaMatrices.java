/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.SumaMatrices;
import vista.VistaOperaciones;

/**
 *
 * @author Iván Aguilar
 */
public final class CtrlSumaMatrices implements ActionListener {

    private VistaOperaciones vo;
    private List<JTextField> valoresDeMatrizA, valoresDeMatrizB;
    private int filas, columnas;

    public CtrlSumaMatrices(VistaOperaciones vo) {
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
                imprimirResultado(resolverSuma());
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
        vo.getjLabelTituloVista().setText("SUMA DE MATRICES");
        vo.getColumnasMatrizB().setVisible(false);
        vo.getFilasMatrizB().setVisible(false);
    }

    public void generarMatrices() {
        limpiarMatrices();
        obtenerValoresFilasColumnas();

        vo.getPanelMatrizA().setLayout(new GridLayout(filas, columnas));
        vo.getPanelMatrizB().setLayout(new GridLayout(filas, columnas));

        int totalDeValores = filas * columnas;
        for (int i = 0; i < totalDeValores; i++) {
            JTextField valorMatrizA = new JTextField("valorMatrizA" + i);
            valorMatrizA.setPreferredSize(new Dimension(35, 35));
            valorMatrizA.setText("");
            vo.getPanelMatrizA().add(valorMatrizA);
            valoresDeMatrizA.add(valorMatrizA);
            vo.getPanelMatrizA().updateUI();

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
        filas = 1;
        columnas = 1;
        try {
            filas = Integer.parseInt(vo.getFilasMatrizA().getSelectedItem().toString());
            columnas = Integer.parseInt(vo.getColumnasMatrizA().getSelectedItem().toString());
        } catch (NumberFormatException e) {
        }
    }

    public void imprimirResultado(int[][] matrizResultante) {
        vo.getjTextAreaResultado().setText("");
        String resultado = "";
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado += "          " + matrizResultante[i][j] + "  ";
            }
            resultado += "\n";
        }
        vo.getjTextAreaResultado().setText(resultado);
    }

    public int[][] resolverSuma() {
        int[][] matrizA = new int[filas][columnas];
        int i = 0, j = 0;
        for (JTextField valorMatrizA : valoresDeMatrizA) {
            if (j == columnas) {
                i++;
                j = 0;
            }
            matrizA[i][j] = Integer.parseInt(valorMatrizA.getText());
            j++;
        }

        int[][] matrizB = new int[filas][columnas];
        i = 0;
        j = 0;
        for (JTextField valorMatrizB : valoresDeMatrizB) {
            if (j == columnas) {
                i++;
                j = 0;
            }
            matrizB[i][j] = Integer.parseInt(valorMatrizB.getText());
            j++;
        }

        int[][] matrizResultante;
        SumaMatrices suma = new SumaMatrices();
        matrizResultante = suma.sumarMatriz(matrizA, matrizB);
        return matrizResultante;
    }
}
