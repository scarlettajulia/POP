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
public class ListMakhlukTest {
    
    public ListMakhlukTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of isListEmpty method, of class ListMakhluk.
     */
    @Test
    public void testIsListEmpty() {
        System.out.println("isListEmpty");
        ListMakhluk instance = new ListMakhluk();
        boolean expResult = true;
        boolean result = instance.isListEmpty();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of neff method, of class ListMakhluk.
     */
    @Test
    public void testNeff() {
        System.out.println("neff");
        ListMakhluk instance = new ListMakhluk();
        int expResult = 0;
        int result = instance.neff();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of search method, of class ListMakhluk.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        Makhluk m = null;
        ListMakhluk instance = new ListMakhluk();
        int expResult = -1;
        int result = instance.search(m);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of insert method, of class ListMakhluk.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Makhluk m = null;
        ListMakhluk instance = new ListMakhluk();
        instance.insert(m);
        
    }

    /**
     * Test of delete method, of class ListMakhluk.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int i = 0;
        ListMakhluk instance = new ListMakhluk();
        instance.delete(i);
        
    }

    /**
     * Test of get method, of class ListMakhluk.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int i = 0;
        ListMakhluk instance = new ListMakhluk();
        Makhluk expResult = null;
        Makhluk result = instance.get(i);
        assertEquals(expResult, result);
        
    }
    
}
