package com.wkgao.solitaire;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Desc 项目启动程序
 * @Author wkGao
 * @EnableTransactionManagement 开启事务
 * @MapperScan("com.wkgao.solitaire.mvc.dao") 此处已替换为mapper的扫描注解
 */
@SpringBootApplication
//
//@MapperScan("com.wkgao.solitaire.mvc.dao") //替换mybatis的扫描注解
@MapperScan(basePackages = "com.wkgao.solitaire.mvc.dao")
public class SolitaireApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolitaireApplication.class, args);
        System.out.println("Solitaire项目已启动");
    }
}
