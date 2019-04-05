import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BankAccountGUIMain extends JFrame
{
	private ArrayList<BankAccount> accounts = new ArrayList<>();
	
	final double OVER_DRAFT_FEE = 15;
	final double RATE = .0025;
	final double TRANSACTION_FEE = 1.5;
	final double MIN_BAL = 300;
	final double MIN_BAL_FEE = 10;
	final double FREE_TRANSACTIONS = 10;
	
	public BankAccountGUIMain()
	{
		this.setTitle("Bank Account");
		this.setBounds(300, 200, 600, 400);
		this.setLayout(null);
		
		JLabel name = new JLabel("Name: ");
		name.setSize(150, 20);
		name.setLocation(new Point(10, 10));
		this.add(name);
		
		JTextField nameInput = new JTextField();
		nameInput.setSize(150, 30);
		nameInput.setLocation(new Point(60, 10));
		this.add(nameInput);
		
		JLabel accountType = new JLabel("Account Type: ");
		accountType.setSize(150, 20);
		accountType.setLocation(new Point(10, 50));
		this.add(accountType);
		
		String[] choices = {"", "Checking", "Savings"};
		JComboBox accountTypeChoice = new JComboBox(choices);
		accountTypeChoice.setSize(150, 30);
		accountTypeChoice.setLocation(new Point(100, 50));
		this.add(accountTypeChoice);
		
		JLabel initialBalance = new JLabel("Initial Balance: ");
		initialBalance.setSize(150, 20);
		initialBalance.setLocation(new Point(10, 90));
		this.add(initialBalance);
		
		JTextField initialBalanceInput = new JTextField();
		initialBalanceInput.setSize(150, 30);
		initialBalanceInput.setLocation(new Point(105, 90));
		this.add(initialBalanceInput);
		
		JButton createAccount = new JButton("Create Account");
		createAccount.setSize(150, 30);
		createAccount.setLocation(new Point(20, 130));
		createAccount.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						if (accountTypeChoice.getSelectedItem().equals("Checking"))
						{
							accounts.add(new CheckingAccount(nameInput.getText(), Double.parseDouble(initialBalanceInput.getText()), OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS));
						}
						else if (accountTypeChoice.getSelectedItem().equals("Savings"))
						{
							accounts.add(new SavingsAccount(nameInput.getText(), Double.parseDouble(initialBalanceInput.getText()), RATE, MIN_BAL, MIN_BAL_FEE));
						}
						nameInput.setText("");
						initialBalanceInput.setText("");
						accountTypeChoice.setSelectedItem("");
					}
				});
		this.add(createAccount);
		
		JButton displayAllAccounts = new JButton("Display All Accounts");
		displayAllAccounts.setSize(150, 30);
		displayAllAccounts.setLocation(new Point(190, 130));
		displayAllAccounts.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						for(BankAccount account : accounts)
						{
							if (account instanceof CheckingAccount)
							{
								System.out.println("Checking\t" + account.toString());
							}
							else 
							{
								System.out.println("Savings\t\t" + account.toString());
							}
						}
						System.out.println("");
						}			
				});
		this.add(displayAllAccounts);
				
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) 
	{
		new BankAccountGUIMain();
	}

}