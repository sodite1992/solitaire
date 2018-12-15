package com.wkgao.solitaire.mvc.controller;

import com.wkgao.solitaire.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Desc 进入首页
 * @Author wkGao
 */
@Controller
public class IndexController extends BaseController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("user", "admin");
        return "index";
    }




}
