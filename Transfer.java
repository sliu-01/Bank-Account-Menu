import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Transfer extends JPanel
{
	public Transfer(ArrayList<BankAccount> accounts)
	{	
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		
		JLabel yourName = new JLabel("(Your) Name: ");
		this.add(yourName, c);
		
		JTextField yourNameInput = new JTextField(15);
		c.gridx = 1;
		c.gridy = 0;
		this.add(yourNameInput,c);
		
		JLabel yourAccNum = new JLabel("(Your) Account Number: ");
		c.gridx = 0;
		c.gridy = 1;
		this.add(yourAccNum, c);
		
		JTextField yourAccNumInput = new JTextField(15);
		c.gridx = 1;
		c.gridy = 1;
		this.add(yourAccNumInput,c);
		
		JLabel receiverName = new JLabel("Name of the Recipient: ");
		c.gridx = 0;
		c.gridy = 2;
		this.add(receiverName, c);
		
		JTextField receiverNameInput = new JTextField(15);
		c.gridx = 1;
		c.gridy = 2;
		this.add(receiverNameInput,c);
		
		JLabel receiverAccNum = new JLabel("Account of the Recipient: ");
		c.gridx = 0;
		c.gridy = 3;
		this.add(receiverAccNum, c);
		
		JTextField receiverAccNumInput = new JTextField(15);
		c.gridx = 1;
		c.gridy = 3;
		this.add(receiverAccNumInput,c);
		
		JLabel withdrawVal = new JLabel("Amount Withdrawn: ");
		c.gridx = 0;
		c.gridy = 4;
		this.add(withdrawVal, c);
		
		JTextField withdrawValInput = new JTextField(15);
		c.gridx = 1;
		c.gridy = 4;
		this.add(withdrawValInput,c);
				
		JLabel error = new JLabel("There has been an error in processing your request. Please try again.");
		error.setVisible(false);
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 6;
		this.add(error, c);
		
		JButton transfer = new JButton("Transfer");
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 5;
		transfer.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ev) 
					{
						try
						{
							boolean absent = true;
							for(BankAccount account : accounts)
							{
								if (account.getName().toLowerCase().equals(yourNameInput.getText().toLowerCase()) && account.getAccountNum() == Integer.parseInt(yourAccNumInput.getText()))
								{
									for(BankAccount accountB : accounts)
									{
										if (accountB.getName().toLowerCase().equals(receiverNameInput.getText().toLowerCase()) && accountB.getAccountNum() == Integer.parseInt(receiverAccNumInput.getText()))
										{
											account.withdraw(Double.parseDouble(withdrawValInput.getText()));
											absent = false;
											yourNameInput.setText("");
											yourAccNumInput.setText("");
											receiverNameInput.setText("");
											receiverAccNumInput.setText("");
											withdrawValInput.setText("");
											error.setVisible(false);
										}
									}
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
		this.add(transfer, c);
	}
}