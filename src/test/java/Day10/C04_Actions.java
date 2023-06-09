package Day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {
    @Test
    public void test(){
        //https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        // - Cizili alan bölüm uzerinde sag click yapalim
        WebElement cizilialan=driver.findElement(By.id("hot-spot"));
        Actions action=new Actions(driver);
        action.contextClick(cizilialan).perform();
        //Alert'te cikan yazinin "You selected a context menu" oldugunu test edelim.
        String expectedYazi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        //Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText()); kısa kodu
        // Tamam diyerek alert'i kapatalim
        driver.switchTo().alert().accept();

   // -Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
        List<String> windowlist = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowlist.get(1));


   // -Acilan sayfada h1 taginda "Elemental Selenium" yazdigini test edelim
        Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//h1")).getText());
        /*
        String actualWord = driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();
        String expectedWord = "Elemental Selenium";
        Assert.assertEquals(actualWord, expectedWord);
         */

    }
}
