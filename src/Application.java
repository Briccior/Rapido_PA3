public class Application {
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
