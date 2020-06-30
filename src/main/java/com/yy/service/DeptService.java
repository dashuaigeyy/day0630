package com.yy.service;

import com.yy.entity.DeptBean;

import java.util.List;

public interface DeptService {
    List<DeptBean> findAll();

    DeptBean findByid(Integer deptid);

    void saveDeptRole(Integer deptid, Integer[] rids);
}
