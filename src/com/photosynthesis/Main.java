package com.photosynthesis;

import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Arrays.asList;

public class Main {

    // 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
    public static <T> T[] swapElements(T[] arraySwap, int indexFrom , int indexTo) {
        try {
            T tmp = arraySwap[indexTo];
            arraySwap[indexTo] = arraySwap[indexFrom];
            arraySwap[indexFrom] = tmp;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Превышение индекса массива");
        }
        return arraySwap;
    }

    // 2. Написать метод, который преобразует массив в ArrayList;
    public static <T> ArrayList toArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    public static void main(String[] args) {
        // Инициализация массивов
        Integer[] integers = {1, 2, 3, 4};
        String[] strings = {"1", "2", "3", "4"};
        Byte[] bytes = {1, 2, 3, 4};

        // Меняем местами два элемента массива
        System.out.println(Arrays.toString(swapElements(integers, 1, 2)));
        System.out.println(Arrays.toString(swapElements(strings, 0, 3)));
        System.out.println(Arrays.toString(swapElements(bytes, 0, 2)));

        // Преобразуем массив в ArrayList
        toArrayList(integers).forEach(System.out::print);
        toArrayList(strings).forEach(System.out::print);
        toArrayList(bytes).forEach(System.out::print);

        System.out.println("");

        // Инициализация фруктов и коробок
        ArrayList<Apple> appels1 = new ArrayList<>(asList(new Apple(), new Apple(), new Apple()));
        ArrayList<Orange> oranges = new ArrayList<>(asList(new Orange(), new Orange(), new Orange()));
        ArrayList<Apple> appels2 = new ArrayList<>(asList(new Apple(), new Apple(), new Apple()));

        Box<Apple> appleBox1 = new Box<>(appels1);
        Box<Orange> orangeBox = new Box<>(oranges);
        Box<Apple> appleBox2 = new Box<>(appels2);

        appleBox1.getWeight();
        orangeBox.getWeight();
        appleBox2.getWeight();
        // Получаем вес коробки
        System.out.println("Вес appleBox1 = " + appleBox1.getWeight());
        System.out.println("Вес orangeBox = " + orangeBox.getWeight());
        System.out.println("Вес appleBox2 = " + appleBox2.getWeight());

        appleBox1.getAmountOfFruit();
        // Сравниваем коробки
        System.out.println("Сравним коробку яблок и апельсин: " + appleBox1.compare(orangeBox));
        System.out.println("Сравним коробку яблок и яблок: " + appleBox1.compare(appleBox2));

        // Пересыпаем фрукты
        System.out.println("appleBox1 = " + appleBox1.getAmountOfFruit());
        System.out.println("appleBox2 = " + appleBox2.getAmountOfFruit());
        appleBox1.moveAllTo(appleBox2);
        System.out.println("appleBox1 = " + appleBox1.getAmountOfFruit());
        System.out.println("appleBox2 = " + appleBox2.getAmountOfFruit());
    }
}


// Класс Фрукт
abstract class Fruit {
    float weight;

    float getWeight() {
        return weight;
    }
}

// Класс Яблоко
class Apple extends Fruit {
    {
        super.weight = 1.0f;
    }
}

// Класс Апельсин
class Orange extends Fruit {
    {
        super.weight = 1.5f;
    }
}


// Коробка
class Box<T extends Fruit> {
    private ArrayList<T> content = new ArrayList<>();

    Box(ArrayList<T> fruits) {
        this.content = fruits;
    }

    void addFruit(T fruit) {
        this.content.add(fruit);
    }

    int getAmountOfFruit() {
        return this.content.size();
    }

    public float getWeight() {
        if (this.content.size() > 0)
            return (this.content.get(0).getWeight() * getAmountOfFruit());
        return 0;
    }

    boolean compare(Box<?> another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.00001f;
    }

    void moveAllTo(Box<T> another) {
        for (T item : this.content)
            another.addFruit(item);
        this.content.clear();
    }
}