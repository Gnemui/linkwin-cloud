package com.linkwin.controller;

import com.linkwin.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 库存服务控制层
 *
 * @author Meng.fu
 * @version 1.0
 * @date 2023/2/16 9:33
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @RequestMapping("/storage/get")
    public String get() {
        return storageService.get();
    }

}
