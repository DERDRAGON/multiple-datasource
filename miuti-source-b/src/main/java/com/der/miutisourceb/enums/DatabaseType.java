package com.der.miutisourceb.enums;

import lombok.Getter;

/**
 * @author K0790016
 **/
public enum DatabaseType {

    /**
     * 主数据源
     */
    MASTER("master", 1),
    /**
     * 第二数据源
     */
    SLAVE("slave",2)
    ;

    /**
     * 名称
     */
    @Getter
    private String name;

    /**
     * 顺序
     */
    @Getter
    private Integer sort;

    DatabaseType(String name, Integer sort) {
        this.name = name;
        this.sort = sort;
    }

}
