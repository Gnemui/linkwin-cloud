package com.linkwin.config;

import com.linkwin.filter.LinkwinGatewayFilterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注册自定义过滤器
 *
 * @author Meng.fu
 * @version 1.0
 * @date 2023/2/16 9:28
 */
@Configuration
public class FilterConfig {

    @Bean
    public LinkwinGatewayFilterFactory linkwinGatewayFilterFactory() {
        return new LinkwinGatewayFilterFactory();
    }

}
