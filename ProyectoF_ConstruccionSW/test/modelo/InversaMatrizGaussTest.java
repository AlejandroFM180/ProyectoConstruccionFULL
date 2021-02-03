/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Victor, Jafet y Montserrat
 */
public class InversaMatrizGaussTest {
    
    public InversaMatrizGaussTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of obtenerInversa method, of class InversaMatrizGauss.
     */
    @Test
    public void testObtenerInversa() {
        System.out.println("obtenerInversa");
        double[][] matriz = {{1,0},{1,1}};
        InversaMatrizGauss instance = new InversaMatrizGauss();
        double[][] expResult = {{1,0},{-1,1}};
        double[][] result = instance.obtenerInversa(matriz);
        /*System.out.println(expResult.length);
        for (int i = 0; i < expResult.length; i++) {
            for (int j = 0; j < expResult.length; j++) {
                System.out.print(expResult[i][j] + "  ");
            }
            System.out.println("");
        }
        System.out.println(result.length);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j] + "  ");
            }
            System.out.println("");
        }*/
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of gaussJordan method, of class InversaMatrizGauss.
     */
    @Ignore
    public void testGaussJordan() {
        System.out.println("gaussJordan");
        double[][] matriz = null;
        int[] ordenPivote = null;
        InversaMatrizGauss.gaussJordan(matriz, ordenPivote);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invertirMatriz method, of class InversaMatrizGauss.
     */
    @Ignore
    public void testInvertirMatriz() {
        System.out.println("invertirMatriz");
        double[][] matriz = null;
        double[][] matrizIdentidad = null;
        int[] ordenPivote = null;
        int dimensionMatriz = 0;
        double[][] expResult = null;
        double[][] result = InversaMatrizGauss.invertirMatriz(matriz, matrizIdentidad, ordenPivote, dimensionMatriz);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
