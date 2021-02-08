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

/**
 *
 * @author Victor, Jafet y Montserrat
 */
public class SumaMatricesTest {
    
    public SumaMatricesTest() {
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
     * Test of sumarMatriz method, of class SumaMatrices.
     */
    @Test
    public void testSumarMatriz() {
        System.out.println("sumarMatriz");
        double[][] matrizA = {{3,1},{5,5}};
        double[][] matrizB = {{2,2},{3,5}};
        SumaMatrices instance = new SumaMatrices();
        double[][] expResult = {{5,3},{8,10}};
        double[][] result = instance.sumarMatriz(matrizA, matrizB);
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
        fail("The test case is a prototype.");
    }
    
}
