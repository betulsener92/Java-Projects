package Proje_MaasHesaplama;

public class MaasHesapla implements MaasArtir,Vergi{

    @Override
    public double yillikEkstra(int calismaYili) {
        System.out.println("Yillik ekstra: " +calismaYili*100);   //bunu ekranda gormek icin yazdik
        return calismaYili*100;
    }

    @Override
    public double saatlikEkstra(int calismaSaati) {
        if (calismaSaati-160>0){
            System.out.println("saatlikEkstra = " + calismaSaati*100);
            return (calismaSaati-160)*10;
        }else {
            System.out.println("saatlikEkstra: "+0);
            return 0;
        }
    }

    @Override
    public double vergi(double brutMaas, int calismaYili) {
        if (calismaYili>10){
            System.out.println("Vergi: "+brutMaas*0.3);
            return brutMaas*0.3;
        }else {
            System.out.println("Vergi: "+brutMaas*0.2);
            return brutMaas*0.2;
        }
    }
    public double netMaas(double brutMaas, int calismaYili, int calismaSaati){
        return brutMaas+yillikEkstra(calismaYili)+saatlikEkstra(calismaSaati)-vergi(brutMaas,calismaYili);
    }
}
