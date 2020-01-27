package ru.iskra;


//import com.sun.org.apache.xpath.internal.SourceTree;

public class TestClass {
    @BeforeSuite
    public void startMethod(){
        System.out.println(ConsoleColors.GREEN +"Тест с аннотацией @BeforeSuite");
    }

    @AfterSuite
    public void endMethod(){
        System.out.println(ConsoleColors.RED +"Тест с аннотацией @AfterSuite");
    }


    @Test(priority = 1)
    public void test1(){
        System.out.println( ConsoleColors.BLUE + "test1 Приоритет 1");
    }

    @Test(priority = 2)
    public void test2(){
        System.out.println(ConsoleColors.BLACK + "test2 Приоритет 2");
    }

    @Test(priority = 3)
    public void test3(){
        System.out.println(ConsoleColors.BLUE + "test3 Приоритет 3");
    }

    @Test(priority = 4)
    public void test4(){
        System.out.println(ConsoleColors.BLACK + "test4 Приоритет 4");
    }

    @Test (priority = 5)
    public void test5(){
        System.out.println(ConsoleColors.BLUE +"test5 Приоритет 5");
    }

    @Test (priority = 6)
    public void test6(){
        System.out.println(ConsoleColors.BLACK + "test6 Приоритет 6");
    }

    @Test (priority = 7)
    public void test7(){
        System.out.println(ConsoleColors.BLUE +"test7 Приоритет 7");
    }

    @Test (priority = 8)
    public void test8(){
        System.out.println(ConsoleColors.BLACK + "test8 Приоритет 8");
    }

    @Test (priority = 9)
    public void test9(){
        System.out.println(ConsoleColors.BLUE +"test9 Приоритет 9");
    }

    @Test (priority = 10)
    public void test10(){
        System.out.println(ConsoleColors.BLACK + "test10 Приоритет 10");
    }

    public void method1(){
        System.out.println("Метод 1 без аннотации");
    }

    public void method2(){
        System.out.println("Метод 2 без аннотации");
    }
}
