package com.wkgao.solitaire.mvc.controller;

import com.wkgao.solitaire.base.BaseController;
import com.wkgao.solitaire.mvc.dao.UserMapper;
import com.wkgao.solitaire.mvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc 登陆页面的controller
 * @Author wkGao
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private UserMapper userMapper;

    /**
     * @Desc 跳转登陆页面
     * @Date 2018/11/23 23:18
     */
    @RequestMapping(value = {"/login", "/login.html"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 登陆接口
     * @param username
     * @param password
     * @param rememberMe
     * @return 接口标准返回格式
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> ajaxLogin(String username, String password, Boolean rememberMe) {

        Map<String, Object> resultMap = new HashMap<>(3);
        resultMap.put("code", 200);
        resultMap.put("msg", "success");
        resultMap.put("data", null);

        List<User> userList = userMapper.selectAll();
        userList.forEach(System.out::println);

        return resultMap;
    }




}
