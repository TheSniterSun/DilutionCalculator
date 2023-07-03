import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GUIForCalculator implements ActionListener{

	public static JLabel jlab1 = new JLabel("Calculator (Like Units)", JLabel.CENTER);
	public static JLabel jlab2 = new JLabel("Dilution: C1V1 = C2V2", JLabel.CENTER);
	public static JLabel jlab3 = new JLabel("Version 1.0", JLabel.CENTER);
	public static JTextField jt1 = new JTextField("C1 or Concentration Given");
	public static JTextField jt2 = new JTextField("V1 or Volume Given");
	public static JLabel jlab6 = new JLabel("=", JLabel.CENTER);
	public static JTextField jt3 = new JTextField("C2 or Concentration Desired");
	public static JTextField jt4 = new JTextField("V2 or Volume Desired");
	public static JButton jb = new JButton("Solve");
	
	private static void appendToFile(File file, String content) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(content + System.lineSeparator());
        fileWriter.close();
    }
	
	public static void addResult(double C1, double C2, double V1, double V2)
	{
		String fileName = "CalculatorResults.txt";
        File file = new File(fileName);
        String add = "Result: C1 = " + C1 + ", V1 = " + V1 + ", C2 = " + C2 + ", V2 = " + V2;
        try {
            if (!file.exists()) {
                boolean created = file.createNewFile();
                if (created) {
                    System.out.println("File created: " + fileName);
                    appendToFile(file, add);
                } else {
                    System.out.println("Failed to create the file: " + fileName);
                }
            } else {
                appendToFile(file, add);
            }
        } catch (IOException ee) {
            System.out.println("An error occurred: " + ee.getMessage());
        }
	}
	
	GUIForCalculator(){
		JFrame jfrm = new JFrame("Dilution Calculator");
		jfrm.setSize(500, 200);
		jfrm.setLayout(new GridLayout(3,3,0,0));
		jfrm.setVisible(true);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jb.addActionListener(this);
		
		jfrm.add(jlab1);
		jfrm.add(jlab2);
		jfrm.add(jlab3);
		jfrm.add(jt1);
		jfrm.add(jt2);
		jfrm.add(jlab6);
		jfrm.add(jt3);
		jfrm.add(jt4);
		jfrm.add(jb);
	}
	
	public static void main(String[]args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			new GUIForCalculator();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(jt1.getText().equals("") && jt2.getText().equals("") || jt3.getText().equals("") && jt4.getText().equals("") || 
				jt1.getText().equals("") && jt3.getText().equals("") || jt2.getText().equals("") && jt4.getText().equals("") ||
				jt1.getText().equals("") && jt4.getText().equals("") || jt2.getText().equals("") && jt3.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Invalid Input");
		}
		else {
			if(jt1.getText().equals("")) {
				double V1 = Double.valueOf(jt2.getText());
				double C2 = Double.valueOf(jt3.getText());
				double V2 = Double.valueOf(jt4.getText());
				double C1 = (C2 * V2) / V1;
				double answer = C1;
				String answerString = "" + answer;
				JOptionPane.showMessageDialog(null, "C1 = " + answer);
				jt1.setText(answerString);
				addResult(C1,C2,V1,V2);
			}
			if(jt2.getText().equals("")) {
				double C1 = Double.valueOf(jt1.getText());
				double C2 = Double.valueOf(jt3.getText());
				double V2 = Double.valueOf(jt4.getText());
				double V1 = (C2 * V2) / C1;
				double answer = V1;
				String answerString = "" + answer;
				JOptionPane.showMessageDialog(null, "V1 = " + answer);
				jt2.setText(answerString);
				addResult(C1,C2,V1,V2);
			}
			if(jt3.getText().equals("")) {
				double C1 = Double.valueOf(jt1.getText());
				double V1 = Double.valueOf(jt2.getText());
				double V2 = Double.valueOf(jt4.getText());
				double C2 = (C1 * V1) / V2;
				double answer = C2;
				String answerString = "" + answer;
				JOptionPane.showMessageDialog(null, "C2 = " + answer);
				jt3.setText(answerString);
				addResult(C1,C2,V1,V2);
			}
			if(jt4.getText().equals("")) {
				double C1 = Double.valueOf(jt1.getText());
				double V1 = Double.valueOf(jt2.getText());
				double C2 = Double.valueOf(jt3.getText());
				double V2 = (C1 * V1) / C2;
				double answer = V2;
				String answerString = "" + answer;
				JOptionPane.showMessageDialog(null, "V2 = " + answer);
				jt4.setText(answerString);
				addResult(C1,C2,V1,V2);
			}
		}
		
	}
	
}
