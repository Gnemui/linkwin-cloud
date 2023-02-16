package com.linkwin.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 库存服务开放接口
 *
 * @author Meng.fu
 * @version 1.0
 * @date 2023/2/16 9:37
 */
public interface StorageApi {

    @RequestMapping(value = "/feign/storage/getProductStorageInfo", method = RequestMethod.GET)
    String getProductStorageInfo(@RequestParam(name = "productId") Integer productId);

}
