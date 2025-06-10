package com.example;

public class BadCode {

    public void duplicate() {
        int x = 10;
        int y = 20;
        int z = x + y;
        System.out.println(z);

        int a = 10;
        int b = 20;
        int c = a + b;
        System.out.println(c);
    }

    public void longMethod() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Line " + i);
        }
    }
}
