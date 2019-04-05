import java.awt.CardLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankAccountMenu extends JFrame
{
	private ArrayList<BankAccount> accounts = new ArrayList<>();

	public BankAccountMenu()
	{
		this.setTitle("Bank Account Manager");
		this.setBounds(300, 200, 600, 400);
		this.setLayout(null);
		
		JPanel overall = new JPanel();
		CardLayout cl = new CardLayout();
		overall.setLayout(cl);
		
		JPanel home = new JPanel();
		overall.add(home, "home");
		cl.show(overall, "home");
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		AddingAccounts addingAccountsPanel = new AddingAccounts(accounts);
		overall.add(addingAccountsPanel, "Adding Accounts");
		
		JMenu account = new JMenu("Account Actions");
		menuBar.add(account);
		JMenuItem addAccount = new JMenuItem("Create an Account");
		
		account.add(addAccount);

		this.add(overall);
		
		this.setBounds(100, 100, 600, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		addAccount.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(overall,  "Adding Accounts");
				System.out.println("I");
			}
				
		});
	}
	
	public static void main(String[] args) 
	{
		new BankAccountMenu();
	}

}
