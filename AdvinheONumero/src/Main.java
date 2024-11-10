import java.util.InputMismatchException;
import java.util.Scanner;

/*
    The aim of this project is simple and literal. Guess the secret number. There will be a secret number, and the maximum that can be generated is up to 100. Between 1 and 100, write down your guess of the secret number

Depending on the number of errors, the message displayed to the user changes. The game only has 3 text options.

from 1 to 4
from 5 to 10
from 11 to 100

Well, I hope you enjoy this minigame.

*/


public class Main {

    public static void initialGameMessage(){
        System.out.println("----WELCOME TO THE NUMBER GUESSING GAME----");
        System.out.println();
        System.out.println("your objective will be to guess which number between 1 and 100 is hidden");
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
            System.out.println("""
                    
                    Luck is on your side, congratulations!!!
                    
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
            System.out.println("""
                    
                    Your thinking is excellent, congratulations!
                    
                    ──────▄▀▄─────▄▀▄
                    ─────▄█░░▀▀▀▀▀░░█▄
                    ─▄▄──█░░░░░░░░░░░█──▄▄
                    █▄▄█─█░░▀░░┬░░▀░░█─█▄▄█
                    """);
        } else if ( count >= 5 && count <= 10) {
            System.out.println("""
                    
                    As fast as the heart falls in love
                    
                    ─▄█▀█▄──▄███▄─
                    ▐█░██████████▌
                    ─██▒█████████─
                    ──▀████████▀──
                    ─────▀██▀─────-
                    
                    """);
        } else {
            System.out.println("""
                    
                    Congratulations on your victory. You weren't very lucky but it was a good game!
                    grab a cup of coffee
                    
                    ─▄▀─▄▀
                    ──▀──▀
                    █▀▀▀▀▀█▄
                    █░░░░░█─█
                    ▀▄▄▄▄▄▀▀
                    
                    """);
        }
    }

    public static void HigherOrLower(int userNum, int secretNum){
        if (userNum > secretNum){
            System.out.println("Your number is GREATER than the secret number");
        } else {
            System.out.println("Your number is LESS than the secret number");
        }
    }
    // |------------------------------Main------------------------------|
    public static void main(String[] args) {
        int RandomNum = (int)(Math.random()*101);
        int UserNum;
        int Count = 0;
        Scanner myScanner = new Scanner(System.in);

        initialGameMessage();
        while(true){
            System.out.print("---What is the secret number?: ");
            try{
                UserNum = myScanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("---Just enter numbers please!---");
                myScanner.nextLine();
                continue;
            }

            if (UserNum == RandomNum) {
                playerWinMessage(Count);
                System.out.printf("Number of attempts: %d%n", Count);
                break;
            } else {
                Count++;
                HigherOrLower(UserNum, RandomNum);
                System.out.printf("Attemp: %d%n", Count);
            }
        }

    }
}