package com.linkwin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 库存服务启动类
 *
 * @author Meng.fu
 * @version 1.0
 * @date 2023/2/16 9:27
 */
@SpringBootApplication
@EnableFeignClients
public class StorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class, args);
        System.out.println(StorageApplication.class.getSimpleName() + " is success!");
    }

}
