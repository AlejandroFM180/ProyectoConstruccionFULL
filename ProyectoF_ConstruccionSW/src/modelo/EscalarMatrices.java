/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * Esta clase contiene todos los métodos para realizar la multiplicación de una matriz por un escalar.
 * @version 1.2
 * @author Montserrat Bustamante Rentería
 */
public class EscalarMatrices {
    
    /*
     * Realiza la multiplicación de una matriz por un escalar. 
     * Toma la matriz del parámetro y multiplica cada uno de sus elementos por el escalar.
     * @param matriz Una matriz de números enteros.
     * @param escalar Un número entero.
     * @return matrizResultado Matriz de números enteros resultado de matriz * escalar
    */
    public int[][] escalarMatriz(int[][] matriz , int escalar) {
        int[][] matrizResultado;
        int numFilas = matriz.length;
        int numColumnas = matriz[0].length;
        
        matrizResultado = new int[numFilas][numColumnas];
        // Llena matrizResultado con el resultado de la multiplicacion de cada elemento de la matriz original por el escalar.
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                matrizResultado[i][j] = matriz[i][j] * escalar;
            }
        }
        
        return matrizResultado;
    }

    /*
     * Este método imprime la matriz resultante de la multiplicación de matriz por escalar
     * @param matrizTittle 
     * @param matriz Matriz resultante de la multiplicación
    */
    private void imprimeMatriz (String matrizTittle, int[][] matriz){
        int filas = matriz.length;
        int columnas = matriz[0].length;
        System.out.println(matrizTittle);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + "   ");
            }
            System.out.println("");
        }
    }
    
}
