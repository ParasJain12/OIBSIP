import java.util.Scanner;
import java.util.Random;

public class Task_Two 
{
    public static void main(String arg[]) 
    {
        Random rn = new Random();
        int random_number = rn.nextInt(100);
        int turns = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("***************Number Guessing Number***************");
        System.out.println("Guess a Number between 1 to 100");
        System.out.println("You will have 10 Turns to play this Game!");
        System.out.println("Start! All The Best");
        int guess_number;
        int i = 0;
        boolean winner = false;
        while (winner == false) 
        {
            guess_number = sc.nextInt();
            turns++;

            if (guess_number == random_number) 
            {
                winner = true;
            } 
            else if (i > 8) 
            {
                System.out.println("You loose the Game!");
                System.out.println("Right Answer is : " + random_number);
                return;
            } 
            else if (guess_number < random_number) 
            {
                i++;
                System.out.println("Your Guess Number is lower than right Guess Number!");
                System.out.println("Turns left after this move: " + (10 - i));
            }
            else if (guess_number > random_number) 
            {
                i++;
                System.out.println("Your Guess Number is higher than right Guess Number!");
                System.out.println("Turns left after this move: " + (10 - i));
            }
        }
        System.out.println("You win the Game! Congratulations");
        System.out.println("Right Number was: " + random_number);
        System.out.println("You completed in " + turns + " turns !Keep It Up");
        System.out.println("Your score of the game is : " + ((11 - turns) * 10) + " out of 100");
    }
}