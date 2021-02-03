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
public class EcuacionesCramerTest {
    
    public EcuacionesCramerTest() {
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
     * Test of resolverSistema method, of class EcuacionesCramer.
     */
    @Test
    public void testResolverSistema() {
        System.out.println("resolverSistema");
        double[][] matrizA = {{3,1,2},{5,5,4},{2,6,6}};
        double[] matrizB = {3,5,2};
        EcuacionesCramer instance = new EcuacionesCramer();
        String expResult = "La variable X1 es: 1.0\n" +
        "La variable X2 es: 0.0\n" +
        "La variable X3 es: 0.0\n";
        String result = instance.resolverSistema(matrizA, matrizB);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
}
