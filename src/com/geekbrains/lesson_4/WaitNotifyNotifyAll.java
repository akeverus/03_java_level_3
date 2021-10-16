package com.geekbrains.lesson_4;

public class WaitNotifyNotifyAll {
    static final Object mon = new Object();
    static volatile char currentChar = 'A';
    static final int num = 10;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0; i < num; i++) {
                    synchronized (mon) {
                        while (currentChar != 'A') {
                            mon.wait();
                        }
                        System.out.print(currentChar);
                        currentChar = 'B';
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < num; i++) {
                    synchronized (mon) {
                        while (currentChar != 'B') {
                            mon.wait();
                        }
                        System.out.print(currentChar);
                        currentChar = 'C';
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < num; i++) {
                    synchronized (mon) {
                        while (currentChar != 'C') {
                            mon.wait();
                        }
                        System.out.print(currentChar);
                        currentChar = 'A';
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
