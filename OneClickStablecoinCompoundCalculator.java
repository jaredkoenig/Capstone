
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

/**
 * @author Jared Koenig
 *
 *	There is a stablecoin single click calculator that
 *	instantly calculates many years of compound interest
 *	with one click. This is especially useful for people
 *	planning to retire based on interest earned.
 */

public class OneClickStablecoinCompoundCalculator {
	static JFrame frame = new JFrame("Stablecoin Compound Interest Calculator");
	static JPanel panel = new JPanel();

	public static void main(String[] args) {
		frame.setVisible(true);
		frame.setLocation(300, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout grid = new GridLayout(4, 2);
		frame.setContentPane(panel);

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

		JLabel buttonLabel = new JLabel("Please enter the amount of years you would like to compound");
		panel.add(buttonLabel);

		JTextField cryptoYearsText = new JTextField();
		panel.add(cryptoYearsText);

		JLabel button2Label = new JLabel("Click the button to perform the compound interest calculation");
		panel.add(button2Label);

		JButton button2 = new JButton("Calculate compound interest");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double staked = Double.parseDouble(cryptoStakedText.getText());
					double interest = Double.parseDouble(cryptoInterestText.getText());

					double totalGain = staked;
					int years = Integer.parseInt(cryptoYearsText.getText());
					
					for(int i=0; i<years; i++)
					{
						totalGain = (staked) + (staked * interest / 100.0);
						totalGain = Math.floor(totalGain * 100) / 100;
						staked = totalGain;
					}

					button2Label
							.setText("Your stablecoin will be worth $" + totalGain + " after " + years + " year(s).");
					
				} catch (Exception ex) {
					button2Label.setText("Invalid input");
					System.out.println(ex);
				}
			}
		});
		panel.add(button2);

		frame.pack();
		frame.setSize(1000, 500);

	}
}
