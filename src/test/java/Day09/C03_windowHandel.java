package Day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_windowHandel {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test1(){

// todo 1-Yeni bir class olusturun: WindowHandle
// todo 2-Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
// todo 3-Sayfa'nin window handle degerini String bir degiskene atayin
        String amazonWindowHandle = driver.getWindowHandle();
//  todo 4-Sayfa title'nin "Amazon" icerdigini test edin
        String expectedTitle= "Amazon";
        String actualTitle = driver.getTitle();

// todo 5-Yeni bir tab olusturup, acilan tab'da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.techproeducation.com");

// todo 6-Sayfa title'nin "TECHPROEDUCATION" icerdigini test edin
        Assert.assertFalse(driver.getTitle().contains("TECHPROEDUCATION"));


// todo 7-Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");
// todo 8-Sayfa title'nin "Walmart" icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));

// todo 9-Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindowHandle);
        Assert.assertTrue(driver.getTitle().contains(actualTitle));

    }

}
