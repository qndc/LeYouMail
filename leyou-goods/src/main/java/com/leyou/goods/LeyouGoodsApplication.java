package com.leyou.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: dc
 * @Date: 2020/3/31 22:33
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.leyou.goods.mapper")
public class LeyouGoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeyouGoodsApplication.class,args);
    }
}
