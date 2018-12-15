package com.wkgao.solitaire.mvc.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
public class FileUploadController {

    @Value("${file.upload.path}")
    private String path;

    // 允许上传的文件格式
    @Value("${file.upload.suffix}")
    private String fileUploadSuffix;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/toupload", method = RequestMethod.GET)
    public String toupload() {
        return "upload";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public void uploadFile(@RequestParam("file") MultipartFile file, HttpServletResponse response, HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("utf-8");
        //response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        JSONObject json=new JSONObject();
        PrintWriter writer = response.getWriter();
        try {

            // 获取文件后缀  例如：jpg
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

            // 文件类型校验
            if (fileUploadSuffix.toUpperCase().indexOf(suffix.toUpperCase()) == -1) {
                writer.write( "只允许上传图片或视频格式文件");
            }

            // 生成随机文件名
            String fileName = new SimpleDateFormat("yyyy/MM/dd/HH/").format(new Date()) + UUID.randomUUID().toString().trim().replaceAll("-", "") + "." + suffix;

            File destFile = new File(path + fileName);

            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            // 写入文件
            file.transferTo(destFile);

        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        writer.write( "上传成功！");
    }



}
