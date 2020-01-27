package ru.iskra;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        System.out.println("Начало теста");
        start(TestClass.class);
        System.out.println("Конец теста");
    }

    //
    public static void start(Class<?> className) {
        final int MAX_PRIORITY = 1;
        final int MIN_PRIORITY = 10;
        Map<Integer, Method> map = new TreeMap<>();

        int itemBefore = 0;
        int itemAfter = 0;

        for(Method method: className.getDeclaredMethods()){
            if (method.getAnnotation(BeforeSuite.class) != null){
                map.put(MAX_PRIORITY - 1, method);
                itemBefore++;
            }
            if (method.getAnnotation(AfterSuite.class) != null){
                map.put(MIN_PRIORITY + 1, method);
                itemAfter++;
            }
            if (method.getAnnotation(Test.class) != null){
                Test test = method.getAnnotation(Test.class);
                map.put(test.priority(), method);
            }
            if (itemBefore > 1) throw new RuntimeException("Несколько тестов с аннотацией BeforeSuite");
            if (itemAfter > 1) throw new RuntimeException("Несколько тестов с аннотацией AfterSuite");

        }

        System.out.println("Map " + className.getSimpleName() + ":");
        for (Integer key : map.keySet()) {
            System.out.println("Приоритет: " + key + "  Метод: " + map.get(key).getName());
        }
        System.out.println();

        System.out.println("Выполняем методы " + className.getSimpleName() + ":");
        try{
            TestClass testCase = new TestClass();
            for (Integer key : map.keySet()) {
                map.get(key).invoke(testCase);
            }
        } catch(IllegalAccessException e){
            e.printStackTrace();
        } catch (InvocationTargetException e){
            e.printStackTrace();
        }
    }
}
