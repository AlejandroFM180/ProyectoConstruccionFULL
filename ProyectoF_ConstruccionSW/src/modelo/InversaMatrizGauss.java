package modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Esta clase calcula la inversa de una matriz de dimensiones nxn con el método Gauss-Jordan
 * @version 1.2
 * @author 
 */
public class InversaMatrizGauss {
    /*
     * 
    */
    public double[][] obtenerInversa(double matriz[][]) {
        
        int dimensionMatriz = matriz.length;
        double matrizIdentidad[][] = new double[dimensionMatriz][dimensionMatriz];
        for (int contadorFilas=0; contadorFilas<dimensionMatriz; contadorFilas++) {
            for (int contadorCol=0; contadorCol<dimensionMatriz; contadorCol++){
                if (contadorFilas == contadorCol) {
                    matrizIdentidad[contadorFilas][contadorCol] = 1;
                }      
            }     
        }
        
        int ordenPivote[] = new int[dimensionMatriz];
        gaussJordan(matriz, ordenPivote);
        double[][] matrizRespuesta = invertirMatriz(matriz, matrizIdentidad, ordenPivote, dimensionMatriz);

        return matrizRespuesta;
    }
    
    public static void gaussJordan(double matriz[][], int ordenPivote[]){
        int largoPivote = ordenPivote.length;
        double factorEscala[] = new double[largoPivote];
 

        for (int i=0; i<largoPivote; ++i) { 
            ordenPivote[i] = i;
        }
 
        for (int i=0; i<largoPivote; ++i) {
            double c1 = 0;
            for (int j=0; j<largoPivote; ++j) {
                double c0 = Math.abs(matriz[i][j]);
                if (c0 > c1) c1 = c0;
            }
            factorEscala[i] = c1;
        }
 
 
        int lugarPiv = 0;
        for (int posicionCol=0; posicionCol<largoPivote-1; posicionCol++) {
            double pivote = 0;
            for (int posicionFila=posicionCol; posicionFila<largoPivote; posicionFila++) {
                double tempPivoteCol = Math.abs(matriz[ordenPivote[posicionFila]][posicionCol]);
                tempPivoteCol /= factorEscala[ordenPivote[posicionFila]];
                if (tempPivoteCol > pivote) {
                    pivote = tempPivoteCol;
                    lugarPiv = posicionFila;
                }
            }
   
            int itmp = ordenPivote[posicionCol];
            ordenPivote[posicionCol] = ordenPivote[lugarPiv];
            ordenPivote[lugarPiv] = itmp;
            for (int i=posicionCol+1; i<largoPivote; i++) {
                double pj = matriz[ordenPivote[i]][posicionCol]/matriz[ordenPivote[posicionCol]][posicionCol];
                matriz[ordenPivote[i]][posicionCol] = pj;
 
                for (int l=posicionCol+1; l<largoPivote; ++l) {
                    matriz[ordenPivote[i]][l] -= pj*matriz[ordenPivote[posicionCol]][l];
                }
            }
        }
    }
    
    public static double[][] invertirMatriz(double matriz[][], double matrizIdentidad[][] , int ordenPivote[], int dimensionMatriz) {
        for (int contadorDimension=0; contadorDimension<dimensionMatriz-1; contadorDimension++) {
            for (int contDimension=contadorDimension+1; contDimension<dimensionMatriz; contDimension++) {
                for (int contDim=0; contDim<dimensionMatriz; contDim++) {
                    matrizIdentidad[ordenPivote[contDimension]][contDim]
                    	    -= matriz[ordenPivote[contDimension]][contadorDimension]*matrizIdentidad[ordenPivote[contadorDimension]][contDim];
                }
            }
        }

        double[][] matrizRespuesta = new double[dimensionMatriz][dimensionMatriz];
        for (int contDimension=0; contDimension<dimensionMatriz; contDimension++) {
            int tempDimensionMatriz= dimensionMatriz-2;
            matrizRespuesta[dimensionMatriz-1][contDimension] = matrizIdentidad[ordenPivote[dimensionMatriz-1]][contDimension]/matriz[ordenPivote[dimensionMatriz-1]][dimensionMatriz-1];
            for (int contadorInverso=tempDimensionMatriz; contadorInverso>=0; contadorInverso--) {
                matrizRespuesta[contadorInverso][contDimension] = matrizIdentidad[ordenPivote[contadorInverso]][contDimension];
                for (int contadorDim=contadorInverso+1; contadorDim<dimensionMatriz; contadorDim++) {
                    matrizRespuesta[contadorInverso][contDimension] -= matriz[ordenPivote[contadorInverso]][contadorDim]*matrizRespuesta[contadorDim][contDimension];
                }
                matrizRespuesta[contadorInverso][contDimension] /= matriz[ordenPivote[contadorInverso]][contadorInverso];
            }
        }
        
        return matrizRespuesta;
    }
}