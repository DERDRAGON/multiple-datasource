package com.der.miutisourceb.controller;

import com.der.miutisourceb.entity.Namespace;
import com.der.miutisourceb.service.NamespaceService;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author K0790016
 **/
@RestController
@RequestMapping("v2")
public class DemoController {

    @Resource
    private NamespaceService namespaceService;

    @RequestMapping("demo")
    public Map<String, Object> demo(@RequestParam(required = true) String environment) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("success", true);
        List<Namespace> namespaces = namespaceService.selectAll(environment);
        map.put("data", namespaces);
        return map;
    }
}
