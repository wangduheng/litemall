package org.linlinjava.litemall.admin.shiro;

//
//public class MyAuthorizingRealm extends AuthorizingRealm {
//    @Autowired
//    private LitemallRoleService roleService;
//    @Autowired
//    private LitemallPermissionService permissionService;
//    @Autowired
//    private LitemallAdminService adminService;
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        if(principalCollection==null){
//            throw new AuthorizationException("doGetAuthorizationInfo method args cannot be null");
//        }
//        LitemallAdmin admin = (LitemallAdmin) getAvailablePrincipal(principalCollection);
//        Integer[] roleIds = admin.getRoleIds();
//        SimpleAuthorizationInfo authInfo=new SimpleAuthorizationInfo();
//        authInfo.setRoles(roleService.queryByIds(roleIds));
//        authInfo.setStringPermissions(permissionService.queryByRoleIds(roleIds));
//        return authInfo;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken upToken= (UsernamePasswordToken) authenticationToken;
//        String userName=upToken.getUsername();
//        String password=new String(upToken.getPassword());
//        if(StringUtils.isEmpty(userName)){
//            throw  new AccountException("userName 不能为空");
//        }
//        if(StringUtils.isEmpty(password)){
//            throw  new AccountException("password 不能为空");
//        }
//        List<LitemallAdmin> admins = adminService.findAdmin(userName);
//        Assert.state(admins.size()<2,"同一个用户名存在两个账号");
//        if(admins.size()==0){
//            throw new UnknownAccountException("找不到用户名:("+userName+")的账户信息");
//        }
//        LitemallAdmin admin = admins.get(0);
//        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
//        if(!encoder.matches(admin.getPassword(),password)){
//            throw new UnknownAccountException("找不到用户名:("+userName+")的账户信息");
//        }
//        return new SimpleAuthenticationInfo(admin,password,getName());
//    }
//}
