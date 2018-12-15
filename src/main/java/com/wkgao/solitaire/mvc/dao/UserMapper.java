package com.wkgao.solitaire.mvc.dao;

import com.wkgao.solitaire.core.PublicMapper;
import com.wkgao.solitaire.mvc.entity.User;

import java.util.List;

public interface UserMapper extends PublicMapper<User> {

    public List<User> findAll();

}
