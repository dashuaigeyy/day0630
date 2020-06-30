package com.yy.controller;

import com.yy.entity.QueryVo;
import com.yy.entity.UserBean;
import com.yy.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "jiexi")
    public  String jiexi(String str1,String str2){
        System.out.println(str1);
        System.out.println(str2);
      QueryVo vo= userService.jiexi1(str1);
      if(vo==null){
          return "<result><MEG><CODE>0</CODE></MEG></result>";

      }else {
          UserBean userBean=new UserBean();
          userBean.setUsername(vo.getUname());
          userBean.setPassword(vo.getPwd());
          UserBean login = userService.getLogin(userBean);
          if(login==null){
              return "<result><MEG><CODE>1</CODE></MEG></result>";
          }else {
             String jie2= userService.jiexi2(str2);
                if(jie2==null){
                    return "<result><MEG><CODE>0</CODE></MEG></result>";
                }else {
                    vo.setCardno(jie2);
                }
          }

      }
        return null;
    }

}
