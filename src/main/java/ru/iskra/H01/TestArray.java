package ru.iskra.H01;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.iskra.Utils;

public class TestArray {
    @Test
    public void test1() {
        Utils utils = new Utils();
        Assert.assertArrayEquals(
                new int[]{1, 7}, utils.last_four_array(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7})
        );
    }

    @Test
    public void test2() {
        Utils utils = new Utils();
        Assert.assertArrayEquals(
                new int[]{ 5, 6, 7, 8, 9, 0}, utils.last_four_array(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0})
        );
    }

    @Test(expected = RuntimeException.class)
    public void test3() {
        Utils utils = new Utils();
        Assert.assertArrayEquals(
                new int[]{1, 7}, utils.last_four_array(new int[]{1, 2, 3, 3, 5, 6, 7, 8, 9, 0})
        );
    }

    @Test
    @Ignore
    public void test4() {
        Utils utils = new Utils();
        Assert.assertArrayEquals(
                new int[]{ 9, 0}, utils.last_four_array(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0})
        );
    }
}
