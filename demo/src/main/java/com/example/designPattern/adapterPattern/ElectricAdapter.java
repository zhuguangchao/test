package com.example.designPattern.adapterPattern;

/**
 * @Auther: 朱广超
 * @Date: 2020/03/15/19:36
 * @package com.example.designPattern.adapterPattern
 * @Description:
 */ //电能适配器
public class ElectricAdapter implements Motor
{
    private ElectricMotor emotor;
    public ElectricAdapter()
    {
        emotor=new ElectricMotor();
    }
    public void drive()
    {
        emotor.electricDrive();
    }
}
