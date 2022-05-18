package com.example.designPattern.adapterPattern;

/**
 * @Auther: 朱广超
 * @Date: 2020/03/15/19:57
 * @package com.example.designPattern.adapterPattern
 * @Description:
 */ //光能适配器
public class OpticalAdapter implements Motor
{
    private OpticalMotor omotor;
    public OpticalAdapter()
    {
        omotor=new OpticalMotor();
    }
    public void drive()
    {
        omotor.opticalDrive();
    }
}
