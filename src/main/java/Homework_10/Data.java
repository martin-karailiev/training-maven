package Homework_10;

import org.testng.annotations.DataProvider;

public class Data {

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { 1, 2, 3 }, { 4, 5, 6 } };
    }
}
