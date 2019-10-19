import java.security.SecureRandom;
import java.util.Scanner;

public class rapido_p1{

    public static int generateNumber(){
        SecureRandom random = new SecureRandom();
        int x = random.nextInt(10000);
        //System.err.println("Number is "+ x );
        return x;
    }
    public static int question(int difficulty, int decision) {

        Scanner scnr = new Scanner(System.in);

        int firstRandom = 0;
        int secondRandom = 0;

        switch (difficulty){
            case 1:
                firstRandom = generateNumber()%10;
                secondRandom = generateNumber()%10;
                break;
            case 2:
                firstRandom = generateNumber()%100;
                secondRandom = generateNumber()%100;
                break;
            case 3:
                firstRandom = generateNumber()%1000;
                secondRandom = generateNumber()%1000;
                break;
            case 4:
                firstRandom = generateNumber()%10000;
                secondRandom = generateNumber()%10000;
                break;
        }

        //int answer = firstRandom * secondRandom;
        int response = 0;
        int cheer = generateNumber()%4;
        int answer = 0;

        //System.out.println("How much is " + firstRandom + " times " + secondRandom);
        //response = scnr.nextInt();
        if (decision == 5) decision = generateNumber()%4 + 1;

        switch (decision){
            case 1:answer =  firstRandom + secondRandom;
            response = add(firstRandom, secondRandom);
            break;
            case 2:answer =  firstRandom * secondRandom;
                response = multiply(firstRandom, secondRandom);
                break;
            case 3:answer =  firstRandom - secondRandom;
                response = subtract(firstRandom, secondRandom);
                break;
            case 4:
                while (secondRandom == 0) secondRandom = (int) (generateNumber()%(Math.pow((double)10,(double) difficulty)));
                answer =  firstRandom / secondRandom;
                response = divide(firstRandom, secondRandom);
                break;
            default:  { System.out.println("Invalid option try again, wrong answer credited");
            return 0;
            }
        }
        if (response != answer) {
            System.out.println("Sorry wrong answer, next question.");
            return 0;
        }
        else generateResponse(cheer);
        return 1;
        }
    public static void generateResponse(int cheer){
        switch (cheer){
        case 0:System.out.println("Very Good!");
        break;
        case 1:System.out.println("Excellent!");
        break;
        case 2:System.out.println("Nice work!");
        break;
        case 3:System.out.println("Keep up the good work!");
        break;
        default:System.out.println("Error!");
        }
        return;
    }
    public static int add(int firstRandom, int secondRandom){
        Scanner scnr = new Scanner(System.in);
        int response;

        System.out.println("How much is " + firstRandom + " plus " + secondRandom);
        response = scnr.nextInt();
        return response;
    }
    public static int multiply(int firstRandom, int secondRandom){
        Scanner scnr = new Scanner(System.in);
        int response;

        System.out.println("How much is " + firstRandom + " times " + secondRandom);
        response = scnr.nextInt();
        return response;
    }
    public static int subtract(int firstRandom, int secondRandom){
        Scanner scnr = new Scanner(System.in);
        int response;

        System.out.println("How much is " + firstRandom + " minus " + secondRandom);
        response = scnr.nextInt();
        return response;
    }
    public static int divide(int firstRandom, int secondRandom){
        Scanner scnr = new Scanner(System.in);
        int response;

        System.out.println("How much is " + firstRandom + " divided by " + secondRandom);
        System.out.println("(Round down to whole number or 0.  (ex: 5 / 6 is equal to 0)");
        response = scnr.nextInt();
        return response;
    }
    public static int difficulty(){
        Scanner scnr = new Scanner(System.in);
        int difficulty;
        System.out.println("Please choose difficulty: (1-4)");
        difficulty = scnr.nextInt();
        return difficulty;
    }
    public static int decision(){
        Scanner scnr = new Scanner(System.in);
        int decision;

        System.out.println("Please pick what type of problem you would like to solve\n" +
                "(1) Addition\n" +
                "(2) Multiplication\n" +
                "(3) Subtraction\n" +
                "(4) Division\n" +
                "(5) Random\n" +
                "(1-5 only): ");
        decision = scnr.nextInt();

        return decision;
    }
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        int i;
        int difficulty;
        int decision;
        final int TRIES = 10;
        double score;
        double avg;
        char choice = 'y';
        while (choice ==  'y' || choice == 'Y') {
            score = 0;

            difficulty = difficulty();
            decision = decision();

            for (i = 0; i < TRIES; i++) {
                if (question(difficulty, decision) > 0) score++;
            }
            //System.out.println("Your score is: " + score);
            avg = (score / TRIES) * 100;
            System.out.println("You got " + (int)score + " right and " + (10 - (int)score) + " wrong");
            System.out.println("Your average is: " + avg);
            if (avg >= 75) System.out.println("Congratulations, you are ready to go to the next level!");
            else System.out.println("Please ask your teacher for extra help.");

            System.out.println("Would you like to try again? (y/n)");

            choice = scnr.next().charAt(0);

        }

    }

}
