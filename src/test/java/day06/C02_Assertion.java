package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertion {

    /*
    - Amazon sayfasına gidelim 3 arklı test medodu olusturalım
    1 url nin amazon içerdiğini test edelim
    2- title nin facebook içermediğini
    3- sol ust kösede amazon logosunun göründüğünü test edelim
    4- url

     */
    // Not : BeforeAfter methodunda testleri farklı sayfalarda açıp kapatıyor,
    // BeforeAfterCLass methodlarında aynı sayfada açıp sonra kapatıyor.
    // BeforeAfter methodunda methodların static yapmaya gerek yok ama BeforeAfterCLass'da static yapmak zorunlu.

     static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");

    }
    @AfterClass
    public static void tearDown(){
        //driver.close();
    }
    //todo 1 url nin amazon içerdiğini test edelim
    @Test
    public void test1(){
        String expectedUrl="amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }
    // todo 2- title nin facebook içermediğini
    @Test
    public void test2(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "fecebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));

    }
    // todo 3- sol ust kösede amazon logosunun göründüğünü test edelim
    @Test
    public void test3(){
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());


    }
    @Test
    public void test4 () {
        String expectedUrl1 = "facebook";
        String actualUrl1 = driver.getCurrentUrl();
        //Assert.assertEquals(actualUrl1, expectedUrl1);  //Bile bile eşit olmayan bir secenek girersek ve
        Assert.assertNotEquals(actualUrl1, expectedUrl1);
        // equals ile sorarsak Failed olur

        Assert.assertNotEquals(actualUrl1, expectedUrl1); //Eşit olmayan sonucu bildiğim için  assertNotEquals kullandık
    }

}
