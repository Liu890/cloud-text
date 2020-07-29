package com.boss.soft.consumer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
/**
 * @author 86430
 */
@Service
public class ConsumerServiceImpl implements IConsumerService{
    /**
    * Spring Cloud Ribbon是基于Netflix
    * Ribbon实现了一套客户端负载均衡的工具
    * 它是一个基于HTTP和TCP客户端的负载均衡器
    * 它可以通过在客户端中配置ribbonServletList来设置服务端列表去轮询访问，以达到均衡负载的作用
    * */
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Override
    public String hello() {
        //封装了指定服务提供方的 IP、端口号等基本信息
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-provider");
        //要通过URL调用服务提供方，因此要拼URL
        StringBuffer url = new StringBuffer();
        url.append("http://").append(serviceInstance.getHost()).append(":").append(serviceInstance.getPort()).append("/hello");
        //使用SpringMVC提供的RestTemplate向URL发送请求
        RestTemplate rt = new RestTemplate();
        //定义一个响应的返回值类型对象, 注意，是个抽象类，创建的是匿名内部类对象
        ParameterizedTypeReference<String> type = new ParameterizedTypeReference<String>() {};
        //封装了响应数据信息的对象
        ResponseEntity<String> responseEntity = rt.exchange(url.toString(), HttpMethod.GET,null,type);
        //获得响应的数据并返回
        return responseEntity.getBody();
    }
}
