package com.example.designPattern.abstractFactoryPattern;

/**
 * @Auther: 朱广超
 * @Date: 2020/03/08/13:36
 * @package com.example.designPattern.abstractFactoryPattern
 * @Description:
 */
public abstract class AbstractFactory {

    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}
