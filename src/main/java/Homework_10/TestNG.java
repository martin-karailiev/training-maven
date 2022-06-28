package Homework_10;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG {

    @Test(dataProvider = "data-provider", dataProviderClass = Data.class, groups = "test1")

    public void sum(int a, int b, int result) {
        int sum = a + b;
        Assert.assertEquals(sum, result);
    }

    @Test(dataProvider = "data-provider", dataProviderClass = Data.class, groups = "test2")

    public void minus(int a, int b, int result) {
        int minus = a - b;
        Assert.assertEquals(minus, result);
    }

    @Test(dataProvider = "data-provider", dataProviderClass = Data.class, groups = "test3")

    public void mul(int a, int b, int result) {
        int mul = a * b;
        Assert.assertEquals(mul, result);
    }

    @Test(dataProvider = "data-provider", dataProviderClass = Data.class, groups = "test4")

    public void mod(int a, int b, int result) {
        int mod = a / b;
        Assert.assertEquals(mod, result);
    }

    @Test(dataProvider = "data-provider", dataProviderClass = Data.class, groups = "test5")

    public void pro(int a, int b, int result) {
        int pro = (a * b) / 100;
        Assert.assertEquals(pro, result);
    }
}

