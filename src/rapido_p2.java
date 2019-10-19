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
class Application {
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();
        int i;

        System.out.println("Initial deposits");
        saver1.setBalance(2000.00);
        saver2.setBalance(3000.00);
        rapido_p2.modifyInterestRate(.04);

        System.out.printf("Saver 1's balance is: %.2f\n", saver1.getBalance());
        System.out.printf("Saver 2's balance is: %.2f\n", saver2.getBalance());

        for (i = 0;i < 12; i++){
            saver1.addInterest(rapido_p2.calculateMonthlyInterest(saver1.getBalance()));
            saver2.addInterest(rapido_p2.calculateMonthlyInterest(saver2.getBalance()));
        }
        System.out.println("\nAfter 1 year at 4%");
        System.out.printf("Saver 1's balance is: %.2f\n", saver1.getBalance());
        System.out.printf("Saver 2's balance is: %.2f\n", saver2.getBalance());

        rapido_p2.modifyInterestRate(.05);

        saver1.addInterest(rapido_p2.calculateMonthlyInterest(saver1.getBalance()));
        saver2.addInterest(rapido_p2.calculateMonthlyInterest(saver2.getBalance()));

        System.out.println("\nAfter 1st Month of new Interest at 5%");
        System.out.printf("Saver 1's balance is: %.2f\n", saver1.getBalance());
        System.out.printf("Saver 2's balance is: %.2f\n", saver2.getBalance());
    }
}
class SavingsAccount {
    private double savingsBalance;
    public void setBalance(double balance){
        savingsBalance = balance;
    }
    public void addInterest(double interest){
        savingsBalance = savingsBalance + interest;
    }
    public double getBalance(){
        return savingsBalance;
    }
}

