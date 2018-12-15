package com.wkgao.solitaire.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestfulController {

    @RequestMapping(value = "/api/city", method = RequestMethod.GET) //查询
    public void findAllCity() {
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.POST) //增加
    public void createCity(@RequestBody Model model) {
        //用实体类接收参数
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.PUT) //修改
    public void modifyCity(@RequestBody Model model) {

    }

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)  //删除
    public void modifyCity(@PathVariable("id") Long id) {
        //接收指定路径参数
    }
}
