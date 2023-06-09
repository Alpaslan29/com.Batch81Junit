package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_FileExistsDownLoad {
    @Test
    public void test1() {
       /*
        String farkliBolum = System.getProperty("user.home");
        //"C:\\Users\\zehra\\OneDrive\\Desktop\\text.txt" --> masa üstündeki dosyanın yolu
        String ortakBolum = "\\OneDrive\\Desktop\\text.txt";
        String masaUstuDosyaYolu = farkliBolum+ortakBolum; // Masaüstündeki dosya yolunu gösterir
        System.out.println(masaUstuDosyaYolu); //"C:\\Users\\zehra\\OneDrive\\Desktop\\text.txt"
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        */

        String dosyaYolu = "C:\\Users\\zehra\\OneDrive\\Desktop\\text.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        /*
        Bir web sitesinden indirdiğimiz yada windows içinde oluşturduğumuz dosyanın indiğini yada orda olduğunu
        test edebilmem için o dosyanın üzerine shift tuşuna basılı olarak sağ klik yapıp dosyanın yolunu kopyalayıp
        bir string değişkene atarız ve dosyayı doğrulamak için
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); bu methodu kullanırız
         */

    }

}
