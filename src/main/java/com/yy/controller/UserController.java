package com.yy.controller;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.regexp.internal.RE;
import com.yy.entity.*;
import com.yy.service.DeptService;
import com.yy.service.PowerService;
import com.yy.service.RoleService;
import com.yy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Component(value="s")
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PowerService powerService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private RoleService roleService;


    @RequestMapping("/toStuQj")
    public String toStuQj(HttpServletRequest request, Model model) {
        UserBean ub = (UserBean) request.getSession().getAttribute("ub");
        model.addAttribute("stu", ub);
        return "stu_qj";
    }

    @RequestMapping("/saveStuQj2")
    public String saveStuQj2(ProcessBean pb) {
        /**
         * 接下来则么处理，开始走我们的业务流程，三个流程，属于业务型的代码，所以我们可以全部在sevice层搞定
         */

        userService.saveStuQj2(pb);
        return "redirect:getStuJtList.do";
    }


    //    下面旧项目
    @RequestMapping(value = "getDataInterface")
    public String getDataInterface(String str1, String str2) {
        QueryVo queryVo = userService.jiexi1(str1);
        if (queryVo != null) {
            UserBean userBean = new UserBean();
            userBean.setUsername(queryVo.getUname());
            userBean.setPassword(queryVo.getPwd());
            UserBean login = userService.getLogin(userBean);
            if (login != null) {
                String s = userService.jiexi2(str2);
                String rs = userService.findAllxj(queryVo.getCode(), s);
                if (rs != null) {
                    return "<result><MEG><CODE>3</CODE></MEG>" + rs + "</result>";
                } else {
                    return "<result><MEG><CODE>2</CODE></MEG></result>";
                }
            } else {
                return "<result><MEG><CODE>1</CODE></MEG></result>";
            }
        } else {
            return "<result><MEG><CODE>0</CODE></MEG></result>";
        }

    }


    @RequestMapping(value = "reciDataInterface")
    private String reciDataInterface(String str1, String str2) {
        QueryVo qvo = userService.jiexi1(str1);

        if (qvo == null) {
            return "<MEG><CODE>0</CODE><CONTENT>参数一解析失败</CONTENT></MEG>";
        } else {
            UserBean userBean = new UserBean();
            userBean.setUsername(qvo.getUname());
            userBean.setPassword(qvo.getPwd());
            UserBean login = userService.getLogin(userBean);
            if (login == null) {
                return "<MEG><CODE>0</CODE><CONTENT>账号或者密码错误</CONTENT></MEG>";
            } else {

                String s = userService.saveXJ(qvo, str2);
                return s;
            }

        }
    }

    @RequestMapping("/getStuJtList")
    public String getStuJtList(HttpServletRequest request, Model model) {
        /**
         * 需要把这个学生的情况请查询到，然后再去查询这个学的请假情况，我们先直接去去页面，发起请假
         */
        UserBean ub = (UserBean) request.getSession().getAttribute("ub");

        /**
         *   <th>编号</th>            流程表
         *   <th>请假时长</th>         流程表
         *   <th>请假时间</th>         流程表
         *   <th>开始时间</th>         流程表
         *   <th>结束时间</th>         流程表
         *   <th>角色</th>
         *   <th>操作者</th>
         *   <th>审批状态</th>
         */

        /**
         * 角色名称怎么出来，在流程表中，要查询这个流程有没有结束，
         * 要是结束了，我们需要去明细表中查询，是谁结束的这个流程
         *  通过的话，那就是顺序码最大的那个人的的用户id
         *  没有通过的话，我去查询谁的在明细表中，查询谁把我决绝的，操作的的id，查询他的审批码是2
         *  流程没有结束的情况下
         *  直接去明细表中，查询流程状态等于1的这个人就OK啦
         */

        /**
         * 我们写一个请假的vo然后需要什么数据就往里面扔里面就OK啦
         */

        /**
         * vo里面第一次只能查出来一部分字段，最好不要去联查，出来之后在判断查询
         */
        List<QjVo> list = userService.getStuQjListBySid(ub.getId());
        System.out.println(list);
        model.addAttribute("list", list);
        return "stuqj_list";
    }


    /**
     * 管理登录上来查询我的审核
     */

    @RequestMapping("/getQjShList")
    public String getQjShList(HttpServletRequest request,Model model){
        UserBean ub = (UserBean)request.getSession().getAttribute("ub");
        /**
         * 先拿着我的id去流程明细表中查询一下，有没有需要我审核的流程，有的话，再去流程表中把流程查出来，
         * 和学生是相反的，学生是先查流程，再查明细，老师是先查明细，再查流程
         * select pid from t_pmx a where a.pstatus =1 and userid=37 其实我就需要pid，查询流程id，因为我的页面展示的时候，
         * 我需要知道这个是谁请假的，请了多次时间，什么时候开始的，那个班级的
         */

        List<QjVo> list = userService.getQjshListByUserid(ub.getId());
        model.addAttribute("list", list);
        return "qjsh_list";
    }






    @RequestMapping("/saveWdsh")
    public String saveWdsh(HttpServletRequest request,Integer pid,Integer shstatus){
        UserBean ub = (UserBean)request.getSession().getAttribute("ub");
        userService.saveWdsh(pid,shstatus,ub.getId());
        return "redirect:getQjShList.do";
    }




    //查询所有的用户
    @RequestMapping(value = "findAll")
    public void findAll() {
        List<UserBean> all = userService.findAll();
        System.out.println(all);

    }

    //查询所有的用户信息（三表连接查询）
    @RequestMapping(value = "getUserList")
    public String getList(Model model) {
        List<UserBean> list = userService.findAll();
        model.addAttribute("list", list);
        return "user_list";

    }

    //ceshi
    @RequestMapping(value = "findByid1")
    public void findByid1(Integer id)  {
        UserBean byid1 = userService.findByid1(id);

    }
    //展示所有的界面信息
    @RequestMapping("/getPowerJson")
    public String getPowerJson(Model model, HttpServletRequest request) {
        UserBean ub = (UserBean) request.getSession(true).getAttribute("ub");
        if (ub != null) {
            List<PowerBean> list = userService.getPowerListById(ub.getId());
            Set<String> urls = new HashSet<String>();
            /**
             * 没有把list的大小固定，每次会自动去获取list的大小
             */
            for (int x = 0; x < list.size(); x++) {
                PowerBean pb = list.get(x);
                if (pb.getUrl() != null) {
                    urls.add(pb.getUrl().trim());
                }


                if ("是".equals(pb.getIsbutton())) {
                    list.remove(pb);
                    x--;//不会减角标，只能一部门
                }

            }
            request.getSession().setAttribute("urls", urls);
            String json = JSON.toJSONString(list);
            model.addAttribute("json", json);
        }
        return "left";
    }

    //去修改页面
    @RequestMapping("/toUserDeptRole")
    public String toUserDeptRole(Integer id, Model model){
            UserBean userBean = userService.findByid(id);
        List<DeptBean> dlist = deptService.findAll();
        //3、查询员工所在部门的拥有的全部角色，有可能这个员工目前还没有部门或者没有角色
        List<RoleBean> rlist = userService.getRoleListByDeptid(userBean);
        model.addAttribute("ub", userBean);
        model.addAttribute("dlist", dlist);
        model.addAttribute("rlist", rlist);
        return "user_deptrole";
    }
