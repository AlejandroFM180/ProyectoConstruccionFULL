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
import modelo.EscalarMatrices;
import vista.VistaOperaciones;

/**
 * Clase controladora de EscalarMatrices
 * @author Montserrat, Jafet y Victor
 */
public final class CtrlEscalarMatrices implements ActionListener {

    private VistaOperaciones vo;
    private List<JTextField> valoresDeMatrizA;
    private JTextField escalar;
    private int filas, columnas;

    /*
     * Prepara la vista de operaciones para realizar la multiplicación de matrices por escalar.
    */
    public CtrlEscalarMatrices(VistaOperaciones vo) {
        this.vo = vo;
        valoresDeMatrizA = new ArrayList<>();
        escalar = new JTextField();

        adaptarDiseñoDeVista();

        vo.getjButtonRegresar().addActionListener(this);
        vo.getjButtonResolver().addActionListener(this);
        vo.getjButtonGenerarMatrices().addActionListener(this);
    }

    /*
     * Este método genera la matriz y la celda del escalar para realizar la multiplicación cuando se presiona el botón de Generar matrices.
     * Si se ingresan datos incorrectos (numeros o quedan espacios vacios), aparecera un mensaje de error.
    */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (vo.getjButtonGenerarMatrices() == ae.getSource()) {
            generarMatrices();
        }
        if (vo.getjButtonResolver() == ae.getSource()) {
            try {
                imprimirResultado(resolverEscalar());
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
     * Cambia el título de la vista a "Multiplicación de una matriz por escalar"
    */
    public void adaptarDiseñoDeVista() {
        vo.getjLabelTituloVista().setText("MULTIPLICACIÓN DE UNA MATRIZ POR ESCALAR");
        vo.getColumnasMatrizB().setVisible(false);
        vo.getFilasMatrizB().setVisible(false);
        vo.getjLabeMatrizB().setText("Escalar");
    }

    /*
     * Genera las celdas para llenar la matriz con las dimensiones establecidas y una celda para el escalar. Almacena los valores ingresados 
     * por el usuario en ambos.
    */
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
        }

        escalar = new JTextField("escalar");
        escalar.setPreferredSize(new Dimension(40, 40));
        escalar.setText("");
        vo.getPanelMatrizB().add(escalar);
        vo.getPanelMatrizB().updateUI();
    }

    /*
     * Vacía las celdas de la matriz.
    */
    public void limpiarMatrices() {
        vo.getPanelMatrizA().removeAll();
        valoresDeMatrizA.clear();
        vo.getPanelMatrizB().removeAll();
    }

    /*
     * Obtiene el valor de las filas y las columnas de la matriz establecidas por el usuario.
    */
    public void obtenerValoresFilasColumnas() {
        filas = 1;
        columnas = 1;
        try {
            filas = Integer.parseInt(vo.getFilasMatrizA().getSelectedItem().toString());
            columnas = Integer.parseInt(vo.getColumnasMatrizA().getSelectedItem().toString());
        } catch (NumberFormatException e) {
        }
    }

    /*
     * Imprime el resultado de la multiplicación y lo despliega en la caja de texto de resultado.
    */
    public void imprimirResultado(double[][] matrizResultante) {
        vo.getjTextAreaResultado().setText("");
        String resultado = "";
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado += "          " + String.format("%.2f", matrizResultante[i][j]) + "  ";
            }
            resultado += "\n";
        }
        vo.getjTextAreaResultado().setText(resultado);
    }

    /*
     * Obtiene los valores ingresados en las celdas y los almacena en la matriz A y obtiene
     * el valor del escalar ingresado en la celda, convierte los datos a entero y 
     * llama a la función de la clase EscalarMatrices que realiza la multiplicación.
     * @return matrizResultante Una matriz de números enteros
    */
    public double[][] resolverEscalar() {
        double[][] matrizA = new double[filas][columnas];
        int i = 0, j = 0;
        for (JTextField valorMatrizA : valoresDeMatrizA) {
            if (j == columnas) {
                i++;
                j = 0;
            }
            matrizA[i][j] = Double.parseDouble(valorMatrizA.getText());
            j++;
        }

        double[][] matrizResultante;
        double valorEscalar = Double.parseDouble(escalar.getText());
        EscalarMatrices escalar = new EscalarMatrices();
        matrizResultante = escalar.escalarMatriz(matrizA, valorEscalar);
        return matrizResultante;
    }
}
