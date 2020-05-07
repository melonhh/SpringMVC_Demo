package cn.melon.controller;

import cn.melon.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

//@SessionAttributes(types = {User.class})
@Controller
public class IndexController {
    //该注解能将http请求映射到控制器
    @RequestMapping({"/index", "/", ""}) //name 默认为类名大写：IC#index
    public String index(Model model) {
        model.addAttribute("test", "testView1");

        return "index"; // 返回对应的视图的文件
        // 没有后缀，因为后缀已经在springMVC.xml里配置了
    }


//    @RequestMapping(value = "/success", method = RequestMethod.POST)
//    public String success(@RequestParam(required = false) String username,@RequestParam(name="psd",defaultValue = "dwj123") String password) {
//        System.out.println(username + ":" + password);
//        return "success";
//    }
//
//    @RequestMapping("addUser")
//    public String addUser(@ModelAttribute User user,Model map) {
//        map.addAttribute("user", user);
//        return "success";
//    }
//
//    @RequestMapping("/testMV")
//    public ModelAndView testMV() {
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("name","小白");
//        mv.setViewName("success");
//        return mv;
//    }
//
//    @RequestMapping("/testMV2")
//    public String testMV2(Map<String, Object> map) {
//        map.put("name", "melon");
//        map.put("melon", new User());
//        return "success";
//    }
//
//    @RequestMapping("/testMV3")
//    public String testMV3(Model model) {
//        model.addAttribute("name", "melon");
//        return "success";
//    }
//
//    @ModelAttribute
//    public void testModelAttribute(Model map) {
//        User user = new User();
//        user.setUsername("jk");
//        user.setPassword("12345");
//        map.addAttribute("user", user);
//    }


}


// @RequestMapping参数
// value（别名path）， method
// value适用三种通配符 ： ？任意一个字符  *匹配任意多个字符  **匹配任意路径

// consumes(请求的类型），produces(如果浏览器能响应该类型则响应）

// params（指定request中必须包含某些参数，否则NO）params={“name”，“password!=10”}
// headers（指定request中必须包含某些首部行信息）

// name（springMVC4.0）  默认为类大写字母组合+#+方法名

