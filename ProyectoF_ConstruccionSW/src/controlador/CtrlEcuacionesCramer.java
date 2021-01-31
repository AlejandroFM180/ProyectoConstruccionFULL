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
import modelo.EcuacionesCramer;
import vista.VistaOperaciones;

/**
 *
 * @author VictorEnrique
 */
public class CtrlEcuacionesCramer implements ActionListener {

    private VistaOperaciones vo;
    private List<JTextField> valoresDeMatrizA;
    private int filas, columnas;

    public CtrlEcuacionesCramer(VistaOperaciones vo) {
        this.vo = vo;
        valoresDeMatrizA = new ArrayList<>();

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
                imprimirResultado(resolverSistema());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "HUBO UN ERROR, VERIFIQUE QUE HAYA LLENADO TODO EL FORMULARIO, \n"
                        + "RECUERDA IGUAL QUE SOLO SE ADMITEN VALORES NUMERICOS.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (vo.getjButtonRegresar() == ae.getSource()) {
            vo.setVisible(false);
        }
    }

    private void adaptarDiseñoDeVista() {
        vo.getjLabelTituloVista().setText("SISTEMA DE ECUACIONES POR CRAMER");
        vo.getColumnasMatrizA().setVisible(false);
        vo.getColumnasMatrizB().setVisible(false);
        vo.getFilasMatrizB().setVisible(false);
        vo.getjLabeMatrizB().setText("");
    }

    private void generarMatrices() {
        limpiarMatrices();
        obtenerValoresFilasColumnas();

        vo.getPanelMatrizA().setLayout(new GridLayout(filas, columnas));

        int totalDeValores = filas * columnas;
        for (int i = 0; i < totalDeValores; i++) {
            JTextField valorMatrizA = new JTextField("valorMatrizA" + i);
            valorMatrizA.setPreferredSize(new Dimension(35, 35));
            valorMatrizA.setText("");
            vo.getPanelMatrizA().add(valorMatrizA);
            valoresDeMatrizA.add(valorMatrizA);
            vo.getPanelMatrizA().updateUI();
        }
    }

    private void limpiarMatrices() {
        vo.getPanelMatrizA().removeAll();
        valoresDeMatrizA.clear();
    }

    private void obtenerValoresFilasColumnas() {
        filas = 1;
        columnas = 1;
        try {
            filas = Integer.parseInt(vo.getFilasMatrizA().getSelectedItem().toString());
            columnas = filas + 1;
        } catch (NumberFormatException e) {
        }
    }

    public void imprimirResultado(String valorDeVariables) {
        if (valorDeVariables != "") {
            JOptionPane.showMessageDialog(vo, valorDeVariables);
        }
        vo.getjTextAreaResultado().setText(valorDeVariables);
    }

    public String resolverSistema() {
        double[][] matrizA = new double[filas][columnas - 1];
        double[] arrayB = new double[filas];
        int i = 0, j = 0;
        for (JTextField valorMatrizA : valoresDeMatrizA) {
            if (j == columnas) {
                i++;
                j = 0;
            }

            if (j != columnas - 1) {
                matrizA[i][j] = Integer.parseInt(valorMatrizA.getText());
            } else {
                arrayB[i] = Integer.parseInt(valorMatrizA.getText());
            }
            j++;
        }

        String valorDeVariables;
        int numeroDeVariables = filas;
        EcuacionesCramer sistema = new EcuacionesCramer();
        valorDeVariables = sistema.resolverSistema(matrizA, arrayB);
        return valorDeVariables;
    }
}