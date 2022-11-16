package Proje_MaasHesaplama;

public class Runner {

    public static void main(String[] args) {
        MaasHesapla ali = new MaasHesapla();
        double alininMaasi = ali.netMaas(10000,20,170);
        System.out.println("alininMaasi = " + alininMaasi);

    }
}
