package com.example.designPattern.adapterPattern;


//目标：发动机
interface Motor
{
    public void drive();
}

//客户端代码
public class MotorAdapterTest
{
    public static void main(String[] args)
    {
        System.out.println("适配器模式测试：");
        Motor motor=(Motor) ReadXML.getObject();
        motor.drive();
    }
}