import java.security.SecureRandom;
import java.util.Scanner;

public class rapido_p1{

    public static int generateNumber(){
        SecureRandom random = new SecureRandom();
        int x = random.nextInt(10000);
        //System.err.println("Number is "+ x );
        return x;
    }
    public static int question(int x) {

        Scanner scnr = new Scanner(System.in);

        int firstRandom = 0;
        int secondRandom = 0;

        switch (x){
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

        int answer = firstRandom * secondRandom;
        int response;
        int cheer = generateNumber()%4;

        System.out.println("How much is " + firstRandom + " times " + secondRandom);
        response = scnr.nextInt();

        if (response != answer) {
            System.out.println("Sorry wrong answer, next question.");
            return 0;
        }
        else {
          switch (cheer) {
                case 0: System.out.println("Very Good!");
                break;
                case 1: System.out.println("Excellent!");
                break;
                case 2: System.out.println("Nice work!");
                break;
                case 3: System.out.println("Keep up the good work!");
                break;
                default: System.out.println("Error!");
          }
        return 1;
        }
    }
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        int i;
        int difficulty;
        double score;
        double avg;
        char choice = 'y';
        while (choice ==  'y' || choice == 'Y') {
            score = 0;

            System.out.println("Please choose difficulty: (1-4)");
            difficulty = scnr.nextInt();

            for (i = 0; i < 4; i++) {
                if (question(difficulty) > 0) score++;
            }
            //System.out.println("Your score is: " + score);
            avg = (score / 4) * 100;
            System.out.println(avg);
            if (avg >= 75) System.out.println("Congratulations, you are ready to go to the next level!");
            else System.out.println("Please ask your teacher for extra help.");

            System.out.println("Would you like to try again? (y/n)");

            choice = scnr.next().charAt(0);

        }

    }

}
