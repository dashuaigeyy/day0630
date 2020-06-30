package com.yy.service.impl;

import com.yy.entity.DeptBean;
import com.yy.mapper.DeptMapper;
import com.yy.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    public List<DeptBean> findAll() {
        return deptMapper.findAll();
    }

    public DeptBean findByid(Integer deptid) {
        return deptMapper.findByid(deptid);
    }

    public void saveDeptRole(Integer deptid, Integer[] rids) {

        if(deptid!=null){
            deptMapper.update(deptid);
            if(rids!=null&&rids.length>=1){
                for (Integer rid : rids) {
                    deptMapper.updates(deptid,rid);
                }
            }
        }
    }

}
