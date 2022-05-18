package com.example.test;

import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 朱广超
 * @date 2021-04-24 19:40
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(get(7));
        System.out.println(f(7));
//        int n = 10;
//        for (int i = 0; i < n; i++) {
//            get(i);
//        }

    }

    private static int get(int n) {
        if (n < 3) {
            return 1;
        }
        return get(n - 1) + get(n - 3);
    }

    public static int f(int n) {
        if (n < 3) return 1;
        int first = 1;
        int second = 2;
        int third = 2;
        int four;
        for (int i = 3; i <= n; i++) {
            four = first + third;
            first = second;
            third = four;
        }
        return third;
    }
}
