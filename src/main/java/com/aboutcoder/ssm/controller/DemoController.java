package com.aboutcoder.ssm.controller;

import com.aboutcoder.ssm.service.IDemoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <Description>
 * Copyright © 2006-2016 Tuniu Inc. All rights reserved.<br />
 *
 * @author chenjinlong<br />
 * @CreateDate 1/13/16 12:20 AM<br />
 * @description <br />
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private IDemoService demoService;

    /**
     * 访问路径: http://localhost:8080/ssm/demo/index?id=1
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String toIndex(HttpServletRequest request, HttpServletResponse response, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        String str = demoService.getTextString();
        model.addAttribute("textString", str);
        System.out.println("request = [" + request + "], response = [" + response + "]");
        return "demo";
    }
}
