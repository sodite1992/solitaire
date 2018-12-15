package com.wkgao.solitaire.mvc.entity;

import javax.validation.constraints.NotNull;

/**
 * @Desc Vue登录页面demo信息对象实体
 * @Date 2018/11/19 19:51
 * @Author wkGao
 */
public class VueLoginInfoVo {

    @NotNull(message="用户名不允许为空")
    private String username;

    @NotNull(message="密码不允许为空")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}