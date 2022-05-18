package com.example.designPattern.abstractFactoryPattern;

/**
 * @Auther: 朱广超
 * @Date: 2020/03/08/13:43
 * @package com.example.designPattern.abstractFactoryPattern
 * @Description:
 */
public class ColorFactory extends AbstractFactory {

    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
