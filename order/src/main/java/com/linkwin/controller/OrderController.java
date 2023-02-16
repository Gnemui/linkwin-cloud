package com.linkwin.controller;

import com.linkwin.consumer.StorageConsumer;
import com.linkwin.service.OrderService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单服务控制层
 *
 * @author Meng.fu
 * @version 1.0
 * @date 2023/2/16 9:32
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource(type = StorageConsumer.class)
    private StorageConsumer storageConsumer;

    @Resource
    private Environment environment;

    @RequestMapping("/order/get")
    public String get() {
        return orderService.get();
    }

    @RequestMapping("/order/getStorage")
    public String getStorage(@RequestParam("productId") Integer productId) {
        String port = environment.getProperty("server.port");
        System.out.println("订单服务 - 实例：" + port);

        return storageConsumer.getProductStorageInfo(productId);
    }

}
