package Practic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_LoginTest {
    // https://www.koalaresorthotels.com/
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test1(){
        driver.get("https://www.koalaresorthotels.com/");

        // todo  login butonuna tıkla

        driver.findElement(By.xpath("(//*[@class='nav-link'])[7]")).click();

        // login ekranına girdiğimizi 4 farklı test ediniz

        //1
        Assert.assertTrue(driver.getTitle().contains("Log in"));

        //2
        String ecpectedUrl="https://www.koalaresorthotels.com/Account/Logon";
        String actulalUrl = driver.getCurrentUrl();
        Assert.assertEquals("login Ekranina giris yapilmadi,",ecpectedUrl,actulalUrl);

        //3
        WebElement L3=driver.findElement(By.xpath("//*[@id='btnSubmit']"));
        Assert.assertTrue(L3.isDisplayed());

        //4
        Assert.assertTrue(driver.getCurrentUrl().contains("Logon"));





    }


}
