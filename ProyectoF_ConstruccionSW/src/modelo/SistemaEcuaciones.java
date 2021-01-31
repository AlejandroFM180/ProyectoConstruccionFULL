/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * Esta clase resuelve un sistema de ecuaciones utilizando el método Gauss-Jordan
 * @version 1.2
 * @author Montserrat, Jafet y Victor
 */
public class SistemaEcuaciones {
    /*
     * Esta función genera el privote que se utilizará para la resolucion del sistema de ecuaciones con el método Gauss-Jordan
    */
    private static float[][] pivote(float matriz[][], int pivote, int variable){
        float temp = matriz[pivote][pivote];
        
        for (int i=0; i < (variable+1); i++) {
            matriz[pivote][i] = matriz[pivote][i] / temp;
        }           
        return matriz;
    }

    /*
     * Este método cambia a 0 el valor de una celda de la matriz como parte del procedimiento para resolver sistemas
     * de ecuaciones con el método Gauss-Jordan
     * @param matriz La matriz de números flotantes ingresada por el usuario
     * @param pivote Número entero 
     * @param variable Número entero
     * @return matriz Matriz con los ceros agregados
    */
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

    /*
     * Este método resuelve el sistema de ecuaciones con el método Gauss-Jordan
     * @param matriz La matriz de números flotantes ingresada por el usuario
     * @param variable 
     * @return respuesta Un String que contiene el resultado de la variable X
    */
    public String resolverSistema(float[][] matriz, int variable) {
        int pivote = 0;
        for (int i = 0; i < variable; i++) {
            pivote(matriz, pivote, variable);
            hacerCeros(matriz, pivote, variable);
            pivote++;
        }  
        String respuesta = "";
        for (int i = 0; i < variable; i++) {
            respuesta += "La variable x" + (i + 1) + " es: " + matriz[i][variable] + "\n";
        }
        return respuesta;
    }
    
}
