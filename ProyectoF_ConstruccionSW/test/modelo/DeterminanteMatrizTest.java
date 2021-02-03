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
public class DeterminanteMatrizTest {
    
    public DeterminanteMatrizTest() {
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
     * Test of Determinante method, of class DeterminanteMatriz.
     */
    @Test
    public void testDeterminante() {
        System.out.println("Determinante");
        double[][] matriz = {{3,4,5},{4,5,2},{1,4,5}};
        DeterminanteMatriz instance = new DeterminanteMatriz();
        double expResult = 34;
        double result = instance.Determinante(matriz);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
}
