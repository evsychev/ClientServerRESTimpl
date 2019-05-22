package com.company.client;

import com.Client;
import com.Command;
import com.company.server.Server;

public class ConcreteClient implements Client {
    
    String name;
    
    private Browser browser;
    
    public ConcreteClient(String name) {
        
        this.name = name;
        
        browser = new Browser( this );
    }

    public String request(Server server, Command command) throws InterruptedException {
        
        command.setClientName( name );
        String response = browser.connectToServer(server, command);
        
        return response;
    }

    @Override
    public String getName() {
        return name;
    }

}