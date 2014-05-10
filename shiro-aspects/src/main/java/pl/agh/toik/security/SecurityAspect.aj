package pl.agh.toik.security;


public aspect SecurityAspect {
    pointcut secured(): @annotation(Secured) && execution(* *(..));

    Object around(): @annotation(Secured) {
        System.out.println(thisJoinPoint.getSignature());
        System.out.println(thisJoinPoint.getArgs());
        System.out.println(">> before");
        Object o = proceed();
        System.out.println(">> after");
        return o;
    }
}
