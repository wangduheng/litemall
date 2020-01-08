package org.linlinjava.litemall.admin.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class MyShiroExceptionHandler {

    private final Log logger=LogFactory.getLog(MyShiroExceptionHandler.class);
    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public Object unauthenticatedHandler(AuthenticationException ex){
        logger.warn(ex.getMessage(),ex);
        return ResponseUtil.unlogin();
    }


    @ExceptionHandler()
    @ResponseBody
    public Object unauthorization(AuthorizationException ex){
        logger.warn(ex.getMessage(),ex);
        return ResponseUtil.unauthz();
    }

}
