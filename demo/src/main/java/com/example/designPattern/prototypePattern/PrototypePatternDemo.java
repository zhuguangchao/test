package com.example.designPattern.prototypePattern;

public class PrototypePatternDemo {
   public static void main(String[] args) {
      ShapeCache.loadCache();

      //浅克隆开辟新的内存空间,但引用属性(对象)仍然指向原有地址
      Shape clonedShape = (Shape) ShapeCache.getShape("1");
      Shape clonedShape1 = (Shape) ShapeCache.getShape("1");
      System.out.println(clonedShape);
      System.out.println(clonedShape1);
      System.out.println(clonedShape1.equals(clonedShape));
      System.out.println("Shape : " + clonedShape.getType());
 
      Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
      System.out.println("Shape : " + clonedShape2.getType());        
 
      Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
      System.out.println("Shape : " + clonedShape3.getType());        
   }
}