import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class LoginTest implements ActionListener{

	public static JLabel jlab1 = new JLabel("Username:", SwingConstants.CENTER);
	public static JTextField jt = new JTextField("");
	public static JLabel jlab3 = new JLabel("Password:", SwingConstants.CENTER);
	public static JPasswordField jt2 = new JPasswordField("");
	public static JLabel jlab5 = new JLabel("", SwingConstants.CENTER);
	public static JButton jb = new JButton("Login");
	
	LoginTest()
	{
		JFrame jfrm = new JFrame("Login Window");
		jfrm.setSize(400, 120);
		jfrm.setLayout(new GridLayout(3,2,0,0));
		jfrm.setVisible(true);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jb.addActionListener(this);
		
		jfrm.add(jlab1);
		jfrm.add(jt);
		jfrm.add(jlab3);
		jfrm.add(jt2);
		jfrm.add(jlab5);
		jfrm.add(jb);
	}
	
	public static void main(String[]args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			new LoginTest();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Can add and change username and password here
		if(jt.getText().equals("SomeUserName5000") && jt2.getText().equals("Password5000"))
		{
			jlab5.setText("Success!");
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
				new GUIForCalculator();
				}
			});
		}
		else {
			JOptionPane.showMessageDialog(null, "Credentials Incorrect. Try Again.");
		}
	}
}
