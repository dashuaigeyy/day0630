package com.yy.service.impl;

import com.yy.entity.PowerBean;
import com.yy.mapper.PowerMapper;
import com.yy.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerServiceImpl implements PowerService {
    @Autowired
    private PowerMapper powerMapper;
    public List<PowerBean> findAll() {
        return powerMapper.findAll();
    }
}
