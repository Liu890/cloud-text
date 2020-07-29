package com.boss.soft.provider.mvc;

import com.boss.soft.provider.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 86430
 * @date 2020/07/29 13:25
 */
@Controller
public class HelloController {
    @Autowired
    private IHelloService helloService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return helloService.hello();
    }
}
