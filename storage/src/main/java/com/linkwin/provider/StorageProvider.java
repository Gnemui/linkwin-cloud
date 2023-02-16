package com.linkwin.provider;

import cn.hutool.core.date.DateUtil;
import com.linkwin.api.StorageApi;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 库存开放服务生产者接口
 *
 * @author Meng.fu
 * @version 1.0
 * @date 2023/2/16 9:39
 */
@RestController
public class StorageProvider implements StorageApi {

    @Resource
    private Environment environment;

    @Override
    public String getProductStorageInfo(Integer productId) {
        String port = environment.getProperty("server.port");
        System.out.println("库存服务 - 实例：" + port);

        if (productId == -1) {
            throw new RuntimeException();
        }
        if (productId == 0) {
            return "库存服务繁忙";
        }

        return DateUtil.now();
    }

}
