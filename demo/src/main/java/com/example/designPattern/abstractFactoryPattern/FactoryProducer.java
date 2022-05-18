package com.example.designPattern.abstractFactoryPattern;

/**
 * @Auther: 朱广超
 * @Date: 2020/03/08/13:44
 * @package com.example.designPattern.abstractFactoryPattern
 * @Description:
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }
}
