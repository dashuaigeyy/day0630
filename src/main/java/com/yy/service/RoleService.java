package com.yy.service;

import com.yy.entity.PowerBean;
import com.yy.entity.RoleBean;

import java.util.List;

public interface RoleService {
    List<RoleBean> findAll();
    List<RoleBean> getRoleByDeptid(Integer deptid);
    RoleBean  findAllByrid(Integer rid);

    void updateRole(Integer rid, Integer[] deptids);

    List<PowerBean> toRolePower(Integer rid);

    void saveRolepower(Integer rid, String ids);
}
