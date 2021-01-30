
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * Esta clase realiza la multiplicación de dos matrices: A de dimensiones mxn y B de dimensiones nxp
 * @version 1.2
 * @author 
 */
public class MultiplicacionMatrices {

    /*
     * Realiza la multiplicación de las dos matrices
     * El número de filas de la segunda matriz debe ser igual al número de columnas de la primera matriz.
     * @param matrizA Matriz de números enteros.
     * @param matrizB Matriz de números enteros.
     * @return matrizResultado Resultado dem la multiplicación de ambas matrices.
    */
    public int[][] multiplicarMatriz(int[][] matrizA, int[][] matrizB) { 
        int filasA = matrizA.length;
        int columnasB = matrizB[0].length;  
        int[][] matrizResultado = new int[filasA][columnasB];

        int columnasA = matrizA[0].length;
        int filasB = matrizB.length;
        if (columnasA == filasB) {
            for (int i = 0; i < filasA; i++) {
                for (int j = 0; j < columnasB; j++) {
                    for (int h = 0; h < matrizA[0].length; h++) {
                        matrizResultado[i][j] += matrizA[i][h] * matrizB[h][j];
                    }
                }
            }
            return matrizResultado;
        } else {
            System.out.println("Los rangos de las matrices son incorrectos");
            return null;
        }
    }
    
}
