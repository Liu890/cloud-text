package com.boss.soft.consumer.mvc;

import com.boss.soft.consumer.service.IConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 86430
 */
@Controller
public class ConsumerController {
    @Autowired
    private IConsumerService consumerService;
    
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return consumerService.hello();
    }
}
