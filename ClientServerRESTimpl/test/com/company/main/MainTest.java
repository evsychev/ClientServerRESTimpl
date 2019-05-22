/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;

import com.Command;
import static com.RequestType.DELETE;
import static com.RequestType.GET;
import static com.RequestType.POST;
import com.company.client.ConcreteClient;
import com.company.server.Server;
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
public class MainTest {
    
    public MainTest() {
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
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() throws Exception {
        
        Server server = new Server();
        server.start();
        
        ConcreteClient client = new ConcreteClient( "MyNameIsClient" );
        String result = client.request( server, new Command( GET, "/com/user", "1          ") );
        assertEquals( "GetComUserExec response : 500.30", result);
        
        result = client.request( server, new Command( GET, "/com/user", "2            ") );
        assertEquals( "GetComUserExec response : 1500.74", result );
        
        result = client.request( server, new Command( POST, "/com/user", "12345 42601810900000000011 40801710900000000001 150000.23") );
        assertEquals( "PostComUserExec response : POST OK", result );
        
        result = client.request( server, new Command( DELETE, "/com/user", "12345 42601810900000000011 40801710900000000001 3467") );
        assertEquals( "DeleteComUserExec response : DELETE OK", result );
        
        server.stop();
        
    }
    
}