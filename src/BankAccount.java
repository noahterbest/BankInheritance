public class BankAccount {
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    //Constructor
    public BankAccount(){
        this.balance = 0.0;
    }

    //Adds var amount to balance
    public void deposit(double amount){
        balance += amount;
    }

    //Subtracts var amount from balance
    public void withdrawal(double amount){
        balance -= amount;
    }

    public void accountSummary(){
        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println("Account ID:" + accountID);
        System.out.println("Balance: $" + balance);
    }

    //Getters and Setters
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setAccountID(int accountID){
        this.accountID = accountID;
    }

    public String getLastName(){
        return lastName;
    }

    public int getAccountID(){
        return accountID;
    }

    public double getBalance(){
        return balance;
    }

}
