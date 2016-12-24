/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Innocent
 */
public class MakhlukTest {
    
    public MakhlukTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of setdeltaX method, of class Makhluk.
     */
    @Test
    public void testSetdeltaX() {
        System.out.println("setdeltaX");
        int newx = 0;
        Makhluk instance = new MakhlukImpl();
        instance.setdeltaX(newx);
    }

    /**
     * Test of setdeltaY method, of class Makhluk.
     */
    @Test
    public void testSetdeltaY() {
        System.out.println("setdeltaY");
        int newy = 0;
        Makhluk instance = new MakhlukImpl();
        instance.setdeltaY(newy);
    }

    /**
     * Test of setKekuatan method, of class Makhluk.
     */
    @Test
    public void testSetKekuatan() {
        System.out.println("setKekuatan");
        int newkekuatan = 0;
        Makhluk instance = new MakhlukImpl();
        instance.setKekuatan(newkekuatan);
    }

    /**
     * Test of setShape method, of class Makhluk.
     */
    @Test
    public void testSetShape() {
        System.out.println("setShape");
        char c = ' ';
        Makhluk instance = new MakhlukImpl();
        instance.setShape(c);
    }

    /**
     * Test of addIdGlobal method, of class Makhluk.
     */
    @Test
    public void testAddIdGlobal() {
        System.out.println("addIdGlobal");
        Makhluk instance = new MakhlukImpl();
        instance.addIdGlobal();
        
    }

    /**
     * Test of setId method, of class Makhluk.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int newid = 0;
        Makhluk instance = new MakhlukImpl();
        instance.setId(newid);
        assertEquals(newid,instance.getId());
    }

    /**
     * Test of getIdGlobal method, of class Makhluk.
     */
    @Test
    public void testGetIdGlobal() {
        System.out.println("getIdGlobal");
        Makhluk instance = new MakhlukImpl();
        int expResult = 0;
        int result = instance.getIdGlobal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Makhluk.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Makhluk instance = new MakhlukImpl();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getX method, of class Makhluk.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Makhluk instance = new MakhlukImpl();
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getY method, of class Makhluk.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Makhluk instance = new MakhlukImpl();
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getdeltaX method, of class Makhluk.
     */
    @Test
    public void testGetdeltaX() {
        System.out.println("getdeltaX");
        Makhluk instance = new MakhlukImpl();
        int expResult = 0;
        int result = instance.getdeltaX();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getdeltaY method, of class Makhluk.
     */
    @Test
    public void testGetdeltaY() {
        System.out.println("getdeltaY");
        Makhluk instance = new MakhlukImpl();
        int expResult = 0;
        int result = instance.getdeltaY();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getKekuatan method, of class Makhluk.
     */
    @Test
    public void testGetKekuatan() {
        System.out.println("getKekuatan");
        Makhluk instance = new MakhlukImpl();
        int expResult = 0;
        int result = instance.getKekuatan();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getShape method, of class Makhluk.
     */
    @Test
    public void testGetShape() {
        System.out.println("getShape");
        Makhluk instance = new MakhlukImpl();
        char expResult = '\0';
        char result = instance.getShape();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setX method, of class Makhluk.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int newx = 0;
        Makhluk instance = new MakhlukImpl();
        instance.setX(newx);
        
    }

    /**
     * Test of setY method, of class Makhluk.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int newy = 0;
        Makhluk instance = new MakhlukImpl();
        instance.setY(newy);
        
    }

    /**
     * Test of compare method, of class Makhluk.
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        Makhluk m = null;
        Makhluk instance = new MakhlukImpl();
        boolean expResult = false;
        boolean result = instance.compare(m);
        assertEquals(expResult, result);
        
    }

    public class MakhlukImpl extends Makhluk {
    }
    
}
