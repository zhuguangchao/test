package com.example;

import com.example.goods.pojo.Sku;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java内置四大核心函数式接口
 * <p>
 * 1.Consumer<T>消费型接口 无返回值  void accept（T t）
 * 2.Supplier<T>供给型接口 T get();
 * 3.Function<T>函数型接口 R apply(T t)
 * 4.Predicate<T>断言型接口 用于做判断操作 boolean test(T t)
 */
public class TestLambda3 {

    //Consumer<T>
    @Test
    public void test1() {
        happy(10.15, (x) -> System.out.println(x));

    }

    //happy
    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }


    //Supplier<T> 产生指定个数的随机数,存入集合
    @Test
    public void test2() {
        List<Double> number = this.getNumber(10, () -> Math.random() * 100);
        System.out.println(number);
    }

    public List<Double> getNumber(int num, Supplier<Double> sup) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }


    //Predicate<T>

    @Test
    public void test3() {
        List<String> strList = Arrays.asList("Mike", "Lee", "Yan");
        //使用时设置条件
        List<String> list = this.filterStr(strList, (x) -> x.length() > 3);
        list.forEach(System.out::print);
    }

    //将满足条件的字符串 存入集合中
    public List<String> filterStr(List<String> str, Predicate<String> pre) {
        List<String> list = new ArrayList<>();

        for (String s : str) {
            if (pre.test(s)) {
                list.add(s);
            }
        }
        return list;
    }

    AtomicReference<Sku> reference = new AtomicReference<>();
    Sku sku = new Sku();
    @Test
    public void test() throws InterruptedException {
        sku.setAlertNum(1);
        reference.set(sku);
        thread1();
        thread2();
        thread3();
        Thread.sleep(1000);
        Sku sku1 = reference.get();
        sku1.setAlertNum(5);
        System.out.println("main: " + sku.getAlertNum());
        System.out.println("main: " + sku1.getAlertNum());
    }

    public void thread1(){
        new Thread(){
            public void run(){
                Sku sku1 = new Sku();
                sku1.setAlertNum(2);
                sku = sku1;
                System.out.println("thread1: " + sku.getAlertNum());
            }
        }.start();
    }

    public void thread2(){
        new Thread(){
            public void run(){
                Sku sku1 = new Sku();
                sku1.setAlertNum(3);
                sku = sku1;
                System.out.println("thread2: " + sku.getAlertNum());
            }
        }.start();
    }

    public void thread3(){
        Sku sku1 = new Sku();
        sku1.setAlertNum(4);
        sku = sku1;
        System.out.println("thread3: " + sku.getAlertNum());
    }


    static AtomicReference<Sku> reference8 = new AtomicReference<>();
    @Test
    public void test8() throws InterruptedException {
        Sku sku = new Sku();
        sku.setAlertNum(8);
        reference.set(sku);
        System.out.println("main: " + reference.get().getAlertNum());
        thread4();
        thread5();
        thread6();
        Thread.sleep(1000);
        Sku sku1 = reference.get();
        System.out.println("main: " + sku1.getAlertNum());
    }

    public void thread4(){
        new Thread(){
            public void run(){
                Sku sku1 = new Sku();
                sku1.setAlertNum(4);
                reference.compareAndSet(sku1,sku1);
                System.out.println("thread4: " + reference.get().getAlertNum());
            }
        }.start();
    }

    public void thread5(){
        new Thread(){
            public void run(){
                Sku sku1 = new Sku();
                sku1.setAlertNum(5);
                reference.compareAndSet(sku1,sku1);
                System.out.println("thread5: " + reference.get().getAlertNum());
            }
        }.start();
    }

    public void thread6(){
        Sku sku1 = new Sku();
        sku1.setAlertNum(6);
        reference.compareAndSet(sku1,sku1);
        System.out.println("thread6: " + reference.get().getAlertNum());
    }
}