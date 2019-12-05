package com.der.miutisourceb.service.impl;

import com.der.miutisourceb.config.DatabaseContextHolder;
import com.der.miutisourceb.dao.NamespaceMapper;
import com.der.miutisourceb.entity.Namespace;
import com.der.miutisourceb.enums.DatabaseType;
import com.der.miutisourceb.service.NamespaceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author K0790016
 **/
@Service
public class NamespaceServiceImpl implements NamespaceService {

    @Resource
    private NamespaceMapper namespaceMapper;

    private void setDataSourceByEnvironment(String environment){
        if (environment.equals(DatabaseType.MASTER.getName())){
            DatabaseContextHolder.setDatabaseType(DatabaseType.MASTER);
        }
        if (environment.equals(DatabaseType.SLAVE.getName())){
            DatabaseContextHolder.setDatabaseType(DatabaseType.SLAVE);
        }
    }

    @Override
    public List<Namespace> selectAll(String environment) {
        setDataSourceByEnvironment(environment);
        return namespaceMapper.selectAll();
    }
}
