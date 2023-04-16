package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {
        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resourse/ulkeler.xlsx";
        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu); // Olusturmus oldugumuz dosyayi sistemde isleme alir
        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        // WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis); // workbook objesiyle fis objesi ile akisa aldigimiz bie excell dosyasi create ettik
        //- WorkbookFactory.create(fileInputStream)
        //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1"); // Excell dosyamizda calismak istedigimiz sayfayi sectik
        //- Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3); // Sayfa 1 deki 3.satiri sectik
        //- Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3); // Satir secimi yaptiktan sonra hucre secimi yaptik
        System.out.println(cell);
        //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
        String expectedData= "Cezayir";
        String actualData= cell.toString();
        Assert.assertEquals(expectedData,actualData);

    }
}

