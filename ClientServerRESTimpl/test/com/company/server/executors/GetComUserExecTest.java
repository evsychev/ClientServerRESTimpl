/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.server.executors;

import com.Command;
import static com.RequestType.GET;
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
public class GetComUserExecTest {
    
    public GetComUserExecTest() {}
    
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
     * Test of apply method, of class GetComUserExec.
     */
    @Test
    public void testApply() {
        
        Command t = new Command( "SomeName", GET, "/com/user", "1      ");
        GetComUserExec instance = new GetComUserExec();
        Command result = instance.apply(t);
        
        assertEquals( "GetComUserExec response : 500.30", result.getInfo() );
        
    }
    
}
