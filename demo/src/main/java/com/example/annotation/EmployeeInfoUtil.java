package com.example.annotation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 朱广超
 * @Date: 2020/03/25/22:24
 * @package com.example.annotation
 * @Description:
 */
public class EmployeeInfoUtil {
    public static Map getEmployeeInfo(Class<?> clazz){
        HashMap<String,String> hm = new HashMap();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(EmployeeName.class)){
                EmployeeName employeeName = declaredField.getAnnotation(EmployeeName.class);
                    hm.put("employeeName", employeeName.value());
            }
            if (declaredField.isAnnotationPresent(EmployeeSex.class)) {
                EmployeeSex employeeSex = declaredField.getAnnotation(EmployeeSex.class);
                hm.put("employeeSex",employeeSex.employeeSex().toString());
            }
            if (declaredField.isAnnotationPresent(Company.class)) {
                Company company = declaredField.getAnnotation(Company.class);
                hm.put("company",company.id()+":"+company.name()+":"+company.address());
            }
        }
        return hm;
    }
}
