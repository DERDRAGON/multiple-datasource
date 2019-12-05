package com.der.mutisourcea.controller;

import com.der.mutisourcea.master.dao.AppnamespaceMapper;
import com.der.mutisourcea.master.entity.Appnamespace;
import com.der.mutisourcea.second.dao.NamespaceMapper;
import com.der.mutisourcea.second.entity.Namespace;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author K0790016
 **/
@RestController
@RequestMapping("v1")
public class DemoController {

    @Resource
    private AppnamespaceMapper appnamespaceMapper;

    @Resource
    private NamespaceMapper namespaceMapper;

    @RequestMapping("demo")
    public Map<String, Object> demo() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("success", true);
        List<Appnamespace> appnamespaces = appnamespaceMapper.selectAll();
        map.put("data", appnamespaces);
        List<Namespace> namespaces = namespaceMapper.selectAll();
        map.put("data2", namespaces);
        return map;
    }

}
