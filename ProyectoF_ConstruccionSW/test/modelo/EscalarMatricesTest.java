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
public class EscalarMatricesTest {
    
    public EscalarMatricesTest() {
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
     * Test of escalarMatriz method, of class EscalarMatrices.
     */
    @Test
    public void testEscalarMatriz() {
        System.out.println("escalarMatriz");
        int[][] matriz = {{3,4,5},{4,5,2},{1,4,5}};
        int escalar = 5;
        EscalarMatrices instance = new EscalarMatrices();
        int[][] expResult = {{15,20,25},{20,25,10},{5,20,25}};
        int[][] result = instance.escalarMatriz(matriz, escalar);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
}
