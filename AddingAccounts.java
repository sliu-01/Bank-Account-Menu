import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddingAccounts extends JPanel
{
	final double OVER_DRAFT_FEE = 15;
	final double RATE = .0025;
	final double TRANSACTION_FEE = 1.5;
	final double MIN_BAL = 300;
	final double MIN_BAL_FEE = 10;
	final double FREE_TRANSACTIONS = 10;
	
	public AddingAccounts(ArrayList<BankAccount> accounts)
	{	
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		
		JLabel name = new JLabel("Name:   ");
		this.add(name, c);
		
		JTextField nameInput = new JTextField(15);
		c.gridx = 1;
		c.gridy = 0;
		this.add(nameInput,c);
		
		JLabel accountType = new JLabel("Account Type:   ");
		c.gridx = 0;
		c.gridy = 1;
		this.add(accountType, c);
		
		String[] choices = {"", "Checking", "Savings"};
		JComboBox accountTypeChoice = new JComboBox(choices);
		c.gridx = 1;
		c.gridy = 1;
		this.add(accountTypeChoice,c);
		
		JLabel initialBalance = new JLabel("Initial Balance: ");
		c.gridx = 0;
		c.gridy = 2;
		this.add(initialBalance, c);
		
		JTextField initialBalanceInput = new JTextField(15);
		c.gridx = 1;
		c.gridy = 2;
		this.add(initialBalanceInput, c);
		
		JButton createAccount = new JButton("Create Account");
		c.gridx = 0;
		c.gridy = 3;
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
		this.add(createAccount, c);
		}
}
