package com.linkwin.service;

import org.springframework.stereotype.Service;

/**
 * 库存服务业务层
 *
 * @author Meng.fu
 * @version 1.0
 * @date 2023/2/16 9:33
 */
@Service
public class StorageService {

    public String get() {
        System.out.println("Storage - get");
        return "Storage - get";
    }

}
