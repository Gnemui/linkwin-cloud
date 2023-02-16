package com.linkwin.filter;

import com.alibaba.fastjson.JSON;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import reactor.core.publisher.Flux;

import java.nio.charset.StandardCharsets;

/**
 * 自定义网关过滤器
 * 可用于认证、鉴权、全局日志记录等
 *
 * @author Meng.fu
 * @version 1.0
 * @date 2023/2/16 9:28
 */
public class LinkwinGatewayFilterFactory extends AbstractGatewayFilterFactory {

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();

            boolean flag;
            String currentRequestPath = request.getPath().toString();
            if ("/linkwin-order/order/get".equals(currentRequestPath)) {
                flag = true;
            } else if ("/linkwin-order/order/getStorage".equals(currentRequestPath)) {
                flag = true;
            } else if ("/linkwin-storage/storage/get".equals(currentRequestPath)) {
                flag = true;
            } else {
                flag = false;
            }

            if (!flag) {
                System.out.println("访问路径非法！");
                String resultString = JSON.toJSONString("访问路径非法！");
                byte[] bytes = (resultString).getBytes(StandardCharsets.UTF_8);
                DataBuffer wrap = exchange.getResponse().bufferFactory().wrap(bytes);
                return exchange.getResponse().writeWith(Flux.just(wrap));
            }

            return chain.filter(exchange.mutate().request(request).build());
        };
    }

}
