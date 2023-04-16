package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_homeWork {
    /* 1.Bir Class olusturalimYanlisEmailTesti
       2.http://automationpractice.com/index.php sayfasinagidelim
       3.Sign in butonunabasalim
       4.Email kutusuna @isareti olmayan bir mail yazip enter'a
       “Invalid email address” uyarisi ciktigini test edelim

     */
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.automationpractice.com/index.php");

    }
    @AfterClass
    public static void tearDown() {
       // driver.close();
    }
    // todo  3.Sign in butonunabasalim
    @Test
    public void test1(){
        driver.findElement(By.xpath("//*[@class='login']")).click();


    }
    @Test
    public void test2(){
        driver.findElement(By.xpath("//*[@id='email_create']")).sendKeys("ahmetcan"+ Keys.ENTER);


    }
    //      bastigimizda “Invalid email address” uyarisi ciktigini test edelim
    @Test
     public void test3() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Invalid email address.']")).isDisplayed());
    }



}
