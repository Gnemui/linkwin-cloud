package com.linkwin.consumer;

import com.linkwin.api.StorageApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 库存开放服务消费者接口
 *
 * @author Meng.fu
 * @version 1.0
 * @date 2023/2/16 9:38
 */
@FeignClient(name = "linkwin-storage")
public interface StorageConsumer extends StorageApi {
}
