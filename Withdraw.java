import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Withdraw extends JPanel
{
	public Withdraw(ArrayList<BankAccount> accounts)
	{	
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		
		JLabel name = new JLabel("Name: ");
		this.add(name, c);
		
		JTextField nameInput = new JTextField(15);
		c.gridx = 1;
		c.gridy = 0;
		this.add(nameInput,c);
		
		JLabel accNum = new JLabel("Account Number: ");
		c.gridx = 0;
		c.gridy = 1;
		this.add(accNum, c);
		
		JTextField accNumInput = new JTextField(15);
		c.gridx = 1;
		c.gridy = 1;
		this.add(accNumInput,c);
		
		JLabel withdrawVal = new JLabel("Withdraw Value: ");
		c.gridx = 0;
		c.gridy = 2;
		this.add(withdrawVal, c);
		
		JTextField withdrawValInput = new JTextField(15);
		c.gridx = 1;
		c.gridy = 2;
		this.add(withdrawValInput,c);
		
		JLabel error = new JLabel("There has been an error in processing your request. Please try again.");
		error.setVisible(false);
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 4;
		this.add(error, c);
		
		JButton withdraw = new JButton("Withdraw");
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 3;
		withdraw.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ev) 
					{
						try
						{
							boolean absent = true;
							for(BankAccount account : accounts)
							{
								if (account.getName().toLowerCase().equals(nameInput.getText().toLowerCase()) && account.getAccountNum() == Integer.parseInt(accNumInput.getText()))
								{
									account.withdraw(Double.parseDouble(withdrawValInput.getText()));
									absent = false;
									nameInput.setText("");
									accNumInput.setText("");
									withdrawValInput.setText("");
									error.setVisible(false);
								}
							}
							if (absent)
							{
								error.setVisible(true);
							}
						}
						catch (IllegalArgumentException e)
						{
							error.setVisible(true);
						}
					}
				});
		this.add(withdraw, c);
	}
}
