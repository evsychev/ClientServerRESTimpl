/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.client;

import com.Command;
import com.Https;
import com.company.server.Server;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sychev
 */
public class Browser {
    
    private Https https;
    ConcreteClient client;
    
    public Browser(ConcreteClient client) {
        
        this.client = client;
        
        https = new Https();
    }
    
    public String connectToServer(Server server, Command command) {
        
        https.request(server, command);
        
        try {
            String respinse = https.response( client, server ).getInfo();
            
            System.out.println( respinse );
            return respinse;
        } catch (InterruptedException ex) {
            Logger.getLogger( Browser.class.getName() ).log( Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
