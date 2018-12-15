package com.wkgao.solitaire.mvc.service.impl;

import com.wkgao.solitaire.mvc.dao.DemoMapper;
import com.wkgao.solitaire.mvc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    //@Transactional
    public int insert(Object object) {
        return demoMapper.insert();
    }
}
