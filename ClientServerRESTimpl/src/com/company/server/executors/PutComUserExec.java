/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.server.executors;

import com.Command;
import com.company.database.Database;
import com.company.database.Payment;
import java.math.BigDecimal;
import java.util.function.UnaryOperator;

/**
 *
 * @author sychev
 */
public class PutComUserExec implements UnaryOperator<Command> {

    @Override
    public Command apply(Command t) {
        
        
        Database database = Database.getConnection();
        
        String key = t.getInfo().substring(0, 6).trim();
        String accountDebet = t.getInfo().substring(6, 27);
        String accountCredet = t.getInfo().substring(27, 48);
        BigDecimal sum = BigDecimal.valueOf( Double.valueOf( t.getInfo().substring(48) ) );
        
        String result = database.update(key, new Payment( accountDebet, accountCredet, sum ) ) ? "PUT OK" : "PUT FALSE";
        
        return new Command(t.getClientName(), t.getTypeRequest(), t.getUrl(), "PutComUserExec response : " + result);
    }
    
}
