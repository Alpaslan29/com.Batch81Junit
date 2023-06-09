package Day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handelWindows {
    //1- Amazon Sayfasina girelim
//2- Url'nin amazon içerdiğini test edelim
//3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
//4- title'in BestBuy içerdiğini test edelim
//5- İlk sayfaya dönüp sayfada java aratalım
//6- Arama sonuclarının java içerdiğini test edelim
//7- Yeniden bestbuy sayfasına gidelim
//8- Logonun görünürlüğünü test edelim
//9- Sayfaları Kapatalım
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
    public  void test1 (){
         driver.get("https://www.amazon.com");
         String amazonWindowHandle = driver.getWindowHandle();
         /*
Eğer bize verilen task'te sayfalar arası geçiş varsa her driver.get() methodundan sonra
driver'ın window handle değerini string bir değişkene atarız
Sonrasında farklı bir sayfaya ya da sekmeye gittikten sonra tekrar ilk sayfaya dönmemiz istenirse
String değişkene atadığımız window handle değerleriyle sayfalar arası geçiş yapabiliriz
 */
         // todo 2- Url'nin amazon içerdiğini test edelim
         String expectedUrl ="amazon";
         String actualUrl = driver.getCurrentUrl();
         Assert.assertTrue(actualUrl.contains(expectedUrl));

         // todo 3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
         driver.switchTo().newWindow(WindowType.WINDOW);
         driver.get("https://www.bestbuy.com");
         String bestbuyWindowHandle = driver.getWindowHandle();
         // todo 4- title'in BestBuy içerdiğini test edelim
         String expectedTitle = "Best Buy";
         String actualTitle = driver.getTitle();
         Assert.assertTrue(actualTitle.contains(expectedTitle));
         // todo 5- İlk sayfaya dönüp sayfada java aratalım
         driver.switchTo().window(amazonWindowHandle);


         WebElement searcbox = driver.findElement(By.id("twotabsearchtextbox"));
         searcbox.sendKeys("java", Keys.ENTER);


         // todo 6- Arama sonuclarının java içerdiğini test edelim
         WebElement aramaSonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
         String arananKelime ="java";
         String actualSonuc = aramaSonucu.getText();
         Assert.assertTrue(actualSonuc.contains(arananKelime));

         // todo 7- Yeniden bestbuy sayfasına gidelim

         driver.switchTo().window(bestbuyWindowHandle);

         // todo 8- Logonun görünürlüğünü test edelim
         Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='logo'])[1]")).isDisplayed());





     }


}
