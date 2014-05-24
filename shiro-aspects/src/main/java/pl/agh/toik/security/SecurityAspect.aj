package pl.agh.toik.security;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.reflect.MethodSignature;

public aspect SecurityAspect {
    pointcut secured(): @annotation(Secured) && execution(* *(..));
    pointcut permissionRequired(): @annotation(PermissionRequired) && execution(* *(..));

    Object around(): secured() {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            System.out.println("User authenticated");
            Object o = proceed();
            return o;
        } else {
            System.out.println("Not authenticated");
            throw new AuthException();
        }
    }

    Object around(): permissionRequired() {
        MethodSignature methodSignature = (MethodSignature) thisJoinPoint.getSignature();
        PermissionRequired annotation = methodSignature.getMethod().getAnnotation(PermissionRequired.class);
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated() || !subject.isPermittedAll(annotation.value())) {
            throw new AuthException();
        }
        System.out.println("User authenticated");
        return proceed();
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
