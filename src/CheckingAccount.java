public class CheckingAccount extends BankAccount{
    private double interestRate;

    //Constructor
    public CheckingAccount(){
        super(); //bank acounts constructor
        this.interestRate = 0.0;
    }

    //Setters and Getters
    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }

    public double getInterestRate(){
        return interestRate;
    }

    //Process Withdrawal for overdraft
    public void processWithdrawal(double amount){
        if(getBalance() - amount < 0){
            //overdraft subtract amount and then add 30 (fee)
            withdrawal(amount + 30);
            System.out.println("Overdrafted! $30 fee assessed.");
            System.out.println("Current balance: $" + getBalance());
        } else {
            withdrawal(amount);
        }
    }

    public void displayAccount(){
        accountSummary();
        System.out.println("Interest rate: " + interestRate + "%");
    }
}
