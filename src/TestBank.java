public class TestBank {
    public static void main(String[] args){
        //Constructor
        CheckingAccount account = new CheckingAccount();

        //Create an account
        account.setFirstName("Noah");
        account.setLastName("TerBest");
        account.setAccountID(21246);
        account.setInterestRate(1.5);

        //Deposit
        account.deposit(100.0);

        //Withdrawal
        account.processWithdrawal(50.0);
        account.processWithdrawal(60.0);

        account.displayAccount();

    }
}
