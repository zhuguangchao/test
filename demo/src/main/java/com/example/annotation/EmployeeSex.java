package com.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: 朱广超
 * @Date: 2020/03/25/22:23
 * @package com.example.annotation
 * @Description:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeeSex {
    enum Sex{Man,Woman};
    Sex employeeSex() default Sex.Man;
}
