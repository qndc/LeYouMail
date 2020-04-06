package com.leyou.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Auther: dc
 * @Date: 2020/4/6 10:51
 * @Description:
 */
@Configuration
public class LeyouCorsFilterConfiguration {

    @Bean
    public CorsFilter corsFilter(){
        //初始化配置对象
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //允许跨域的域名或者IP，可以设置多个。*代表所有域名，如果要携带cookie，一定不能设置为*
        corsConfiguration.addAllowedOrigin("http://192.168.3.9:9001");
        //允许携带cookie
        corsConfiguration.setAllowCredentials(true);
        //允许所有请求方式跨域
        corsConfiguration.addAllowedMethod("*");
        //允许携带所有头信息跨域访问
        corsConfiguration.addAllowedHeader("*");
        //初始化配置源对象
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        //拦截所有请求，校验是否允许跨域
        corsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(corsConfigurationSource);
    }

}
