package com.yy.entity;

public class DeptBean {
    private Integer deptid;
    private String dname;

    @Override
    public String toString() {
        return "DeptBean{" +
                "deptid=" + deptid +
                ", dname='" + dname + '\'' +
                '}';
    }

    public Integer getDeptid() {
        return deptid;
    }

    public String getDname() {
        return dname;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }


}
