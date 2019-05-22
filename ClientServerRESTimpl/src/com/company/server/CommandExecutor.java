/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.server;

import com.Command;
import static com.RequestType.DELETE;
import static com.RequestType.GET;
import static com.RequestType.POST;
import static com.RequestType.PUT;
import com.company.server.executors.DeleteComUserExec;
import com.company.server.executors.GetComUserExec;
import com.company.server.executors.PostComUserExec;
import com.company.server.executors.PutComUserExec;
import java.util.HashMap;
import java.util.Map;
import java.util.function.UnaryOperator;

/**
 *
 * @author sychev
 */
class CommandExecutor {
    
    private final Map<Command, UnaryOperator<Command>> executor;
    
    CommandExecutor() {
        executor = new HashMap<Command, UnaryOperator<Command> >();
        
        executor.put( new Command( GET, "/com/user", ""), new GetComUserExec() );
        executor.put( new Command( POST, "/com/user", ""), new PostComUserExec() );
        executor.put( new Command( PUT, "/com/user", ""), new PutComUserExec() );
        executor.put( new Command( DELETE, "/com/user", ""), new DeleteComUserExec() );
        
    }
    
    public Command apply(Command command) {
        
        if ( executor.containsKey( command ) ) {
            return executor.get( command ).apply( command );
        }
        
        return null;
    }
    
}