package ru.iskra.H02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.iskra.Utils;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestArray {
    private int[] tstArr;

    public TestArray(int[] tstArr) {
        this.tstArr = tstArr;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{1,2,3,4,5}},
                {new int[]{0,2,3,4,5}},
                {new int[]{5,4,3,2,1}},
                {new int[]{1,1,2,2,3,3,4,4}},
                {new int[]{4,1,4,1,4,1,4,1}}
        });
    }

    @Test
    public void test(){
        Utils utils = new Utils();
        Assert.assertTrue(utils.is1and2(tstArr));
    }
}
