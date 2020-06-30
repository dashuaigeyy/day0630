package com.yy.service.impl;

import com.yy.entity.PowerBean;
import com.yy.entity.RoleBean;
import com.yy.mapper.RoleMapper;
import com.yy.service.RoleService;
import org.aspectj.weaver.Lint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    public List<RoleBean> findAll() {
        return roleMapper.findAll();
    }

    public List<RoleBean> getRoleByDeptid(Integer deptid) {
        return roleMapper.findAllByid(deptid);
    }

    public RoleBean findAllByrid(Integer rid) {
        return roleMapper.findAllByrid(rid);
    }

    public void updateRole(Integer rid, Integer[] deptids) {
        if(rid!=null){
                if(deptids!=null&&deptids.length>=1){
                    for (Integer deptid : deptids) {
                        roleMapper.updateRole(rid, deptid);
                    }

                }
        }
    }

    public List<PowerBean> toRolePower(Integer rid) {

            List<PowerBean> list = roleMapper.getPowerList();
            List<Integer> ids = roleMapper.getIdsByRid(rid);
            if(ids!=null&&ids.size()>=1){
                if(list!=null&&list.size()>=1){
                    for (Integer id : ids) {
                        for (PowerBean pb : list) {
                            if(id.equals(pb.getId())){
                                pb.setChecked(true);
                                break;
                            }
                        }
                    }
                }
            }

        return list;

    }

    public void saveRolepower(Integer rid, String ids) {
        roleMapper.deleteRolePowerByRid(rid);
        String[] sid = ids.split(",");
        for (String s : sid) {
            roleMapper.insertRolePower(rid,s);
        }
    }


}
