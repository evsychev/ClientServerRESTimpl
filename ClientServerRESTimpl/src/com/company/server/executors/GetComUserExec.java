/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.server.executors;

import com.Command;
import com.company.database.Database;
import com.company.database.Payment;
import java.math.RoundingMode;
import java.util.function.UnaryOperator;

/**
 *
 * @author sychev
 */
public class GetComUserExec implements UnaryOperator<Command> {

    @Override
    public Command apply(Command t) {
        
        Database database = Database.getConnection();
        
        String key = t.getInfo().substring(0, 6).trim();
        
        Payment payment = database.select( key );
        
        return new Command(t.getClientName(), t.getTypeRequest(), t.getUrl(), "GetComUserExec response : " + payment.getSum().setScale(2, RoundingMode.DOWN) );
    }
    
}
