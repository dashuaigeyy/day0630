package com.yy.mapper;

import com.yy.entity.DeptBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
    List<DeptBean> findAll();
    DeptBean findByid(Integer deptid);
    void update(Integer deptid);
    void updates(@Param("deptid") Integer deptid, @Param("rid")Integer rid);
}
