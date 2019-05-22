package com.company.database;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Database {

    private static volatile Database database;
    private Map<String, Payment> trn;
    
    
    private Database() {
        dataInitialize();
    }
    
    public static Database getConnection() {
        
        if ( database == null ) {
            synchronized ( Database.class ) {
                if ( database == null )
                    database = new Database();
            }
        }
        
        return database;
    }

    private void dataInitialize() {
        // transaction wasn't realize for simplification code
        trn = new HashMap<String, Payment>();
        
        insert("1", new Payment("42601810900000000001", "40801710900000000001", new BigDecimal(500.3) ));
        insert("2", new Payment("42601810900000000002", "40801710900000000002", new BigDecimal(1500.74) ));
        insert("3", new Payment("42601810900000000003", "40801710900000000003", new BigDecimal(2500.63) ));
        insert("4", new Payment("42601810900000000004", "40801710900000000004", new BigDecimal(220.34) ));
        insert("5", new Payment("42601810900000000005", "40801710900000000005", new BigDecimal(20.13) ));
        insert("6", new Payment("42601810900000000006", "40801710900000000006", new BigDecimal(110.72) ));
        insert("7", new Payment("42601810900000000007", "40801710900000000007", new BigDecimal(333.43) ));
    }
    
    public Payment select(String key) {
        if ( trn.containsKey( key ) )
            return trn.get( key );
        return null;
    }
    
    public boolean insert(String key, Payment value) {
        return trn.putIfAbsent(key, value) == null ? true : false;
    }
    
    public boolean update(String key, Payment value) {
        return trn.replace(key, value) == null ? false : true;
    }
    
    public boolean delete(String key) {
        return trn.remove(key) == null ? false : true;
    }
    
    public int size() {
        return trn.size();
    }
    
}