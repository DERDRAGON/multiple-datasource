package com.der.mutisourcea.master.dao;

import com.der.mutisourcea.master.entity.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}