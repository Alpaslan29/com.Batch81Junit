package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class  TestBaseBeforeAfter {
   protected WebDriver driver;
   protected Actions actions;
  // protected String tarih;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions=new Actions(driver);
        //LocalTime date = LocalTime.now();
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYMMHHmmss");
       // tarih = date.format(formatter);

    }
    @After
    public void tearDown(){
        //driver.close();
    }
}
