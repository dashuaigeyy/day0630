package com.yy.service.impl;
import com.yy.entity.*;
import com.yy.mapper.RoleMapper;
import com.yy.mapper.UserMapper;
import com.yy.service.UserService;
import com.yy.utils.jiexiba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
 @Autowired
    private UserMapper userMapper;
 @Autowired
 private RoleMapper roleMapper;
    public List<UserBean> findAll() {
        return userMapper.findAll();
    }
    public List<UserBean> findAll1() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<UserBean> list = userMapper.findAll();
        for (UserBean userBean : list) {
            Date parse = dateFormat.parse(userBean.getBirthday());
            System.out.println(parse+"123132");
        }
        return null;
    }

    public UserBean findByid(Integer id) {

        return userMapper.findByid(id);
    }

    public UserBean findByid1(Integer id) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            UserBean byid = userMapper.findByid(id);
            Date parse = dateFormat.parse(byid.getBirthday());
            System.out.println(byid.getBirthday());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<RoleBean> getRoleListByDeptid(UserBean userBean) {
        if(userBean!=null){
            if(userBean.getDeptBean()!=null&&userBean.getDeptBean().getDeptid()!=null){
                List<RoleBean> rlist = roleMapper.findAllByid(userBean.getDeptBean().getDeptid());
                return rlist;
            }

        }
        return null;
    }

    public void update(Integer id, Integer deptid, Integer rid) {
        userMapper.update(id, deptid, rid);
    }

    public List<UserBean> findUser() {
        return userMapper.findUser();
    }

    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }

    public void updateUser(UserBean userBean) {
        userMapper.updateUser(userBean);
    }

    public void saveUser(UserBean userBean) {
        userMapper.saveUser(userBean);
    }

    public UserBean getLogin(UserBean userBean) {
        if(userBean!=null){
            if(userBean.getUsername()!=null&&!"".equals(userBean.getUsername())){
                List<UserBean> login = userMapper.getLogin(userBean.getUsername());
                if(login.size()==1&&login!=null){
                    UserBean user = login.get(0);
                        if(user.getPassword().equals(userBean.getPassword())){
                                return user;
                        }
                }
            }
        }
        return null;
    }

    public List<PowerBean> getPowerListById(Integer id) {
        return userMapper.getPowerListById(id);
    }

    public QueryVo jiexi1(String str1) {

        return  jiexiba.jieXiStr1(str1);
    }

    public String jiexi2(String str2) {

        return  jiexiba.jieXiStr2(str2);
    }

    public String findAllxj(String queryVoCode, String code) {
        if("01".equals(queryVoCode)){
            RsBean rs = userMapper.findAllxy(code);
            return "<CONTENT><CARDNO>"+rs.getCardno()+"</CARDNO><MADEDATE>"+rs.getMadetime()+"</MADEDATE>生产日期<ADDRESS>"+rs.getAddress()+"</ADDRESS><PRICE>"+rs.getPrice()+"</PRICE></CONTENT>";
        }
        if("02".equals(queryVoCode)){
            RsBean rs = userMapper.findAlljs(code);
           return  "<CONTENT><CARDNO>"+rs.getCardno()+"</CARDNO><MADEDATE>"+rs.getMadetime()+"</MADEDATE>生产日期<ADDRESS>"+rs.getAddress()+"</ADDRESS><PRICE>"+rs.getPrice()+"</PRICE><VOL>"+rs.getVol()+"%</VOL></CONTENT>";
        }
    return null;
    }

    public String saveXJ(QueryVo qvo, String str2) {

        if("01".equals(qvo.getCode())){
            SmokeBean smokeBean = jiexiba.jieXiStr2Smoke(str2);
            try {
                if(smokeBean==null){
                  return "<MEG><CODE>0</CODE><CONTENT>参数2解析失败</CONTENT></MEG>";
                }else {
                    try {
                        userMapper.saveXY(smokeBean);
                        return "<MEG><CODE>1</CODE><CONTENT>保存成功了</CONTENT></MEG>";
                    } catch (Exception e) {
                        e.printStackTrace();
                        return "<MEG><CODE>0</CODE><CONTENT>失败</CONTENT></MEG>";
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if("02".equals(qvo.getCode())){
            WineBean wineBean = jiexiba.jieXiStr2Wine(str2);
            if(wineBean==null){
                return "<MEG><CODE>0</CODE><CONTENT>参数2解析失败</CONTENT></MEG>";
            }else {
                try {
                    userMapper.saveJS(wineBean);
                    return "<MEG><CODE>1</CODE><CONTENT>保存成功了</CONTENT></MEG>";
                } catch (Exception e) {
                    e.printStackTrace();
                    return "<MEG><CODE>0</CODE><CONTENT>失败</CONTENT></MEG>";
                }
            }      }
        return null;
    }

    public void saveStuQj2(ProcessBean pb) {

        pb.setQjstatus(0);
        userMapper.insertPorcess(pb);
        UserBean ub = userMapper.getUserById(pb.getSid());
        if(ub!=null&&ub.getGid()!=null){

            GradeBean gb= userMapper.getGradeByGid(ub.getGid());
            PmxBean pmxBean = new PmxBean();


            pmxBean.setPid(pb.getId());
            pmxBean.setStatus(0);
            pmxBean.setPstatus(1);
            pmxBean.setPshunxu(1);
            pmxBean.setUserid(gb.getTid());
            userMapper.insertProcessPmx(pmxBean);
            pmxBean.setPshunxu(2);
            pmxBean.setPstatus(0);
            pmxBean.setUserid(gb.getFid());

            userMapper.insertProcessPmx(pmxBean);

            if(pb.getQjtime()>1){
                pmxBean.setPshunxu(3);
                pmxBean.setUserid(12);

                userMapper.insertProcessPmx(pmxBean);

            }
            if(pb.getQjtime()>3){
                pmxBean.setPshunxu(4);
                pmxBean.setUserid(11);

                userMapper.insertProcessPmx(pmxBean);
            }
        }


    }

    public List<QjVo> getStuQjListBySid(Integer sid) {
//        根据学生的id查询部分vo
        List<QjVo> list = userMapper.getStuQjListBySid(sid);
    //遍历查询出来的学生 把他们放进vo
        for (QjVo vo : list) {
            Integer qjstatus = vo.getQjstatus();

            Integer userid=0;
            if(qjstatus==0){

                vo.setStatusStr("正在审核中");

                userid = userMapper.getUserIdByPid(vo.getId());


            }else if(qjstatus==1){

                vo.setStatusStr("审核通过");

                userid = userMapper.getUserIdByPidMaxShunxu(vo.getId());
            }else{

                vo.setStatusStr("审核未通过");

                userid = userMapper.getUserIdByPidNopass(vo.getId());
            }
            QjVo vvo = userMapper.getUnameAndRnameById(userid);
            if(vvo!=null&&vvo.getUname()!=null){
                vo.setUname(vvo.getUname());
            }
                vo.setRname(vvo.getRname());


        }
        return list;
    }

    public List<QjVo> getQjshListByUserid(Integer id) {
        List<Integer> pids = userMapper.getPidsByUserid(id);
        List<QjVo> list = null;
        if(pids!=null&&pids.size()>=1){
            list = new ArrayList<QjVo>();
            for (Integer pid : pids) {
                /**
                 * 先按照流程id去查询流程表里面有的信息
                 */
                QjVo vo = userMapper.getProcessById(pid);
                /**
                 * 查询出来的vo中，只有学生的id，没有学生名字和班级的名字
                 * 又要去查询这个学生的另外两个字段
                 */
                QjVo voo = userMapper.getStuInfoBySid(vo.getSid());
                vo.setUname(voo.getUname());
                vo.setGname(voo.getGname());
                list.add(vo);
            }
        }
        return list;
    }

    public void saveWdsh(Integer pid, Integer shstatus, Integer id) {



    }

}
