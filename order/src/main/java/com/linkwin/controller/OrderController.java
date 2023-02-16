package com.linkwin.controller;

import com.linkwin.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/order/get")
    public String get() {
        return orderService.get();
    }

}
