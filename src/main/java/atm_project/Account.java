package atm_project;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    //checking account==> paramizi tuttugumuz hesap
    //saving account==>birikim hesabi
    //para yatirma(deposit)
    //para cekme(withdraw)
    //para transfer

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    private int accountNumber;  //Hesap numarasi
    private int pinNumber;     //sifre

    private double checkingBalance;   //vadesiz hesap bakiye
    private double savingBalance;    //vadeli hesap bakiye

    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    Scanner input = new Scanner(System.in);

    //para cekme => paraCekmeIslemindenSonraKalanMiktar   amount = miktar

    private double calculateCheckingBalanceAfterWithDraw(double amount){
        checkingBalance = checkingBalance -amount;
        return checkingBalance;
    }

    //para yatırma => para yatırma isleminden sonra kalan bakiyeyi hesapla

    private double calculateCheckingBalanceAfterDeposit(double amount){
        checkingBalance = checkingBalance + amount;
        return checkingBalance;
    }

    // para cekme: saving hesabindan para cekildikten sonra kalan bakiye
    private double calculateSavingBalanceAfterWithDraw(double amount) {
        savingBalance = savingBalance - amount;
        return savingBalance;
    }

    //para yatırma => saving hesabina para yatirildiktan sonra kalan bakiye
    private double calculateSavingBalanceAfterDeposit(double amount){
        savingBalance = savingBalance + amount;
        return savingBalance;
    }

    //Para cekmek(checking hesap) icin musteri ile etkilesime gecelim
    public void getCheckingWithdraw(){
        displayCurrentAmount(checkingBalance);
        System.out.println("Cekmek istediginiz miktari giriniz");
        double amount = input.nextDouble();
        if (amount <= 0){
            System.out.println("Sifir veya eksi miktarlar gecersizdir");
            getCheckingBalance();   //methodun icinde kendisini tekrardan cagirma isine "recursive method" denir
        }else if (amount <= checkingBalance){
            calculateCheckingBalanceAfterWithDraw(amount);
            displayCurrentAmount(checkingBalance);
        }else {
            System.out.println("Yetersiz bakiye!");
        }
    }
    //Para yatirmak(checking hesap) icin musteri ile etkilesime gecelim
    public void getCheckingDeposit() {
        displayCurrentAmount(checkingBalance);
        System.out.println("Yatirmak istediginiz miktari giriniz");
        double amount = input.nextDouble();
        if (amount <= 0) {
            System.out.println("Sifir veya eksi miktarlar gecersizdir");
            getCheckingDeposit();
        }else {
            calculateCheckingBalanceAfterDeposit(amount);
            displayCurrentAmount(checkingBalance);
        }
    }
    //Para cekmek(saving hesap) icin musteri ile etkilesime gecelim
    public void getSavingAmount(){
        displayCurrentAmount(savingBalance);
        System.out.println("Cekmek istediginiz miktari giriniz");
        double amount = input.nextDouble();

        if (amount <= 0){
            System.out.println("Sifir veya eksi miktarlar gecersizdir");
            getCheckingWithdraw();
        }else if (amount <= savingBalance){
            calculateSavingBalanceAfterWithDraw(savingBalance);
            displayCurrentAmount(savingBalance);
        }else {
            System.out.println("Yetersiz bakiye!");
        }
    }
    //Para yatirmak(saving hesap) icin musteri ile etkilesime gecelim
    public void getSavingDeposit(){
        displayCurrentAmount(savingBalance);
        System.out.println("Yatirmak istediginiz miktari giriniz");
        double amount = input.nextDouble();
        if (amount <= 0){
            System.out.println("Sifir veya eksi miktarlar gecersizdir");
            getSavingDeposit();
        }else {
            calculateSavingBalanceAfterDeposit(amount);
            displayCurrentAmount(savingBalance);
        }
    }






    //son bakiyeyi goster
    public void displayCurrentAmount(double balance){
        System.out.println("Hesabinizda bulunan bakiye: "+ moneyFormat.format(balance));
    }


}
