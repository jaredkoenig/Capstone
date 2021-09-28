
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
//import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class StablecoinCompoundCalculator {

	static JFrame f = new JFrame("Stablecoin Compound Interest Calculator");
	static JPanel panel = new JPanel();
	static int year = 1;

	public static void main(String[] args) {
		f.setVisible(true);
		f.setLocation(300, 100);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout grid = new GridLayout(4, 2);
		f.setContentPane(panel);

		panel.setLayout(grid);
		panel.setBackground(Color.CYAN);

		JLabel cryptoStaked = new JLabel("Please enter the current amount of stablecoin staked");
		panel.add(cryptoStaked);

		JTextField cryptoStakedText = new JTextField();
		panel.add(cryptoStakedText);

		JLabel cryptoInterest = new JLabel("Please enter the current APR interest for the stablecoin");
		panel.add(cryptoInterest);

		JTextField cryptoInterestText = new JTextField();
		panel.add(cryptoInterestText);

		JLabel buttonLabel = new JLabel("Click the button to perform the calculation once (simple interest)");
		panel.add(buttonLabel);

		JButton button = new JButton("Calculate simple interest");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double staked = Double.parseDouble(cryptoStakedText.getText());
					double interest = Double.parseDouble(cryptoInterestText.getText());

					double totalGain = (staked) + (staked * interest / 100.0);
					totalGain = Math.floor(totalGain * 100) / 100;

					buttonLabel.setText("Your stablecoin will be worth $" + totalGain + " after 1 year");
				} catch (Exception ex) {
					buttonLabel.setText("Invalid input");
					System.out.println(ex);
				}
			}
		});
		panel.add(button);

		JLabel button2Label = new JLabel("Click the button to perform the calculation once (compound interest)");
		panel.add(button2Label);

		JButton button2 = new JButton("Calculate simple interest");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double staked = Double.parseDouble(cryptoStakedText.getText());
					double interest = Double.parseDouble(cryptoInterestText.getText());

					double totalGain = (staked) + (staked * interest / 100.0);
					totalGain = Math.floor(totalGain * 100) / 100;
					
					button2Label
							.setText("Your stablecoin will be worth $" + totalGain + " after " + year + " year(s).");
					year++;

					cryptoStakedText.setText(totalGain + "");
				} catch (Exception ex) {
					buttonLabel.setText("Invalid input");
					System.out.println(ex);
				}
			}
		});
		panel.add(button2);

		f.pack();
		f.setSize(800, 500);

	}
}
