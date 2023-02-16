package com.linkwin.consumer;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 服务异常兜底
 *
 * @author Meng.fu
 * @version 1.0
 * @date 2023/2/16 9:42
 */
@Component
public class StorageConsumerFallbackFactory implements FallbackFactory<StorageConsumer> {

    @Override
    public StorageConsumer create(Throwable cause) {
        return new StorageConsumer() {
            @Override
            public String getProductStorageInfo(Integer productId) {
                System.out.println("Fallback接口调用异常兜底处理，productId: " + productId);
                return "Fallback接口异常兜底";
            }
        };
    }

}
