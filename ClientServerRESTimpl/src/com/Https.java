/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.company.server.Server;

/**
 *
 * @author sychev
 */
public class Https {
    
    private Command responce;
    
    public void request(Server server, Command command) {
        server.addCommand( command );
    }
    
    public Command response(Client client, Server server) throws InterruptedException {
        
        Command response = null;
        
        while (response == null) {
            response = server.getResponse( client );
            
            Thread.sleep(1000);
        }
        
        return response;
    }
    
}