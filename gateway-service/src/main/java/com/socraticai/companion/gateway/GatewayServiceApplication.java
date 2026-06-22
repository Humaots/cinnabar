package com.socraticai.companion.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayServiceApplication {
    public static void main(String[] args) {
        // Gateway 是所有外部流量的入口，后续统一在这里接 JWT、限流和路由规则。
        SpringApplication.run(GatewayServiceApplication.class, args);
    }
}
