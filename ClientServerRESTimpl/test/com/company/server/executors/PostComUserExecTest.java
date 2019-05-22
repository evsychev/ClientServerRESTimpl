/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.server.executors;

import com.Command;
import static com.RequestType.POST;
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
public class PostComUserExecTest {
    
    public PostComUserExecTest() {
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
     * Test of apply method, of class PostComUserExec.
     */
    @Test
    public void testApply() {
        
        Command t = new Command( "SomeName", POST, "/com/user", "46145 42601810900000000011 40801710900000000013 150000.23");
        PostComUserExec instance = new PostComUserExec();
        Command result = instance.apply(t);
        
        assertEquals( "PostComUserExec response : POST OK", result.getInfo() );
        
        result = instance.apply(t);
        assertEquals( "PostComUserExec response : POST FALSE", result.getInfo() );
    }
    
}
