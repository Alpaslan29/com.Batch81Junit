package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PratikCalısma {
  /*
    1. Tarayıcıyı başlatın
    2. 'http://automationexercise.com' url'sine gidin
    3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
    4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
    5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
    6. Adı ve e-posta adresini girin
    7. 'Kaydol' düğmesini tıklayın
    8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
    9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
    10. 'Bültenimize kaydolun!' onay kutusunu seçin.
    11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
    12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
    13. 'Hesap Oluştur düğmesini' tıklayın
    14. 'HESAP OLUŞTURULDU!' görünür
    15. 'Devam' düğmesini tıklayın
    16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
    17. 'Hesabı Sil' düğmesini tıklayın
    18. 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın

*/
    static  WebDriver driver;

    @BeforeClass
    static public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //driver.get("");
    }
    @AfterClass
    static public void tearDown(){
        //driver.close();
    }
    // todo 2. 'http://automationexercise.com' url'sine gidin
    @Test
    public void test1(){
        driver.get("http://automationexercise.com");
    }
    // todo 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
    @ Test
    public void test2(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@ lang='en']")).isDisplayed());

    }
    // todo 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
    @Test
    public void test3(){
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
    }
    // todo 5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
    @Test
    public void test4(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());

    }
    // todo  6. Adı ve e-posta adresini girin
    @Test
    public void test5(){
        driver.findElement(By.xpath("//*[text()='signup-name']")).sendKeys("Ahmet CAN"+ Keys.ENTER);
        //driver.findElement(By.xpath("//*[@id='email_create']")).sendKeys("alpaslan_k79@hotmail.com"+ Keys.ENTER);


    }









}
