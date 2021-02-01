/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;

/**
 * Esta clase realiza la resolución de un sistema de ecuaciones utilizando el método de Cramer
 * @author Victor, Montserrat y Jafet
 */
public class EcuacionesCramer {

    /*
     * Realiza la resolución del sistema de ecuaciones
     * @param matrizA Una matriz de números de tipo double
     * @param b Una matriz de números de tipo double
     * @return respuesta Un string que contiene el resultado
    */
    public String resolverSistema(double[][] matrizA, double matrizB[]) {
        double Rcramer[] = new double[matrizB.length];
        DeterminanteMatriz dm = new DeterminanteMatriz();
        double determinante = dm.Determinante(matrizA);
        double detTemp;
        double matrizC[][] = new double[matrizA.length][matrizA.length];
        String respuesta = "";

        /*
        Verificamos que tenga solucion:
        "Si el determinante de la matriz de ecuaciones original es 0
        entonces, no tiene solucion"
         */
        if (determinante == 0) {
            respuesta = "No tiene solución";
            return respuesta;
        }

        
        for (int i = 0; i < matrizA.length; i++) {
            matrizC = sustituir(matrizA, matrizB, i);

            detTemp = dm.Determinante(matrizC);

            Rcramer[i] = (float) detTemp / (float) determinante;
        }

        for (int i = 0; i < Rcramer.length; i++) {
            respuesta += "La variable X" + (i + 1) + " es: " + Rcramer[i] + "\n";
        }

        return respuesta; //Retorna el String de soluciones de Xn
    }

    /*
     * Realiza la resolución del sistema de ecuaciones
     * @param matrizA Una matriz de números de tipo double
     * @param matrizB Una matriz de números de tipo double
     * @posicion int 
     * @return c Una matriz de números de tipo double
    */
    private double[][] sustituir(double[][] matrizA, double[] matrizB, int posicion) {
        //vector en donde se almacenaran los nuevos valores
        double matrizC[][] = new double[matrizA.length][matrizA.length];

        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                if (j == posicion) {
                    matrizC[i][j] = matrizB[i];
                } else {
                    matrizC[i][j] = matrizA[i][j];
                }

            }

        }

        return matrizC;
    }

}
