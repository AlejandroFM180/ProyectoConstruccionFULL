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
public class SistemaEcuacionesTest {
    
    public SistemaEcuacionesTest() {
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
     * Test of resolverSistema method, of class SistemaEcuaciones.
     */
    @Test
    public void testResolverSistema() {
        System.out.println("resolverSistema");
        float[][] matriz = {{3,1,2},{5,5,4}};
        int variable = 2;
        SistemaEcuaciones instance = new SistemaEcuaciones();
        String expResult = "La variable x1 es: 0.6\n" +
            "La variable x2 es: 0.19999996\n";
        String result = instance.resolverSistema(matriz, variable);
        /*System.out.println(expResult);
        System.out.println(result);*/
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult){
            fail("The test case is a prototype.");
        }
    }
    
}
