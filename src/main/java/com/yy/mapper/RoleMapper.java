package com.yy.mapper;

import com.yy.entity.PowerBean;
import com.yy.entity.RoleBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    List<RoleBean> findAll();
    List<RoleBean>  findAllByid(Integer deptid);
    RoleBean  findAllByrid(Integer rid);
    void updateRole(@Param("rid") Integer rid, @Param("deptid") Integer deptid);
    List<PowerBean> getPowerList();

    List<Integer> getIdsByRid(@Param("rid") Integer rid);
    void deleteRolePowerByRid(@Param("rid") Integer rid);

    void insertRolePower(@Param("rid") Integer rid, @Param("sid") String sid);


}
