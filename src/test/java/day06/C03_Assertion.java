package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertion {
    /*
    1) Bir class oluşturun: BestBuyAssertions
    2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki
    testleri yapin
         ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
         ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
         ○ logoTest => BestBuy logosunun görüntülendigini test edin
         ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com");

    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    //TODO Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    @Test
    public void test1 (){
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
    //todo   titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    @Test
    public void test2(){
        String expectedTitle= "Rest";
        String actualTitle =driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));

    }
    // todo logoTest => BestBuy logosunun görüntülendigini test edin
    @Test
    public void test3(){

        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class=\"logo\"])[1]")).isDisplayed());

    }
    // todo FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    @Test
    public void test4(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Français']")).isDisplayed());

    }





}
