package com.der.miutisourceb.service.impl;

import com.der.miutisourceb.dao.NamespaceMapper;
import com.der.miutisourceb.entity.Namespace;
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

    @Override
    public List<Namespace> selectAll() {
        return namespaceMapper.selectAll();
    }
}
