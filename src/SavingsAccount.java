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

