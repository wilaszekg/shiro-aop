package pl.agh.toik.security;

import pl.agh.toik.security.enums.Permission;
import pl.agh.toik.security.enums.Role;


public aspect SecurityAspect {
    public pointcut secured(): @annotation(Secured);
//    public pointcut roleReq(Role role): @annotation(RoleRequired) && args(role);
//    public pointcut permReq(Permission permission): @annotation(PermissionRequired) && args(permission);

    Object around(): secured(){ 
        //System.out.println(thisJoinPoint.getSignature());
        //System.out.println(thisJoinPoint.getArgs());

        if (UserContext.getInstance().isAutenthicated()) {
            Object o = proceed();
            return o;
        } else {
           // throw new AuthException();
        	return null;
        }
    }
    
    

//    Object around(): roleReq(Role role) {
//
//        if (currentUser.hasRole(role)){
//            Object o = proceed();
//        }
//    }
//
//    Object around(): permReq(Permission permission) {
//
//    }
}