//提交修改员工信息
    @RequestMapping("/update")
    public String update(Integer id,Integer deptid,Integer rid){
        userService.update(id, deptid, rid);
        return "redirect:getUserList.do";
    }

//    这是二级联动 根据部门的id查当前本门下的角色
    @RequestMapping("/getRoleByDeptid")
    @ResponseBody
    public List<RoleBean> getRoleByDeptid(Integer deptid){
        List<RoleBean> roleByDeptid = roleService.getRoleByDeptid(deptid);
        return roleByDeptid;
    }
    //查询所有的部门出来
    @RequestMapping("/getDeptList")
    public String getDeptList(Model model){
        List<DeptBean> list = deptService.findAll();
        model.addAttribute("list",list);
        return "dept_list";
    }
    //查询所有的角色出来
    @RequestMapping("/getPower")
    public String getPower(Model model){
        List<RoleBean> list = roleService.findAll();
        model.addAttribute("list",list);
        return "role_list";
    }
    //查询角色的信息和所有部门
    @RequestMapping( "findAllByrid")
    public String findAllByrid(Model model,Integer rid){
        RoleBean rb = roleService.findAllByrid(rid);
        List<DeptBean> list = deptService.findAll();
        model.addAttribute("rb",rb);
        model.addAttribute("list",list);
        return "role_dept";
    }
