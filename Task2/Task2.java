package Stackcl;
import java.util.Scanner;
import java.util.Random;
public class Task2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int randomNumber = rand.nextInt(100)+ 1;
        int guess, chance=0;
        System.out.println("Guess the number between 1 and 100");
        do {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();

            if (guess > randomNumber) {
                System.out.println("Too high! Try again.");
                chance++;
            } 
            else if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
                chance++;
            } 
            else {
                System.out.println("Correct! You guessed the number in "+chance+" attempts");
            }

        } while (guess != randomNumber);

        sc.close();
    }
}



