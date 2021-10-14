package com.geekbrains.lesson_1;

import com.geekbrains.lesson_1.fruits.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit>{

    private List<T> fruitBox;

    public Box() {
        this.fruitBox = new ArrayList<>();
    }

    public Box(T... fruits) {
        this.fruitBox = new ArrayList<>(Arrays.asList(fruits));
    }

    public List<T> getFruitBox() {
        return fruitBox;
    }

    public void setFruitBox(List<T> fruitBox) {
        this.fruitBox = fruitBox;
    }

    public float getWeight() {
        float weigth = 0;
        for (T fruit : this.fruitBox) {
            weigth += fruit.getWeight();
        }
        return weigth;
    }

    public boolean compareTo (Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.001;
    }

    public void pourFruit(Box<T> anotherBox) {
        if (this != anotherBox) {
            anotherBox.fruitBox.addAll(this.fruitBox);
            this.fruitBox.clear();
        }
    }
}
