import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

/**
 * @author Jared Koenig
 *
 *	This is a staked earnings calculator,
 *	which tells the user how much of a given
 *	cryptocurrency is being made per day, week,
 *	month, and/or year based on how much is already staked.
 */

public class StakedEarningsCalculator {

	static JFrame frame = new JFrame("Required to Stake Calculator");
	static JPanel panel = new JPanel();

	public static void main(String[] args) {
		frame.setVisible(true);
		frame.setLocation(300, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout grid = new GridLayout(6, 2);
		frame.setContentPane(panel);

		panel.setLayout(grid);
		panel.setBackground(Color.CYAN);

		JLabel cryptoName = new JLabel("Please enter the name of the cryptocurrency");
		panel.add(cryptoName);

		JTextField cryptoNameText = new JTextField();
		panel.add(cryptoNameText);

		JLabel cryptoPrice = new JLabel("Please enter the current price of the cryptocurrency");
		panel.add(cryptoPrice);

		JTextField cryptoPriceText = new JTextField();
		panel.add(cryptoPriceText);

		JLabel cryptoPercentage = new JLabel("Please enter the staking percentage return per year");
		panel.add(cryptoPercentage);

		JTextField cryptoPercentageText = new JTextField();
		panel.add(cryptoPercentageText);

		JLabel cryptoTimeframe = new JLabel("Please enter the desired timeframe for earnings");
		panel.add(cryptoTimeframe);

		String[] timeframes = {"day","week","month","year"};
		JComboBox box = new JComboBox(timeframes);
		panel.add(box);

		JLabel cryptoStaked = new JLabel("Please enter the amount of crypto that is staked");
		panel.add(cryptoStaked);

		JTextField cryptoStakedText = new JTextField();
		panel.add(cryptoStakedText);

		JLabel buttonLabel = new JLabel("Click the button to perform the calculation");
		panel.add(buttonLabel);

		JButton button = new JButton("Calculate");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String choice = (String)box.getSelectedItem();
					if(choice.equals("day"))
					{
						double price = Double.parseDouble(cryptoPriceText.getText());
						double percentage = Double.parseDouble(cryptoPercentageText.getText());
						double staked = Double.parseDouble(cryptoStakedText.getText());
						
						double total = staked/365*(percentage/100);
						double money = Math.floor(price*total*100) / 100;
						buttonLabel.setText("You are earning "+total+ " "+cryptoNameText.getText()+" per day "+"($"+money+")");
					}
					else if(choice.equals("week"))
					{
						double price = Double.parseDouble(cryptoPriceText.getText());
						double percentage = Double.parseDouble(cryptoPercentageText.getText());
						double desired = Double.parseDouble(cryptoStakedText.getText());
						
						double total = desired/52*(percentage/100);
						double money = Math.floor(price*total*100) / 100;
						buttonLabel.setText("You are earning "+total+ " "+cryptoNameText.getText()+" per week "+"($"+money+")");
					}
					else if(choice.equals("month"))
					{
						double price = Double.parseDouble(cryptoPriceText.getText());
						double percentage = Double.parseDouble(cryptoPercentageText.getText());
						double desired = Double.parseDouble(cryptoStakedText.getText());
						
						double total = desired/12*(percentage/100);
						double money = Math.floor(price*total*100) / 100;
						buttonLabel.setText("You are earning "+total+ " "+cryptoNameText.getText()+" per month "+"($"+money+")");
					}
					else if(choice.equals("year"))
					{
						double price = Double.parseDouble(cryptoPriceText.getText());
						double percentage = Double.parseDouble(cryptoPercentageText.getText());
						double desired = Double.parseDouble(cryptoStakedText.getText());
						
						double total = desired*(percentage/100);
						double money = Math.floor(price*total*100) / 100;
						buttonLabel.setText("You are earning "+total+ " "+cryptoNameText.getText()+" per year "+"($"+money+")");
					}

				} catch (Exception ex) {
					buttonLabel.setText("Invalid input");
					System.out.println(ex);
				}
			}
		});
		panel.add(button);

		frame.pack();
		frame.setSize(1000, 500);

	}


}
