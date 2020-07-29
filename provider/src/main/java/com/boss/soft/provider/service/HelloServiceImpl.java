package com.boss.soft.provider.service;

import org.springframework.stereotype.Service;

/**
 * @author 86430
 * @date 2020/07/29 13:20
 */
@Service
public class HelloServiceImpl implements IHelloService{
    @Override
    public String hello() {
        return "Hello,Eurekas";
    }
}
