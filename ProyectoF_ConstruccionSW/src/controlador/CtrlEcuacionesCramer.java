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
 * Esta clase es el controlador de Sistema de Ecuaciones con el método de Cramer
 * @author Victor, Montserrat y Jafet
 */
public class CtrlEcuacionesCramer implements ActionListener {

    private VistaOperaciones vo;
    private List<JTextField> valoresDeMatrizA;
    private int filas, columnas;
    /*
     * Prepara la vista de operaciones para realizar la solución de ecuaciones con método de Cramer.
    */
    public CtrlEcuacionesCramer(VistaOperaciones vo) {
        this.vo = vo;
        valoresDeMatrizA = new ArrayList<>();

        adaptarDiseñoDeVista();

        vo.getjButtonRegresar().addActionListener(this);
        vo.getjButtonResolver().addActionListener(this);
        vo.getjButtonGenerarMatrices().addActionListener(this);
    }
    
    /*
     * Este método llama a la funcion Generar matrices cuando se presiona el botón con el mismo nombre,
     * tambien realiza el cálculo si se ingresan datos válidos (números en lugar de espacios vacíos o caracteres)
     * en caso contrario, mostrará un mensaje de error.
    */
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

    /*
     * Cambia el título de la vista con el de la operación "SISTEMA DE ECUACIONES POR CRAMER"
    */
    private void adaptarDiseñoDeVista() {
        vo.getjLabelTituloVista().setText("SISTEMA DE ECUACIONES POR CRAMER");
        vo.getColumnasMatrizA().setVisible(false);
        vo.getColumnasMatrizB().setVisible(false);
        vo.getFilasMatrizB().setVisible(false);
        vo.getjLabeMatrizB().setText("");
    }

    /*
     * Genera una matriz para que el usuario ingrese los datos en las celdas
    */
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

    /*
     * Vacía las celdas de la matriz y elimina los valores almacenados en la matriz.
    */
    private void limpiarMatrices() {
        vo.getPanelMatrizA().removeAll();
        valoresDeMatrizA.clear();
    }

    /*
     * Este método obtiene los valores de las filas y las columnas.
    */
    private void obtenerValoresFilasColumnas() {
        filas = 1;
        columnas = 1;
        try {
            filas = Integer.parseInt(vo.getFilasMatrizA().getSelectedItem().toString());
            columnas = filas + 1;
        } catch (NumberFormatException e) {
        }
    }

    /*
     * Muestra una ventana emergente con el resultado y despliega el resultado en la caja de texto de la vista de operaciones.
    */
    public void imprimirResultado(String valorDeVariables) {
        if (valorDeVariables != "") {
            JOptionPane.showMessageDialog(vo, valorDeVariables);
        }
        vo.getjTextAreaResultado().setText(valorDeVariables);
    }

    /*
     * Este método realiza la resolución del sistema de ecuaciones con el método de Cramer.
    */
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
                matrizA[i][j] = Double.parseDouble(valorMatrizA.getText());
            } else {
                arrayB[i] = Double.parseDouble(valorMatrizA.getText());
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
