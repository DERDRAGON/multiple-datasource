package com.der.multipledatasource.master.dao;

import com.der.multipledatasource.master.entity.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}