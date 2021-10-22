package com.geekbrains.lesson_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            Main.cyclicBarrier.await();
            System.out.println(this.name + " готов");
            Main.cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Main.countDownLatchStart.countDown();
        try {
            Main.cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        Main.countDownLatchFinish.countDown();

        if (!Main.isFinish.get()) {
            Main.isFinish.set(true);
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Победитель " + this.name + "!!!");
        }

    }
}