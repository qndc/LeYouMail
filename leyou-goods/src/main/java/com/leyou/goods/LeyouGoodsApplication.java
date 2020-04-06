package com.leyou.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

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
