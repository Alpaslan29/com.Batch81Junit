package day15;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Odev1 {
    @Test
    public void excelReadTest1() throws IOException {

        String dosyaYolu = "src/resourse/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        //        1.satirdaki 2.hucreye gidelim ve yazdiralim
        Sheet sheet= workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(0);
        Cell cell = row .getCell(1);
        System.out.println(cell);
        //  1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String birinciSatirİkinciHücre = cell.toString();
        System.out.println(birinciSatirİkinciHücre);

        //        2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String expecttedAfganistanBaskenti = "Kabil";
        String actualIkinciSatirDorduncuHucre = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        System.out.println(actualIkinciSatirDorduncuHucre);
        Assert.assertEquals(actualIkinciSatirDorduncuHucre,expecttedAfganistanBaskenti);
        //        Satir sayisini bulalim
        int satırsayısı= workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("Satır Sayısı: "+satırsayısı);

        //        Fiziki olarak kullanilan satir sayisini bulun
        int Kullanılansatırsayısı= workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println("Kullanılansatırsayısı = " + Kullanılansatırsayısı);
        //        Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        int rowCount = sheet.getLastRowNum();
        Map<String, String> mapList = new LinkedHashMap<>();
        for (int i = 0; i <= rowCount; i++) {
            row = sheet.getRow(i);
            Cell keyCell = row.getCell(0);
            String key = keyCell.getStringCellValue();
            Cell valuCell = row.getCell(1);
            String value = valuCell.getStringCellValue();
            mapList.put(key, value);
        }
    }
}
