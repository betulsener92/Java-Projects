package atm_proje.ilk_cozum;

import ATM_Projesi.Methodlar;

public class GirisEkrani {
    public static void main(String[] args) {

        System.out.println("Hosgeldiniz");
        Methodlar obj1 = new Methodlar();
        obj1.getIdPasword().put(12345678, 1876);
        obj1.getIdPasword().put(22222222, 1234);
        obj1.getIdPasword().put(98765432, 1453);
        obj1.getIdPasword().put(55554444, 2020);

        obj1.getIdMoney().put(12345678, 120.0);
        obj1.getIdMoney().put(22222222, 3000.0);
        obj1.getIdMoney().put(98765432, 7000.0);
        obj1.getIdMoney().put(55554444, 50.0);

        obj1.kontrolId();

    }
}
