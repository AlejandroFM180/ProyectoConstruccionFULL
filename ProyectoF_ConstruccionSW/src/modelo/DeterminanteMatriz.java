/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * Esta clase calcula la determinante de una matriz
 * @author 
 */
public class DeterminanteMatriz {
    /*
     * Este método realiza el cálculo de la determinante de la matriz
     * @param matriz Matriz de números de tipo double
     * @return determinante Número de tipo double
    */
    public double Determinante(double[][] matriz){
        double determinante = 0;        
        
        switch(matriz.length){
            case 1:
                determinante = matriz[0][0];
                break;
            case 2:            
                determinante= (matriz[0][0]*matriz[1][1])-(matriz[0][1]*matriz[1][0]);                        
                break;
            case 3:
                determinante= (matriz[0][0]*matriz[1][1]*matriz[2][2]) + 
                              (matriz[1][0]*matriz[2][1]*matriz[0][2]) +
                              (matriz[2][0]*matriz[0][1]*matriz[1][2]) -
                              (matriz[2][0]*matriz[1][1]*matriz[0][2]) -
                              (matriz[0][0]*matriz[2][1]*matriz[1][2]) -
                              (matriz[1][0]*matriz[0][1]*matriz[2][2]);
                break;
            case 4:       
                for (int filaMatrizOriginal = 0; filaMatrizOriginal < matriz[0].length; filaMatrizOriginal++) {
                    double[][] nuevaMatriz=new double[matriz.length-1][matriz[0].length-1];
                    
                    for(int fila=1; fila<matriz.length; fila++){
                            for(int columna=0; columna<matriz[0].length; columna++){
                                if(columna<filaMatrizOriginal){
                                    nuevaMatriz[fila-1][columna]=matriz[fila][columna];
                                }
                                else if(columna>filaMatrizOriginal){
                                    nuevaMatriz[fila-1][columna-1]=matriz[fila][columna];                                
                                }                                                    
                            }
                    }
                    determinante += matriz[0][filaMatrizOriginal]*Math.pow(-1, (double)filaMatrizOriginal) * Determinante(nuevaMatriz);                                        
                }                
        }
        return determinante;                        
    }    
}