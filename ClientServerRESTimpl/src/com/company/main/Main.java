package com.company.main;

import com.Command;
import static com.RequestType.DELETE;
import static com.RequestType.GET;
import static com.RequestType.POST;
import com.company.client.ConcreteClient;
import com.company.server.Server;

public class Main {

    private final static String databaseName = "TheBestDatabase";

    public static void main(String[] args) throws Exception {
        
        Server server = new Server();
        server.start();
        
        ConcreteClient client = new ConcreteClient( "MyNameIsClient" );
        client.request( server, new Command( GET, "/com/user", "1       ") );
        client.request( server, new Command( GET, "/com/user", "2       ") );
        client.request( server, new Command( POST, "/com/user", "12345 42601810900000000011 40801710900000000001 150000.23") );
        client.request( server, new Command( DELETE, "/com/user", "12345 42601810900000000011 40801710900000000001 3467") );
        
        server.stop();
    }

}