package com.company.server;

import com.Client;
import com.Command;

import java.util.*;
import java.util.concurrent.*;

public class Server {

    private Queue<Command> queueTasks;

    private List<Process> processes;
    private ExecutorService service;
    
    private Map<String, Command> responses;
    
    private CommandExecutor executor;
    
    public Server() {
        initialize();
    }

    private void initialize() {

        queueTasks = new ConcurrentLinkedQueue<Command>();
        responses = new ConcurrentHashMap<String, Command>();
        
        processes = new ArrayList<Process>();
        processes.add( new Process("1") );
        processes.add( new Process("2") );
        
        service = Executors.newCachedThreadPool();
        
        executor = new CommandExecutor();
        
    }

    public void start() {
        
        processes.forEach( p -> service.submit( p ) );

    }
    
    public void stop() throws InterruptedException {

        while ( !queueTasks.isEmpty() ) {
            Thread.sleep( 2000 );
        }
        processes.forEach( p -> p.setState( false ));
        service.shutdown();
    }

    public void addCommand(Command command) {
        queueTasks.add( command );
    }

    public Command getResponse(Client client) {
        
        if (responses.containsKey( client.getName() )) {
            Command result = responses.get( client.getName() );
            responses.remove( client.getName() );
            return result;
        }
        
        return null;
    }
    
    private void addResponse(Command response) {
        responses.put(response.getClientName(), response);
    }

    private class Process implements Callable<Command> {

        private String name;

        private boolean state;

        Process (String name) {
            this.name = name;
            setState( true );
        }

        @Override
        public Command call() throws Exception {
            System.out.println("Start process " + name);
            
            Command response = null;
            
            while ( isState() ) {
                
                Optional<Command> RESTcommand = Optional.ofNullable(queueTasks.poll());
                
                if ( RESTcommand.isPresent() ) {
                    response = executor.apply( RESTcommand.get() );
                    addResponse( response );
                }
                Thread.sleep(1000 );
            }

            return response;
        }

        public void setState(boolean state) {
            this.state = state;
        }

        public boolean isState() {
            return state;
        }
    }

}