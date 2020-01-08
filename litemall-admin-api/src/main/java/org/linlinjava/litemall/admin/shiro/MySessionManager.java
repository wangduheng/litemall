package org.linlinjava.litemall.admin.shiro;

//
//public class MySessionManager extends DefaultWebSessionManager {
//    public static final String LOGIN_TOKEN_KEY="X-Litemall-Admin-Token";
//    public static final String REFERENCED_SESSION_ID_SOURCE="Stateless request";
//
//    @Override
//    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
//        String id= WebUtils.toHttp(request).getHeader(LOGIN_TOKEN_KEY);
//        if(!StringUtils.isEmpty(id)){
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,REFERENCED_SESSION_ID_SOURCE);
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID,id);
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID,Boolean.TRUE);
//            return id;
//        }
//        return super.getSessionId(request, response);
//    }
//}
