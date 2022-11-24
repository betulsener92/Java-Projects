package atm_proje.ikinci_cozum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner {
    //Müşteri No ve Şifreyi tutmak için HashMap oluşturduk.
    static Map<Integer,Integer> musteriBilgileri = new HashMap<>();
    //Müşteri No ve Hesaptaki parasını tutmak için HashMap oluşturduk.
    static Map<Integer,Float> toplamParaMiktarlari = new HashMap<>();
    //Kullanıcıdan veri almak için oluşturduk.
    static Scanner scan = new Scanner(System.in);
    //Kullanıcı giriş yaptıktan sonra, kullanıcın bilgilerini bu iki değişkene atayalım.
    //Ve işlemlerimizi bu iki değişkeni kullanarak yapalım.
    static int girisYapanKullanicinMusteriNumarasi = 0;
    static float girisYapanKullanicinHesabindakiPara = 0;
    public static void main(String[] args) {
        //			 KEY	   VALUE
        musteriBilgileri.put(12345678, 1876);
        musteriBilgileri.put(22222222, 1234);
        musteriBilgileri.put(98765432, 1453);
        musteriBilgileri.put(55554444, 2020);
        toplamParaMiktarlari.put(12345678, 120.0f);
        toplamParaMiktarlari.put(22222222, 1000.0f);
        toplamParaMiktarlari.put(98765432, 5.0f);
        toplamParaMiktarlari.put(55554444, 255.0f);
        girisEkrani();

    }
    private static void girisEkrani() {
        System.out.println("Musteri numaranizi giriniz : ");
        int musteriNo = scan.nextInt();
        if(musteriBilgileri.get(musteriNo) == null) {
            System.out.println("Boyle bir musteri yok.");
            girisEkrani();
            return;
        }else {
            System.out.println("Musteri numaraniz : " + musteriNo);
            System.out.println("Lutfen sifrenizi giriniz : ");
            int sifre = scan.nextInt();
            /// 12345678
            /// musteriBilgileri.get(12345678)
            if(musteriBilgileri.get(musteriNo) == sifre) {
                System.out.println("HOsGELDİNİZ");
                girisYapanKullanicinMusteriNumarasi = musteriNo;
                girisYapanKullanicinHesabindakiPara = toplamParaMiktarlari.get(musteriNo);
                menuGoster();
            }else {
                System.out.println("SİFRENİZ YANLIS.");
                girisEkrani();
                return;
            }
        }
    }
    private static void menuGoster() {
        //System.out.println("SEÇİM YAPINIZ : \n1-PARA ÇEK\n2-PARA YÜKLE\n3-TOPLAM PARAMI GÖR\n4-ÇIKIŞ YAP");
        System.out.println("SEÇİM YAPINIZ : \n");
        System.out.println("1-PARA ÇEK");
        System.out.println("2-PARA YÜKLE");
        System.out.println("3-TOPLAM PARAMI GÖR");
        System.out.println("4-ÇIKIŞ YAP");
        int secim = scan.nextInt();
        switch (secim) {
            case 1:
                paraCek();
                break;
            case 2:
                System.out.println("Ne kadar para yatırmak istersiniz ? ");
                float miktar = scan.nextFloat();
                girisYapanKullanicinHesabindakiPara = girisYapanKullanicinHesabindakiPara + miktar;
                //üstteki satırla aynı işlemi yapar : girisYapanKullanicinHesabindakiPara += miktar;
                System.out.println("Para hesaba yatırıldı.");
                System.out.println("Toplam paranız : " + girisYapanKullanicinHesabindakiPara);
                toplamParaMiktarlari.put(girisYapanKullanicinMusteriNumarasi, girisYapanKullanicinHesabindakiPara);
                menuGoster();
                break;
            case 3:
                System.out.println("Hesabınızdaki Toplam Para :" + girisYapanKullanicinHesabindakiPara);
                menuGoster();
                break;
            case 4:
                System.out.println("Çıkış yapıldı.");
                girisEkrani();
                break;
            default:
                System.out.println("YANLIŞ SEÇİM.");
                menuGoster();
                break;
        }
    }
    private static void paraCek() {
        System.out.println("Hesabınızdan ne kadar para çekmek istiyorsunuz : ");
        float miktar = scan.nextFloat();
        if(miktar > girisYapanKullanicinHesabindakiPara) {
            System.out.println("Hesabınızda sadece " + girisYapanKullanicinHesabindakiPara + " lira var");
            paraCek();
        }else {
            girisYapanKullanicinHesabindakiPara = girisYapanKullanicinHesabindakiPara - miktar;
            toplamParaMiktarlari.put(girisYapanKullanicinMusteriNumarasi, girisYapanKullanicinHesabindakiPara);
            System.out.println("Para Çekildi");
            System.out.println("Kalan Tutar : " + girisYapanKullanicinHesabindakiPara);
            menuGoster();
        }
    }
}
