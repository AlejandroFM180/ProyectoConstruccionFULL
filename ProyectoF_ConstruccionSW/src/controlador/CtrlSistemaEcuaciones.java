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
import modelo.SistemaEcuaciones;
import vista.VistaOperaciones;

/**
 * Esta clase es el controlador de Sistema de Ecuaciones 
 * @author Victor, Montserrat y Jafet
 */
public final class CtrlSistemaEcuaciones implements ActionListener {

    private VistaOperaciones vo;
    private List<JTextField> valoresDeMatrizA;
    private int filas, columnas;

    /*
     * Prepara la vista de operaciones para realizar la resolución del sistema de ecuaciones.
    */
    public CtrlSistemaEcuaciones(VistaOperaciones vo) {
        this.vo = vo;
        valoresDeMatrizA = new ArrayList<>();

        adaptarDiseñoDeVista();

        vo.getjButtonRegresar().addActionListener(this);
        vo.getjButtonResolver().addActionListener(this);
        vo.getjButtonGenerarMatrices().addActionListener(this);
    }

    /*
     *  Este método genera la matriz para realizar el cálculo cuando se presiona el botón de Generar matrices.
     * Si se ingresan datos incorrectos (numeros o quedan espacios vacios), aparecera un mensaje de error.
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
     * Cambia el título de la vista a "Sistema de Ecuaciones (Gauss-Jordan)"
    */
    public void adaptarDiseñoDeVista() {
        vo.getjLabelTituloVista().setText("SISTEMA DE ECUACIONES (GAUSS-JORDAN)");
        vo.getColumnasMatrizA().setVisible(false);
        vo.getColumnasMatrizB().setVisible(false);
        vo.getFilasMatrizB().setVisible(false);
        vo.getjLabeMatrizB().setText("");
    }

    /*
     * Genera las celdas para llenar la matriz con las dimensiones establecidas.
    */
    public void generarMatrices() {
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
     * Vacía las celdas de la matriz.
    */
    public void limpiarMatrices() {
        vo.getPanelMatrizA().removeAll();
        valoresDeMatrizA.clear();
    }

    /*
     * Obtiene el valor de las filas y las columnas de la matriz establecidas por el usuario.
    */
    public void obtenerValoresFilasColumnas() {
        filas = 1;
        columnas = 1;
        try {
            filas = Integer.parseInt(vo.getFilasMatrizA().getSelectedItem().toString());
            columnas = filas + 1;
        } catch (NumberFormatException e) {
        }
    }

    /*
     * Si el valor de las variables existe, se desplegará en una ventana emergente y se imprimirá dentro de la caja de texto de resultado.
    */
    public void imprimirResultado(String valorDeVariables) {
        if(valorDeVariables != ""){
            JOptionPane.showMessageDialog(vo, valorDeVariables);
        }
        vo.getjTextAreaResultado().setText(valorDeVariables);
    }

    /*
     * Obtiene los valores ingresados en las celdas y los almacena en la matriz A, convierte los datos a entero y 
     * llama a la función de la clase SistemaEcuaciones que realiza el cálculo.
     * @return valorDeVariables Un string
    */
    public String resolverSistema() {
        float[][] matrizA = new float[filas][columnas];
        int i = 0, j = 0;
        for (JTextField valorMatrizA : valoresDeMatrizA) {
            if (j == columnas) {
                i++;
                j = 0;
            }
            matrizA[i][j] = Float.parseFloat(valorMatrizA.getText());
            j++;
        }

        String valorDeVariables;
        int numeroDeVariables = filas;
        SistemaEcuaciones sistema = new SistemaEcuaciones();
        valorDeVariables = sistema.resolverSistema(matrizA, numeroDeVariables);
        return valorDeVariables;
    }
}
