package day11;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C05_Odev1 extends TestBaseBeforeAfter {
    /*
    Bir Class olusturalim KeyboardActions2
    https://html.com/tags/iframe/ sayfasina gidelim
    video’yu gorecek kadar asagi inin
    videoyu izlemek icin Play tusuna basin
    videoyu calistirdiginizi test edin

     */

    @Test
    public void test1(){
        driver.get("https://html.com/tags/iframe/");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        List<WebElement> iFrameList=new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iFrameList.get(0));
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        WebElement ytpLogo=driver.findElement(By.xpath("//*[@class='ytp-title-channel-logo']"));
        Assert.assertTrue(ytpLogo.isDisplayed());



    }


}
