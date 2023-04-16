package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {
        // belirtilen satir no ve sutun no degerlerini parametre olarak alip

        // o cell'deki datayi konsola yazdirin
        // sonra sonucun konsolda yazanla ayni oldugunu dogrulayin
        int satir=12;
        int sutun= 2;

        String dosyaYolu ="src/resourse/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        String actualData = workbook.getSheet("Sayfa1")
                .getRow(satir-1)
                .getCell(sutun-1)
                .toString();
        // ındex 0 dan basladıgı için bizden istenen satıra veya sutuna ulaşmak için -1 yazmamız gerek
        System.out.println(actualData);
        String expectedData= "Baku";
        Assert.assertEquals(expectedData,actualData);



    }
}
