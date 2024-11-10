import java.util.InputMismatchException;
import java.util.Scanner;

/*
    The aim of this project is simple and literal. Guess the secret number. There will be a secret number, and the maximum that can be generated is up to 100. Between 1 and 100, write down your guess of the secret number

Depending on the number of errors, the message displayed to the user changes. The game only has 3 text options.

from 1 to 4
from 5 to 10
from 11 to 100

Well, I hope you enjoy this minigame.

Translated with DeepL.com (free version)
* */


public class Main {

    public static void initialGameMessage(){
        System.out.println("----SEJA BEM VINDO AO JOGO DE ADVINHAR O NUMERO----");
        System.out.println();
        System.out.println("""
                          ▄▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▄
                         █░░░█░░░░░░░░░░▄▄░██░█
                         █░▀▀█▀▀░▄▀░▄▀░░▀▀░▄▄░█
                         █░░░▀░░░▄▄▄▄▄░░██░▀▀░█
                         ─▀▄▄▄▄▄▀─────▀▄▄▄▄▄▄▀
                """);
    }

    public static void playerWinMessage(int count){
        if (count == 0){
            System.out.println("Vai jogar na loteria, pois sua sorte é grande!!!");
            System.out.println("""
                    ─────────────────────────────────
                    ────────▄███▄───────▄███▄────────
                    ───────███████─────███████───────
                    ──────█████████───█████████──────
                    ────▄███████████─███████████▄────
                    ──▄█████████████─█████████████▄──
                    ▄███████████████─███████████████▄
                    ████████████████─████████████████
                    ████████████████─████████████████
                    ▀███████████████████████████████▀
                    ──▀███████████████████████████▀──
                    ────▀███████████████████████▀────
                    ──────────▀███████████▀──────────
                    ────▄████████████████████████▄───
                    ─▄█████████████████████████████▄─
                    █████████████████████████████████
                    █████████████████████████████████
                    ███████████████─██─██████████████
                    ███████████████─██─██████████████
                    ─██████████████─██─████████████▀─
                    ──▀████████████─██─██████████▀───
                    ────▀█████████──██──████████▀────
                    ──────███████───██───██████▀─────
                    ───────▀███▀────███───▀███▀──────
                    ─────────────────███─────────────
                    ──────────────────███────────────
                    ───────────────────███───────────
                    """);
        } else if (count > 0 && count <= 4) {
            System.out.println("Seu raciocinio é excelente, parabens!");
            System.out.println("""
                    ──────▄▀▄─────▄▀▄
                    ─────▄█░░▀▀▀▀▀░░█▄
                    ─▄▄──█░░░░░░░░░░░█──▄▄
                    █▄▄█─█░░▀░░┬░░▀░░█─█▄▄█
                    """);
        } else if (count <= 10 && count >= 5) {
            System.out.println();
        } else {
            System.out.println("Parabens pela Vitoria. Não teve muita sorte mais foi um bom jogo!");
            System.out.println("Tome um um café");
            System.out.println("""
                    ─▄▀─▄▀
                    ──▀──▀
                    █▀▀▀▀▀█▄
                    █░░░░░█─█
                    ▀▄▄▄▄▄▀▀
                    
                    """);
        }
    }

    public static void notEqualMessage(int userNum, int secretNum){
        if (userNum > secretNum){
            System.out.println("Seu numero é MAIOR que o numero secreto");
        } else {
            System.out.println("Seu numero é MENOR que o numero secreto");
        }
    }
    // |------------------------------Main------------------------------|
    public static void main(String[] args) {
        int RandomNum = (int)(Math.random() * 101);
        int UserNum;
        int Count = 0;

        Scanner myScanner = new Scanner(System.in);
        initialGameMessage();
        while(true){
            System.out.print("---Qual é o numero secreto?: ");
            try{
                UserNum = myScanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("---Inserir apenas numeros por favor!---");
                continue;
            }

            if (UserNum == RandomNum) {
                playerWinMessage(Count);
                break;
            } else {
                notEqualMessage(UserNum, RandomNum);
                Count++;
            }
        }

    }
}