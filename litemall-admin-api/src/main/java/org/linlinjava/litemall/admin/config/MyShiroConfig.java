package org.linlinjava.litemall.admin.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.linlinjava.litemall.admin.shiro.AdminWebSessionManager;
import org.linlinjava.litemall.admin.shiro.MyAuthorizingRealm;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class MyShiroConfig {

    @Bean
    public MyAuthorizingRealm realm() {
        return new MyAuthorizingRealm();
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        Map<String, String> chainMap = new LinkedHashMap<>();
        chainMap.put("/admin/auth/login", "anon");
        chainMap.put("/admin/auth/401", "anon");
        chainMap.put("/admin/auth/index", "anon");
        chainMap.put("/admin/auth/403", "anon");
        chainMap.put("/admin/index/index", "anon");
        chainMap.put("/admin/**", "authc");

        bean.setSecurityManager(securityManager);
        bean.setLoginUrl("/admin/auth/401");
        bean.setSuccessUrl("/admin/auth/index");
        bean.setUnauthorizedUrl("/admin/auth/403");
        bean.setFilterChainDefinitionMap(chainMap);
        return bean;
    }

    @Bean
    public SessionManager sessionManager() {
        return new AdminWebSessionManager();
    }

    @Bean
    public SecurityManager defaultWebSecurityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm());
        manager.setSessionManager(sessionManager());
        return manager;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager manager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }

    @DependsOn("lifecycleBeanPostProcessor")
    @Bean
    public static DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

}
