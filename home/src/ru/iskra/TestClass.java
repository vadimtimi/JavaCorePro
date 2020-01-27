package ru.iskra;


//import com.sun.org.apache.xpath.internal.SourceTree;

public class TestCase {
    @BeforeSuite
    public void beforeMethod(){
        System.out.println("Тест с аннотацией BeforeSuite");
    }


    @AfterSuite
    public void methodAfter(){
        System.out.println("Тест с аннотацией AfterSuite");
    }


    @Test(priority = 1)
    public void methodTest1(){
        System.out.println("Приоритет 1. Наибольший");
    }

    @Test(priority = 10)
    public void methodTest2(){
        System.out.println("Приоритет 10. Наименьший");
    }

    @Test (priority = 5)
    public void methodTest3(){
        System.out.println("Приоритет 5. Средний");
    }

    public void commonMethod1(){
        System.out.println("Метод для теста 1");
    }

    public void commonMethod2(){
        System.out.println("Метод для теста 2");
    }
}
