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
 * Clase controlador de MultiplicacionMatrices
 * @author Jafet, Montserrat y Victor
 */
public final class CtrlMultiplicacionMatrices implements ActionListener {

    private VistaOperaciones vo;
    private List<JTextField> valoresDeMatrizA, valoresDeMatrizB;
    private int filasA, columnasA, filasB, columnasB;

    /*
     * Prepara la vista de operaciones para realizar la multiplicación de matrices.
    */
    public CtrlMultiplicacionMatrices(VistaOperaciones vo) {
        this.vo = vo;
        valoresDeMatrizA = new ArrayList<>();
        valoresDeMatrizB = new ArrayList<>();

        adaptarDiseñoDeVista();

        vo.getjButtonRegresar().addActionListener(this);
        vo.getjButtonResolver().addActionListener(this);
        vo.getjButtonGenerarMatrices().addActionListener(this);
    }

    /*
     * Este método genera las matrices para realizar la multiplicación cuando se presiona el botón de Generar matrices.
     * Si se ingresan datos incorrectos (numeros o quedan espacios vacios), aparecera un mensaje de error.
    */
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

    /*
     * Cambia el título de la vista a "Multiplicación de matrices"
    */
    public void adaptarDiseñoDeVista() {
        vo.getjLabelTituloVista().setText("MULTIPLICACIÓN DE MATRICES");
        vo.getFilasMatrizB().setVisible(false);
    }

    /*
     * Genera las celdas para llenar las matrices con las dimensiones establecidas.
    */
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

    /*
     * Vacía las celdas de las matrices.
    */
    public void limpiarMatrices() {
        vo.getPanelMatrizA().removeAll();
        valoresDeMatrizA.clear();
        vo.getPanelMatrizB().removeAll();
        valoresDeMatrizB.clear();
    }

    /*
     * Obtiene el valor de las filas y las columnas de las matrices establecidas por el usuario.
    */
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

    /*
     * Imprime el resultado de la multiplicación y lo despliega en la caja de texto de resultado.
    */
    public void imprimirResultado(double[][] matrizResultante) {
        vo.getjTextAreaResultado().setText("");
        String resultado = "";
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                resultado += "          " + String.format("%.2f", matrizResultante[i][j]) + "  ";
            }
            resultado += "\n";
        }
        vo.getjTextAreaResultado().setText(resultado);
    }

    /*
     * Obtiene los valores ingresados en las celdas y los almacena en la matriz A  y la matriz B,
     * convierte los datos a entero y llama a la función de la clase MultiplicacionMatrices que realiza la multiplicación.
     * @return matrizResultante Una matriz de números enteros
    */
    public double [][] resolverMultiplicacion() {
        double[][] matrizA = new double[filasA][columnasA];
        int i = 0, j = 0;
        for (JTextField valorMatrizA : valoresDeMatrizA) {
            if (j == columnasA) {
                i++;
                j = 0;
            }
            matrizA[i][j] = Double.parseDouble(valorMatrizA.getText());
            j++;
        }

        double[][] matrizB = new double[filasB][columnasB];
        i = 0;
        j = 0;
        for (JTextField valorMatrizB : valoresDeMatrizB) {
            if (j == columnasB) {
                i++;
                j = 0;
            }
            matrizB[i][j] = Double.parseDouble(valorMatrizB.getText());
            j++;
        }

        double[][] matrizResultante;
        MultiplicacionMatrices multiplicacion = new MultiplicacionMatrices();
        matrizResultante = multiplicacion.multiplicarMatriz(matrizA, matrizB);
        return matrizResultante;
    }
}
