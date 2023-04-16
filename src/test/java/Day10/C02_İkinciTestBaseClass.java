package Day10;

import org.junit.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class C02_İkinciTestBaseClass extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1(){
        driver.get("https://amazon.com");
    }
}
