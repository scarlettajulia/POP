/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Innocent
 */
public class BoardTest {
    
    public BoardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of PrintBoard method, of class Board.
     */
    @Test
    public void testPrintBoard() {
        System.out.println("PrintBoard");
        ListMakhluk L = new ListMakhluk();
        Predator P;
        P = new Predator(0,0);
        L.insert(P);
        String S = "System.out";
        Board instance = new Board(1,1,1);
        instance.PrintBoard(L, S);
        
    }

    /**
     * Test of getElementPapan method, of class Board.
     */
    @Test
    public void testGetElementPapan() {
        System.out.println("getElementPapan");
        int i = 0;
        int j = 0;
        int k = 0;
        Board instance = new Board(1,1,1);
        int expResult = -1;
        int result = instance.getElementPapan(i, j, k);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of GhostBusterMeetGhost method, of class Board.
     */
    @Test
    public void testGhostBusterMeetGhost() {
        System.out.println("GhostBusterMeetGhost");
        ArrayList<Integer> A = null;
        ListMakhluk L = null;
        Board instance = new Board(1,1,1);
        instance.GhostBusterMeetGhost(A, L);
        
    }

    /**
     * Test of isInVector method, of class Board.
     */
    @Test
    public void testIsInVector() {
        System.out.println("isInVector");
        int x = 0;
        ArrayList<Integer> v = new ArrayList<Integer>();
        Board instance = new Board(1,1,1);
        boolean expResult = false;
        boolean result = instance.isInVector(x, v);
        assertEquals(expResult, result);
        
    }
    
}
