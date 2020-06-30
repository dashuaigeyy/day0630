package com.yy.service;

import com.yy.entity.*;

import java.text.ParseException;
import java.util.List;

public interface UserService {
    List<UserBean> findAll();
    UserBean findByid(Integer id);
    UserBean findByid1(Integer id);
    List<RoleBean> getRoleListByDeptid(UserBean userBean);
    void update(Integer id,Integer deptid,Integer rid);
    List<UserBean> findUser();
    void deleteUser(Integer id);
    void updateUser(UserBean userBean);
    void saveUser(UserBean userBean);
    List<UserBean> findAll1() throws ParseException;
    UserBean getLogin(UserBean userBean);
    List<PowerBean> getPowerListById(Integer id);


    QueryVo jiexi1(String str1);


    String jiexi2(String str2);

    String findAllxj(String queryVoCode, String code);

    String saveXJ(QueryVo qvo, String str2);

    void saveStuQj2(ProcessBean pb);

    List<QjVo> getStuQjListBySid(Integer sid);

    List<QjVo> getQjshListByUserid(Integer id);

    void saveWdsh(Integer pid, Integer shstatus, Integer id);
}
