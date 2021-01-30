/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * Esta clase resuelve un sistema de ecuaciones utilizando el método Gauss-Jordan
 * @version 1.2
 * @author Montserrat Bustamante Rentería
 */
public class SistemaEcuaciones {

    private static float[][] pivote(float matriz[][], int pivote, int variable){
        float temp = matriz[pivote][pivote];
        
        for (int i=0; i < (variable+1); i++) {
            matriz[pivote][i] = matriz[pivote][i] / temp;
        }           
        return matriz;
    }

    private static float[][] hacerCeros(float matriz[][], int pivote, int variable){
        for (int i=0; i < variable; i++) {
            if (i != pivote) {
                float valor = matriz[i][pivote];
                for (int j=0; j < (variable+1); j++) {
                    matriz[i][j] = ((-valor)*matriz[pivote][j])+matriz[i][j];
                }
            }
        }
        return matriz;
    }

    public String resolverSistema(float[][] matriz, int variable) {
        int pivote = 0;
        for (int i = 0; i < variable; i++) {
            pivote(matriz, pivote, variable);
            hacerCeros(matriz, pivote, variable);
            pivote++;
        }  
        String respuesta = "";
        for (int i = 0; i < variable; i++) {
            respuesta += "La variable X" + (i + 1) + " es: " + matriz[i][variable] + "\n";
        }
        return respuesta;
    }
    
}
