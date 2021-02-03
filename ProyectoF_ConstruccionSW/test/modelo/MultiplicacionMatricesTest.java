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
public class MultiplicacionMatricesTest {
    
    public MultiplicacionMatricesTest() {
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
     * Test of multiplicarMatriz method, of class MultiplicacionMatrices.
     */
    @Test
    public void testMultiplicarMatriz() {
        System.out.println("multiplicarMatriz");
        int[][] matrizA = {{2,3},{2,3},{2,3}};
        int[][] matrizB = {{2,2,2},{3,3,3}};
        MultiplicacionMatrices instance = new MultiplicacionMatrices();
        int[][] expResult = {{13,13,13},{13,13,13},{13,13,13}};
        int[][] result = instance.multiplicarMatriz(matrizA, matrizB);
        System.out.println(expResult.length);
        /*for (int i = 0; i < expResult.length; i++) {
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
    
}
