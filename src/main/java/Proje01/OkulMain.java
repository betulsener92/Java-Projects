package Proje01;

import java.util.List;
import java.util.Scanner;

public class OkulMain {
    public static void main(String[] args) {
        Okul okul1 = new Okul("Galatasaray Lisesi",3);
        List<Ogrenci> okulunOgrencileri = okul1.getOgrenciler();

        int ogrenciSayisi = 1;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print(ogrenciSayisi + ".Öğrencinin Adı=");
            String ogrAd = scan.next();

            System.out.print(ogrenciSayisi + ".Öğrencinin Soyadı=");
            String ogrSoyad = scan.next();

            System.out.print(ogrenciSayisi + ".Öğrencinin Yaşı=");
            int yas = scan.nextInt();

            try {
                Ogrenci ogr = new Ogrenci(ogrAd, ogrSoyad, yas);
                okulunOgrencileri.add(ogr); // alınan ArrayListe ogrenci eklendi
                ogrenciSayisi++;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Yeni Öğrenci giriniz");
            }

        } while (ogrenciSayisi <= okul1.getMaxNumberofStudents());

        for (Ogrenci ogr : okul1.getOgrenciler()) {
            System.out.println("ogr = " + ogr);
        }
    }
}
