package com.der.miutisourceb.config.aop;

import com.der.miutisourceb.config.DatabaseContextHolder;
import com.der.miutisourceb.enums.DatabaseType;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author K0790016
 **/
@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.der.miutisourceb.annotation.Master) " +
            "&& (execution(* com.der.miutisourceb.service..*.select*(..)) " +
            "|| execution(* com.der.miutisourceb.service..*.get*(..)))" +
            "|| execution(* com.der.miutisourceb.service..*.find*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.der.miutisourceb.annotation.Master) " +
            "|| execution(* com.der.miutisourceb.service..*.insert*(..)) " +
            "|| execution(* com.der.miutisourceb.service..*.add*(..)) " +
            "|| execution(* com.der.miutisourceb.service..*.update*(..)) " +
            "|| execution(* com.der.miutisourceb.service..*.edit*(..)) " +
            "|| execution(* com.der.miutisourceb.service..*.delete*(..)) " +
            "|| execution(* com.der.miutisourceb.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DatabaseContextHolder.setDatabaseType(DatabaseType.SLAVE);
    }

    @Before("writePointcut()")
    public void write() {
        DatabaseContextHolder.setDatabaseType(DatabaseType.MASTER);
    }

}
