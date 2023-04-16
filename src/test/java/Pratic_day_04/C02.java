package Pratic_day_04;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02 extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Verify that we have pom.xml file in our project => please try in 4 min s
        String dosyaYolu= "C:\\com.Batch81Junit\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        /* ikinci yol

        String actualData = "pom.xml";
        String expectedData = System.getProperty("pom.xml.filename");

        Assert.assertEquals(actualData, expectedData);

         */
    }
}
