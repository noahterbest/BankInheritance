import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankGUI extends JFrame implements ActionListener{
    // Variables  n' Stuff
    private CheckingAccount account;
    private JPanel panel;
    private JTextField initialField, depositField, withdrawField;
    private JLabel spacerLabel, withdrawLabel, balanceLabel, depositLabel;
    private JButton setBtn, depositBtn, withdrawBtn, showBtn, exitBtn;

    public BankGUI(){
        //Constructor for account
        account = new CheckingAccount();

        //Checking Account creation
        account.setFirstName("Noah");
        account.setLastName("TerBest");
        account.setInterestRate(1);
        account.setAccountID(12345);

        // Set up the frame
        setTitle("Bank Balance GUI");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centers window

        // Create and configure panel
        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10)); // hgap, vgap for spacing
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Row 1: Label and text field
        JLabel instructionLabel = new JLabel("Enter initial balance:");
        initialField = new JTextField(10);

        panel.add(instructionLabel);  // ← Add label first (left column)
        panel.add(initialField);     // ← Then field (right column)

        // Row 2: Button and spacer
        setBtn = new JButton("Set Initial Balance");  // Use instance variable
        panel.add(setBtn);
        spacerLabel = new JLabel(""); // spacer
        panel.add(spacerLabel);

        //Row 3. Deposit
        depositLabel = new JLabel("Deposit Amount:");
        depositField = new JTextField(10);
        panel.add(depositLabel);
        panel.add(depositField);

        depositBtn = new JButton("Deposit");
        panel.add(depositBtn);
        panel.add(spacerLabel); //spacer

        //R0w 4. Withdraw
        withdrawLabel = new JLabel("Withdraw amount:");
        withdrawField = new JTextField(10);
        panel.add(withdrawLabel);
        panel.add(withdrawField);

        withdrawBtn = new JButton("Withdraw");
        panel.add(withdrawBtn);
        panel.add(spacerLabel);

        //Row 5. Show Balance
        showBtn = new JButton("Show Balance");
        panel.add(showBtn);

        balanceLabel = new JLabel("Balance: 0.00"); //init display
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(balanceLabel);

        //Row 6: exit
        exitBtn = new JButton("Exit");
        panel.add(exitBtn);
        panel.add(spacerLabel);

        //Listeners
        setBtn.addActionListener(this);
        depositBtn.addActionListener(this);
        withdrawBtn.addActionListener(this);
        showBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        //testers
        add(panel);
        setVisible(true);
    }

    private void updateBalanceLabel(){
        balanceLabel.setText(String.format("Balance: $%.2f", account.getBalance()));
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == setBtn){
            //set balance
            System.out.println("Set Balance");
            int count = 0;
            try{
                if(count > 0){
                    System.out.println(count);
                    throw new RuntimeException();
                } else {
                    double amount = Double.parseDouble(initialField.getText());
                    if(amount < 0){
                        throw new NumberFormatException(); //dont accept negatives
                    }
                    account.deposit(amount);
                    initialField.setText(""); //clears field to 0
                    updateBalanceLabel();
                    System.out.println("Balance Set");
                    count = 1;
                    System.out.println(count);
                }
            } catch (NumberFormatException exception){
                System.out.println("Number must be ggreater then 0.");
            } catch (RuntimeException exception){
                System.out.println("Balance already set");
            }

        } else if (e.getSource() == depositBtn) {
            //deposit
            try{
                double amount = Double.parseDouble(depositField.getText());
                if (amount <= 0 ){
                    throw new NumberFormatException();
                }
                account.deposit(amount);
                depositField.setText(""); //resets text
                updateBalanceLabel();
                System.out.println("Deposit");
            } catch (NumberFormatException exception){
                System.out.println("Number must be greater then 0.");
            }
        } else if (e.getSource() == withdrawBtn) {
            //withdraw
            try{
                double amount = Double.parseDouble(withdrawField.getText());
                if (amount <= 0){
                    throw new NumberFormatException();
                }
                account.processWithdrawal(amount);
                withdrawField.setText(""); //reset
                updateBalanceLabel();
            } catch (NumberFormatException exception){
                System.out.println("Number must be greater then 0.");
            }
        } else if (e.getSource() == showBtn) {
            //show balance
            updateBalanceLabel();
            System.out.println("Balance Refreshed");
        } else if (e.getSource() == exitBtn) {
            //exit
            System.out.println("exit");
            System.exit(0);
        }
    }

    public static void main(String []args){
        SwingUtilities.invokeLater(() -> new BankGUI());
    }

}
