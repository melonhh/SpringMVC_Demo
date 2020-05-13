package cn.melon.controller;

import cn.melon.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {


    @RequestMapping(value = "/index{id}")
    public String index(@PathVariable("id") int id) {
        System.out.println(id);
        return "index";
    }

    @RequestMapping(value = "/index/{s:[a-z]\\+}-{v:\\d\\.\\d\\.\\d")
    public String index(@PathVariable("s") String s, @PathVariable("v") String v) {
        System.out.println(s + "-" + v);
        return "index";
    }

    @RequestMapping(value = "/success", method = RequestMethod.POST)
    public String success(@RequestParam(required = false, name = "username") String username, @RequestParam(name = "psd", defaultValue = "dwj123") String password) {
        System.out.println(username + ":" + password);
        return "success";
    }

    @RequestMapping("/ModelAndView")
    public ModelAndView test1() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("model", "model");

        modelAndView.setViewName("index");

        return modelAndView;
    }


}