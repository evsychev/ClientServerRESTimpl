/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.database;

import java.math.BigDecimal;

/**
 *
 * @author sychev
 */
public class Payment {
    
    private String accountDebet;
    private String accountCredet;
    private BigDecimal sum;
    
    public Payment(String accountDebet, String accountCredet, BigDecimal sum) {
        
        setAccountDebet( accountDebet );
        setAccountCredet( accountCredet );
        setSum( sum );
    }

    public String getAccountDebet() {
        return accountDebet;
    }
    public void setAccountDebet(String accountDebet) {
        this.accountDebet = accountDebet;
    }

    public String getAccountCredet() {
        return accountCredet;
    }
    public void setAccountCredet(String accountCredet) {
        this.accountCredet = accountCredet;
    }

    public BigDecimal getSum() {
        return sum;
    }
    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
    
}