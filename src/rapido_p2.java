import java.util.Scanner;
public class rapido_p2 {
    private static double annualInterestRate = 0;
    public static double calculateMonthlyInterest(double balance){
        balance = balance * annualInterestRate / 12;
        return balance;
    }
    public static void modifyInterestRate(double rate){
        annualInterestRate = rate;
        return;
    }
    public static double getAnnualInterestRate(){
        return annualInterestRate;
    }
}
