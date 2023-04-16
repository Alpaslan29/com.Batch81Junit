package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_ActionsHomework extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Yeni Class olusturun ActionsClassHomeWork
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        //driver.get("http://webdriveruniversity.com/Actions");
        // 2- Hover over Me First" kutusunun ustune gelin
        //driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]")).click();
        //Link 1" e tiklayin
        //Popup mesajini yazdirin
        //Popup'i tamam diyerek kapatin
        //“Click and hold" kutusuna basili tutun
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        //8- “Double click me" butonunu cift tiklayin


            driver.get("http://webdriveruniversity.com/Actions");
            Actions actions=new Actions(driver);
            WebElement dropbtn1=driver.findElement(By.xpath("//*[@class='dropbtn'][1]"));
            actions.moveToElement(dropbtn1).perform();
            driver.findElement(By.xpath("//*[@class='list-alert'][1]")).click();
            System.out.println(driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
            WebElement clickAndHoldButton=driver.findElement(By.xpath("//div[@id='click-box']"));
            actions.clickAndHold(clickAndHoldButton).perform();
            System.out.println(clickAndHoldButton.getText());
            WebElement doubleClikMeButton=driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
            actions.doubleClick(doubleClikMeButton).perform();

        }

}
