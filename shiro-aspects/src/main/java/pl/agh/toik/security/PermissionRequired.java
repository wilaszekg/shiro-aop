package pl.agh.toik.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import pl.agh.toik.security.enums.Permission;

/**
 * Created by mateu_000 on 2014-05-12.
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionRequired {
    Permission permission();
}
