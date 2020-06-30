package com.yy.mapper;

import com.yy.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<UserBean> findAll();
    List<UserBean>   findUser();
    UserBean findByid(@Param("id") Integer id);
    void update(@Param("id") Integer id,@Param("deptid")Integer deptid,@Param("rid")Integer rid);
    void deleteUser(Integer id);
    void updateUser(UserBean userBean);
    void saveUser(UserBean userBean);
    List<UserBean> getLogin(@Param("username") String username);
    List<PowerBean> getPowerListById(@Param("id") Integer id);
   RsBean findAlljs(String cardno);
   RsBean findAllxy(String cardno);

    void saveXY(SmokeBean smokeBean);

    void saveJS(WineBean wineBean);

    void insertPorcess(ProcessBean pb);

    GradeBean getGradeByGid(Integer id);

    UserBean getUserById(Integer sid);

    void insertProcessPmx(PmxBean pmxBean);

    List<QjVo> getStuQjListBySid(Integer sid);

    Integer getUserIdByPid(Integer id);

    Integer getUserIdByPidMaxShunxu(Integer id);

    Integer getUserIdByPidNopass(Integer id);

    QjVo getUnameAndRnameById(Integer userid);

    List<Integer> getPidsByUserid(Integer id);

    QjVo getProcessById(Integer pid);

    QjVo getStuInfoBySid(Integer sid);
}
