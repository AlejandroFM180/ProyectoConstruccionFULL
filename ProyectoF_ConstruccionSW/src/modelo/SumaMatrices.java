/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * Esta clase realiza la suma de dos matrices
 * @version 1.2
 * @author pon tu nombre aqui
 */
public class SumaMatrices {
    /*
     * Este método toma dos matrices ingresadas por el usuario y las suma
     * @param matrizA Una matriz de tipo entero
     * @param matrizB Una matriz de tipo entero
     * @return matrizResultado Una matriz de tipo entero
    */
    public int[][] sumarMatriz(int[][] matrizA , int[][] matrizB) {
        int[][] matrizResultado;
        int numFilasA = matrizA.length;
        int numColumnasA = matrizA[0].length;

        int filasB = matrizB.length;
        int columnasB = matrizB[0].length;

        
        if (numFilasA==filasB && columnasB==numColumnasA) {

            matrizResultado = new int[numFilasA][numColumnasA];
            for (int i = 0; i < numFilasA; i++) {
                for (int j = 0; j < numColumnasA; j++) {
                    matrizResultado[i][j] = matrizA[i][j] + matrizB[i][j];
                }
            }

        } else {
            throw new Error("Las matrices deben tener la misma cantidad de filas que columnas");
        }
      
        
        return matrizResultado;
    }
    
    /*
     * Este método imprime la matriz resultante de la suma de ambas matrices
     * @param matrizTittle Un string
     * @param matriz La matriz de enteros resultante de la suma
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
