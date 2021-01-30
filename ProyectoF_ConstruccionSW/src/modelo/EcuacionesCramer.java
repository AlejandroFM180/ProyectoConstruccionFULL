/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author VictorEnrique
 */
public class EcuacionesCramer {

    public String resolverSistema(double[][] a, double b[]) {
        double Rcramer[] = new double[b.length];
        DeterminanteMatriz dm = new DeterminanteMatriz();
        double det = dm.Determinante(a);
        double detTemp;
        double c[][] = new double[a.length][a.length];
        String respuesta = "";

        /*
        Verificamos que tenga solucion:
        "Si el determinante de la matriz de ecuaciones original es 0
        entonces, no tiene solucion"
         */
        if (det == 0) {
            respuesta = "No tiene solución";
            return respuesta;
        }

        
        for (int i = 0; i < a.length; i++) {
            c = sustituye(a, b, i);

            detTemp = dm.Determinante(c);

            Rcramer[i] = (float) detTemp / (float) det;
        }

        for (int i = 0; i < Rcramer.length; i++) {
            respuesta += "La variable X" + (i + 1) + " es: " + Rcramer[i] + "\n";
        }

        return respuesta; //Retorna el String de soluciones de Xn
    }

    private double[][] sustituye(double[][] a, double[] b, int pos) {
        //vector en donde se almacenaran los nuevos valores
        double c[][] = new double[a.length][a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (j == pos) {
                    c[i][j] = b[i];
                } else {
                    c[i][j] = a[i][j];
                }

            }

        }

        return c;
    }

}
