package com.der.miutisourceb.config;

import com.der.miutisourceb.enums.DatabaseType;

/**
 * @author K0790016
 **/
public class DatabaseContextHolder {

    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<>();

    public static void setDatabaseType(DatabaseType type){
        contextHolder.set(type);
    }

    public static DatabaseType getDatabaseType(){
        return contextHolder.get();
    }
}
