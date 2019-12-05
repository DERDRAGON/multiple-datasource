package com.der.miutisourceb.service;

import com.der.miutisourceb.entity.Namespace;

import java.util.List;

/**
 * @author K0790016
 **/
public interface NamespaceService {

    /**
     * 查询所有
     * @return
     */
    List<Namespace> selectAll(String environment);
}
