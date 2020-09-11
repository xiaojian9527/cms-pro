package com.cms.service.impl;

import com.cms.dao.mapper.ITestMapper;
import com.cms.service.api.ITestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServiceImpl implements ITestService {

    @Resource
    private ITestMapper testMapper;

    @Override
    public int count() {
        return testMapper.count();
    }
}
