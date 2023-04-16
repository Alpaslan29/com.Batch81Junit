package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JunitBeforAfter {

    WebDriver driver; //kullanabilmek icin class seviyesine tanımlandı

    @Before
    public void setUp(){
        // @Before kullaniyorsak method icin istedigimiz ismi kullanabiliriz ancak genel olarak kullanımı setUp seklindedir
        //@Before kullandığımızda testlerimizden önce yapmak zorunda oldugumuz driver objelerini yazmak yerine @Before ile bir kere yazarız
        //yani her testten önce burayı calıstır, sonra testlerimizi calıstır.
        // diğer testlerimizde rahat kullanabilmek icin bunu class seviyesinde tanımlamamız gerekir.
        //driver objesini direk kullanabilmek icin class seviyesine WebDriver driver yaz!!

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    //burada 1 defa before methodu calısır

    @Test
   // TODO @Ignore çalışmasını istemediğimiz testin başına yazılarak test devre dışı bırakılır
    public void method1(){
        driver.get("https://amazon.com");
        //burada 1 defa da after methodu calısır.
        //yani burada 3 defa method calısır, before, meethod1 ve after methodları.
    }
    @Test

    public void method2(){
        driver.get("https://techproeducation.com");
    }
    @Test
    public void method3(){
        driver.get("https://hepsiburada.com");
    }
    @After
    public void tearDown(){
        //en son kullanacağımız methodlar icin @After kullanırız.
        //genelde bunun icin method ismi tearDown kullanilir

        driver.close();
    }




}
