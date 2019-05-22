/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.server.executors;

import com.Command;
import com.company.database.Database;
import java.util.function.UnaryOperator;

/**
 *
 * @author sychev
 */
public class DeleteComUserExec implements UnaryOperator<Command> {

    @Override
    public Command apply(Command t) {
        
        Database database = Database.getConnection();
        
        String key = t.getInfo().substring(0, 6).trim();
        
        String result = database.delete( key ) ? "DELETE OK" : "DELETE FALSE";
        
        return new Command(t.getClientName(), t.getTypeRequest(), t.getUrl(), "DeleteComUserExec response : " + result );
    }
    
}