//给角色修改部门
    @RequestMapping(value = "updateRole")
    public String updateRole(Integer[] deptids,Integer rid){
        roleService.updateRole(rid,deptids);
        return "redirect:getPower.do";
    }

    //查询所有角色的信息和用户已经选择当前部门的信息
    @RequestMapping("/findRole")
    public String findRole(Model model,Integer deptid){
        DeptBean db = deptService.findByid(deptid);
        List<RoleBean> list = roleService.findAll();
        List<RoleBean> rlist = roleService.getRoleByDeptid(db.getDeptid());

        model.addAttribute("list",list);
        model.addAttribute("rlist",rlist);
        model.addAttribute("db", db);
        return "dept_role";
    }

    @RequestMapping(value = "saveDeptRole")
    public String saveDeptRole(Integer deptid,Integer[] rids){
        deptService.saveDeptRole(deptid,rids);
        return "redirect:getDeptList.do";
    }
//去分配权限界面
    @RequestMapping(value = "toRolePower")
    public String toRolePower(Integer rid,Model model){
       List<PowerBean> list=roleService.toRolePower(rid);
        String json = JSON.toJSONString(list);
        model.addAttribute("json", json);
        model.addAttribute("rid", rid);
        return "role_quan";
    }
    //去分配权限界面
    @RequestMapping(value = "saveRolePower")
    public String saveRolePower(Integer rid,String ids){
        roleService.saveRolepower(rid,ids);
        return "redirect:getPower.do";
    }

    //登录验证
    //去分配权限界面
    @RequestMapping(value = "getLogin")
    public String getLogin(UserBean userBean, HttpServletRequest request){
        UserBean ub = userService.getLogin(userBean);
        if(ub!=null){
            request.getSession().setAttribute("ub", ub);
            return "main";
        }
        return "../../index";
    }


//    -----------------------------周末作业----------------------------
    @RequestMapping(value = "findUser")

    //全查
    public String findUser(Model model){

        List<UserBean> list = userService.findUser();
        model.addAttribute("list",list);



        return "user";
    }
    //单删
    @RequestMapping(value = "deleteUser")
    public String deleteUser(Integer id){
        userService.deleteUser(id);
        return "redirect:findUser.do";
    }
    //去修改
    @RequestMapping(value = "toupdateUser")
    public String toupdateUser(Integer id,Model model){
        UserBean us = userService.findByid(id);
        model.addAttribute("us", us);
        return "updateUser";
    }
    //修改
    @RequestMapping(value = "updateUser")
    public String updateUser(UserBean userBean){
        userService.updateUser(userBean);
        return "redirect:findUser.do";
    }
    //去添加
    @RequestMapping(value = "tosavaUser")
    public String tosavaUser(){
        return "savaUser";
    }
    //添加
    @RequestMapping(value = "saveUsers")
    public String saveUsers(UserBean userBean){
        userService.saveUser(userBean);
        return "redirect:findUser.do";
    }
//    @InitBinder
// public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//         dateFormat.setLenient(false);
//         binder.registerCustomEditor(UserBean.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
//    }
    }
