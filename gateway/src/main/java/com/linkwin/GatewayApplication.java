package com.linkwin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 网关启动类
 *
 * @author Meng.fu
 * @version 1.0
 * @date 2023/2/16 9:26
 */
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
        System.out.println(GatewayApplication.class.getSimpleName() + " is success!");
    }

}
