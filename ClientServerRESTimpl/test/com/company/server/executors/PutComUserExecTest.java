/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.server.executors;

import com.Command;
import static com.RequestType.PUT;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author sychev
 */
public class PutComUserExecTest {
    
    public PutComUserExecTest() {
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
     * Test of apply method, of class PutComUserExec.
     */
    @Test
    public void testApply() {
        
        Command t = new Command( "testApply", PUT, "/com/user", "1     42601810900000000011 40801710900000000013 150000.23");
        PutComUserExec instance = new PutComUserExec();
        Command result = instance.apply(t);
        
        assertEquals( "PutComUserExec response : PUT OK", result.getInfo() );
        
        result = instance.apply(t);
        assertEquals( "PutComUserExec response : PUT OK", result.getInfo() );
        
//        t = new Command( "SomeName", PUT, "/com/user", "123   42601810900000000011 40801710900000000013 150000.23");
//        result = instance.apply(t);
//        assertEquals( "PutComUserExec response : PUT FALSE", result.getInfo() );
        
    }
    
}