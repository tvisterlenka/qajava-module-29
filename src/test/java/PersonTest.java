import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertEquals;

public class PersonTest {

    public void currentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    @BeforeClass
    void beforeClass(){
        System.out.println("The test started at ");
        currentTime();
    }

    @AfterClass
    void afterClass() {
        System.out.println("The test finished at ");
        currentTime();
    }

    @DataProvider(name = "ageDataProvider")
    Object[][] ageDataProvider() {
        return new Object[][] {
                {-1,false},
                {0,false},
                {1,false},
                {5, false},
                {12,false},
                {13, true},
                {14, true},
                {16, true},
                {18, true},
                {19, true},
                {20, false},
                {30, false}
        };
    }

    @Test(dataProvider = "ageDataProvider")
    public void testAge(int age, boolean expectedResult){
        boolean result = Person.isTeenager(age);
        System.out.println("For age " + age + ": " + "Actual result: " + result + " / " + "Expected result: " + expectedResult);
        assertEquals(result, expectedResult);
    }
}
