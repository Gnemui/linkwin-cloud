package com.linkwin.service;

import org.springframework.stereotype.Service;

/**
 * 订单服务业务层
 *
 * @author Meng.fu
 * @version 1.0
 * @date 2023/2/16 9:32
 */
@Service
public class OrderService {

    public String get() {
        System.out.println("Order - get");
        return "Order - get";
    }

}
