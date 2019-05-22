/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.server.executors;

import com.Command;
import static com.RequestType.DELETE;
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
public class DeleteComUserExecTest {
    
    public DeleteComUserExecTest() {
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
     * Test of apply method, of class DeleteComUserExec.
     */
    @Test
    public void testApply() {
        
        Command t = new Command( "SomeName", DELETE, "/com/user", "3     42601810900000000011 40801710900000000013 150000.23");
        DeleteComUserExec instance = new DeleteComUserExec();
        Command result = instance.apply(t);
        
        assertEquals( "DeleteComUserExec response : DELETE OK", result.getInfo() );
        
        result = instance.apply(t);
        assertEquals( "DeleteComUserExec response : DELETE FALSE", result.getInfo() );
    }
    
}
