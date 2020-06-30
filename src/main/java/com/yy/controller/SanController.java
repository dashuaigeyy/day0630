package com.yy.controller;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SanController {

    @RequestMapping(value = "doGetControllerOne")
    public void doGetControllerOne(){
        System.out.println("来啦");
    }

    @RequestMapping(value = "doGetControllerTwo")
    public void doGetControllerTwo(String name,Integer age){
        System.out.println(name+"来啦"+age);
    }

    @RequestMapping(value = "ceShiJie")
    public void ceShiJie(String str1,String str2){
        System.out.println(str1+str2);
    }


}
