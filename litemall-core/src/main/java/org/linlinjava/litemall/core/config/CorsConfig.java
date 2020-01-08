package org.linlinjava.litemall.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;
import java.util.Set;

@Configuration
public class CorsConfig {
    // 当前跨域请求最大有效时长。这里默认30天
    private long maxAge = 30 * 24 * 60 * 60;

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin(CorsConfiguration.ALL); // 1 设置访问源地址
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL); // 2 设置访问源请求头
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL); // 3 设置访问源请求方法
        corsConfiguration.setMaxAge(maxAge);
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4 对接口配置跨域设置
        return new CorsFilter(source);
    }
}
