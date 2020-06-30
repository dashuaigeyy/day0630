package com.yy.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 创作时间：2020/4/7 10:49
 * 作者：李增强
 */
public class UserBean {

    private Integer id;
    private String username;
    private String password;
    private Integer age;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")/
    private String birthday;
    private Integer gid;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



    private DeptBean deptBean=new DeptBean();
    private  RoleBean roleBean=new RoleBean();


    public RoleBean getRoleBean() {
        return roleBean;
    }

    public void setRoleBean(RoleBean roleBean) {
        this.roleBean = roleBean;
    }

    public DeptBean getDeptBean() {
        return deptBean;
    }

    public void setDeptBean(DeptBean deptBean) {
        this.deptBean = deptBean;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                ", gid=" + gid +
                ", deptBean=" + deptBean +
                ", roleBean=" + roleBean +
                '}';
    }

}
