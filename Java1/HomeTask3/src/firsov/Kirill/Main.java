package firsov.Kirill;

import java.util.Scanner;
import java.util.Random;

public class Main {

    private static Scanner scanner;

    public static void main(String[] args) {

        boolean gaming;
        do {
            boolean flag = true;
            int attempts = 3;

            int min = 0;
            int max = 9;
            Random rnd = new Random(System.currentTimeMillis());
            int number = min + rnd.nextInt(max - min + 1);
            System.out.println("You have 3 attempts to win!");
            System.out.println("Good luck!");
            System.out.println(number);
            while (flag) {
                if (attempts > 0) {
                    System.out.println("Your answer is:");
                    scanner = new Scanner(System.in);
                    int answer = scanner.nextInt();
                    System.out.println(answer);

                    if (answer != number && answer <= max) {
                        attempts--;
                        if (answer < number) {
                            System.out.println("Your number is less than computers number!");
                        } else {
                            System.out.println("Your number is bigger than computers number!");
                        }
                    } else if (answer > number) {
                        System.out.println("Your number is bigger than 9");
                        System.out.println("Try again");
                    } else if (answer == number) {
                        System.out.println("Congrats! You won!");
                        flag = false;
                    }
                }else{

                    System.out.println("Game over!");
                    System.out.println("No more attempts!");
                    flag = false;
                }
            }
            System.out.println("Try again?");
            System.out.println("1 - yes; 0 - no");

            int replay = scanner.nextInt();
            gaming = replay == 1;

            }while (gaming);    
    }
}
