package dataProviders;

import org.testng.annotations.DataProvider;

public class dataProviders {

    @DataProvider
    public Object[][] idAndTitle() {
        return new Object[][]{
                {"1", "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"},
                {"2", "qui est esse"},
                {"65", "consequatur id enim sunt et et"}
        };
    }

    @DataProvider
    public Object[][] titleAndUserIds() {
        return new Object[][]{
                {"iusto eius quod necessitatibus culpa ea", 3, 10},
                {"aut quo modi neque nostrum ducimus", 5, 10}
        };
    }
}
