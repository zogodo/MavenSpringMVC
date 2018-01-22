package me.zogodo.ssh.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zogodo on 18-1-20.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserRequired
{
    public enum RoleId{ NO, STUDENT, TEACHER, ADMIN }
    public int roleId() default 0;
}
