package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C02_WebTable extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Bir class oluşturun : C02_WebTables
        //login( ) metodun oluşturun ve oturum açın.
        //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        login();
        //Username : manager
        //Password : Manager1!

        //table( ) metodu oluşturun
        table();
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        //printRows( ) metodu oluşturun //tr
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //4.satirdaki(row) elementleri konsolda yazdırın.
    }

    private void table() {
        /*
Tabloda <table> tagı altında tablonun baslıgını gosteren <thead> tagı bulunur.
Eger baslikda satir(row) varsa <thead> tagı altinda <tr> (satır-row) tagı vardır.
Ve baslıkdaki sutunlara yani hucrelere(cell) de <th> tagı ile ulasilir.
Baslıgın tablodaki verilere <tbody> tagı ile altındaki satırlara(row) <tr> tagı ile sutunlara yani
hucrelere <td> tagı ile ulasilir.
 */
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun Sayisi = "+sutunSayisi.size());

        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement baslıklar= driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Basliklar:  "+baslıklar.getText());
        WebElement body = driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum Body "+ body.getText());
        //printRows( ) metodu oluşturun //tr
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlist = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println(" Tablodaki Satir sayisi: "+satirlist.size());
        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirlist.stream().forEach(t-> System.out.println(t.getText()));
        //4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("Tablodaki 4. satır : "+driver.findElement(By.xpath("//tbody//tr[4]")).getText());
    }

    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();

    }
}
