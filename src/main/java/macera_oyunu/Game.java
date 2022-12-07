package macera_oyunu;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Game {
    public Scanner input = new Scanner(System.in);



    public void start(){
        System.out.println("Oyunumuza Hoşgeldiniz");
        System.out.println("Nickname giriniz");
        String gamerName = input.nextLine();
        Player play = new Player(gamerName);
        System.out.println("Lutfen bir karakter seciniz");
        play.selectChar();

    }
}
