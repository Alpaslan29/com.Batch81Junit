package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_readExcel {
    @Test
    public void readExcelTest1() throws IOException {
       //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resourse/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        //-Turkce baskentler sutununu yazdiralim
        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        //getLastRowNum() methodu bize excel sayfasındaki tüm satır numarasını verir
        System.out.println("Satır sayısı = "+sonSatir);
        String turkceBaskenler = "";
        for (int i = 0; i <= sonSatir; i++) {
            turkceBaskenler = workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println(turkceBaskenler);
        }
        /*
        Exceldeki bir dosyaya ve dosyadaki bir bölüme ulaşmak istediğimizde
        uygulayacağımız aşamalar :
        Ara-->dosyaYolu      --> String dosyaYolu="src/resources/ulkeler.xlsx";
        Windows Gezgini ile ac- ->FileInputStream    --> FileInputStream fis = new FileInputStream(dosyaYolu);
        Excel i ac              -->Workbook        --> Workbook workbook = WorkbookFactory.create(fis)
        workbook olusturduktan sonra :
        String actualData = workbook.
                getSheet("Sayfa1")
                .getRow(3)
                .getCell(3)
                .toString();
        Sayfa1 e git-->Sheet    --> getSheet()
        Satiri bul-->Row       --> getRow()
        Sutunu bul-->Cell     --> getCell()
        Secilen bolumu getir  --> toString()

         */
    }
}
