package Proje02;

import java.util.HashMap;
import java.util.Scanner;

public class Methodlar {

        private HashMap<Integer,Integer> idPasword=new HashMap<>();
        private HashMap<Integer,Double> idMoney=new HashMap<>();

    public HashMap<Integer, Integer> getIdPasword() {
        return idPasword;
    }

    public void setIdPasword(HashMap<Integer, Integer> idPasword) {
        this.idPasword = idPasword;
    }

    public HashMap<Integer, Double> getIdMoney() {
        return idMoney;
    }

    public void setIdMoney(HashMap<Integer, Double> idMoney) {
        this.idMoney = idMoney;
    }

    Scanner scan=new Scanner(System.in);

        int id=0;
        public void kontrolId(){


            System.out.println("lutfen id numarisini giriniz");
            id =scan.nextInt();
            if (idPasword.containsKey(id)){
                paswordkontrol();

            }else System.out.println("Gecersiz id girdiniz");
            kontrolId();


        }

        private void paswordkontrol() {
            System.out.println("lutfen password giriniz");
            int pasword=scan.nextInt();
            boolean a=false;
            for(Integer w: getIdPasword().keySet()){
                if(w==id&&idPasword.get(id)==(pasword)){
                    System.out.println("giris basarili");
                    a=true;
                    break;
                }else
                    a=false;
            }
            if(a==false){ System.out.println("Password yanlis girdiniz");
                paswordkontrol();
            }else menugoster();

        }

        private void menugoster() {

            System.out.println("Hangi islemi yapmak istiyorsunuz\nPara Cekme:1 Para Yatirma:2" +
                    " Bakiye goruntuleme:3 Cikis:4");
            int islemno=scan.nextInt();

            switch (islemno){
                case 1: System.out.println("toplam bakiyeniz= "+idMoney.get(id)); paracek();   break;
                case 2: System.out.println("toplam bakiyeniz= "+idMoney.get(id)); parayatir(); break;
                case 3:
                    System.out.println("toplam bakiyeniz= "+idMoney.get(id));
                    menugoster();
                    break;
                case 4:
                    System.out.println("Gule gule");
                    break;


            }
        }

        private void parayatir() {
            System.out.println("Ne kadar para yatirmak istiyorsunuz?");
            double yatirpara=scan.nextDouble();
            double toppara=idMoney.get(id)+yatirpara;
            idMoney.put(id,toppara);
            System.out.println("Hesabınızdaki toplam para= "+idMoney.get(id));
            menugoster();
        }

        private void paracek() {
            System.out.println("Ne kadar para cekmek istiyorsunuz?");
            double cekpara=scan.nextDouble();
            if(cekpara>idMoney.get(id)){
                System.out.println("cekeceginiz para toplam bakiyeden fazla olamaz");
                paracek();
            }else {
                double klnpara=idMoney.get(id)-cekpara;
                idMoney.put(id,klnpara);
                System.out.println("kalan bakiyeniz= "+idMoney.get(id));
                menugoster();
            }
        }

    }

