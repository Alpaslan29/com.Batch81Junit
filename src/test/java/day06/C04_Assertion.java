package day06;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertion {
    /*
     * https://www.youtube.com adresine gidin
     * Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
     * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
     * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
     * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
     * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");

    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    // todo * titleTest => Sayfa başlığının “YouTube” oldugunu test edin

    @Test
    public void test1(){
        String expectedTitle= "YouTube";
        String actualTitle =driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }
    // todo  * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void test2(){
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]")).isDisplayed());

    }
    // todo * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    @Test
    public void test3(){
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@id='search'])[3]")).isEnabled());

    }
    // todo * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    @Test
    public void test4(){
        String actualTitle = driver.getTitle();
        String expectedTitle ="youtube";
        Assert.assertNotEquals(expectedTitle,actualTitle);

    }
}
