package com.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: 朱广超
 * @Date: 2020/03/25/22:20
 * @package com.example.annotation
 * @Description:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Company {
    public int id() default -1;
    public String name() default "";
    public String address() default "";
}
