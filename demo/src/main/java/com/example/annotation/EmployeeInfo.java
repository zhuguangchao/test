package com.example.annotation;

/**
 * @Auther: 朱广超
 * @Date: 2020/03/25/22:31
 * @package com.example.annotation
 * @Description:
 */
public class EmployeeInfo {
    @EmployeeName("zfq")
    private String employeeName;
    @EmployeeSex(employeeSex = EmployeeSex.Sex.Woman)
    private String employeeSex;
    @Company(id = 1,name = "HYR集团",address = "河南开封")
    private String company;
}
