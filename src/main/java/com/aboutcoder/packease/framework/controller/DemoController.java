package com.aboutcoder.packease.framework.controller;

import akka.actor.ActorRef;
import com.aboutcoder.packease.framework.component.akka.ActorGenerator;
import com.aboutcoder.packease.framework.domain.message.PrinterMsg;
import com.aboutcoder.packease.framework.domain.po.GuideBasic;
import com.aboutcoder.packease.framework.service.IDemoService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * <Description>
 * Copyright © 2006-2016 AboutCoder.COM. All rights reserved.<br />
 *
 * @author chenjinlong<br />
 * @CreateDate 1/13/16 12:20 AM<br />
 * @description <br />
 */
//@Controller
//@RequestMapping("/demo")
@RestController
public class DemoController {
    private final static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Resource
    private IDemoService demoService;

    /**
     * 访问路径: http://localhost:8080/index?id=1
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public String toIndex(HttpServletRequest request, HttpServletResponse response, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        String str = demoService.getTextString();
        model.addAttribute("textString", str);
        System.out.println("request = [" + request + "], response = [" + response + "]");
        return "demo";
    }

    @RequestMapping(value = "/json1", method = RequestMethod.GET)
    public @ResponseBody Object getJSON1(Model model) {
        model.addAttribute("items", new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
        }});
        model.addAttribute("status", 0);

        System.out.println("model = [" + model + "]");
        return model;
    }

    @RequestMapping(value = "/json2", method = RequestMethod.GET)
    public List<String> getJSON2()
    {
        List<String> listOfCountries = new ArrayList<String>(){{
            add("a");
            add("b");
            add("c");
        }};

        // To test logback integration.
        logger.info("test logback integration. --- chenjinlong");

        return listOfCountries;
    }

    @RequestMapping(value = "/json3", method = RequestMethod.GET)
    public GuideBasic getJSON3()
    {
        GuideBasic guideBasic = new GuideBasic();
        guideBasic.setId(11111);
        return guideBasic;
    }

    @RequestMapping(value = "/json4/{id}", method = RequestMethod.GET)
    public GuideBasic getJSON4(@PathVariable int id, @RequestHeader HttpHeaders headers)
    {
        GuideBasic guideBasic = new GuideBasic();
        guideBasic.setId(id);
        return guideBasic;
    }

    /**
     * 访问路径: http://localhost:8080/db
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/db", method = RequestMethod.GET)
    public GuideBasic toDb(HttpServletRequest request, HttpServletResponse response, Model model){
        GuideBasic guideBasic = demoService.getDbRows(1);
        model.addAttribute("textString", JSON.toJSONString(guideBasic));
        System.out.println("request = [" + request + "], response = [" + response + "]");
        return guideBasic;
    }

    /**
     * 访问路径: http://localhost:8080/akka
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @Resource
    private ActorGenerator actorGenerator;
    @RequestMapping(value = "/akka", method = RequestMethod.GET)
    public void akka(HttpServletRequest request, HttpServletResponse response, Model model){
        int a = 1;

        try {
            ActorRef actorRef1 = actorGenerator.createUniqueActor("printerActor", "printerActorName");
            ActorRef actorRef2 = actorGenerator.createUniqueActor("printerActor", "printerActorName");
            PrinterMsg printerMsg = new PrinterMsg(99, "hello world.");
            actorRef1.tell(printerMsg, null);
            actorRef2.tell(printerMsg, null);
        } catch (Exception e) {
            logger.error("akka exception:", e);
        }

        int b = 2;
    }
}
