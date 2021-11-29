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
 *	This program is a price predictor that uses past trends of a given
 *	cryptocurrency to predict the potential future price of any given cryptocurrency.
 *	The price predictor uses the 6 month, 3 month, 1 month, 1 week, and 1 day percentage
 *	changes to predict the future price percentage change. The number calculated is
 *	only a prediction, and not a guarantee of any price change.
 */

public class PricePredictor {

	static JFrame frame = new JFrame("Potential Profit Calculator");
	static JPanel panel = new JPanel();

	public static void main(String[] args) {
		frame.setVisible(true);
		frame.setLocation(300, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout grid = new GridLayout(8, 2);
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

		JLabel sixMonth = new JLabel("Please enter the percent change in the last six months");
		panel.add(sixMonth);

		JTextField sixMonthText = new JTextField();
		panel.add(sixMonthText);

		JLabel threeMonth = new JLabel("Please enter the percent change in the last three months");
		panel.add(threeMonth);

		JTextField threeMonthText = new JTextField();
		panel.add(threeMonthText);

		JLabel oneMonth = new JLabel("Please enter the percent change in the last month");
		panel.add(oneMonth);

		JTextField oneMonthText = new JTextField();
		panel.add(oneMonthText);
		
		JLabel oneWeek = new JLabel("Please enter the percent change in the last week");
		panel.add(oneWeek);

		JTextField oneWeekText = new JTextField();
		panel.add(oneWeekText);
		
		JLabel oneDay = new JLabel("Please enter the percent change in the last day");
		panel.add(oneDay);

		JTextField oneDayText = new JTextField();
		panel.add(oneDayText);

		JLabel buttonLabel = new JLabel("Click the button to perform the calculation");
		panel.add(buttonLabel);

		JButton button = new JButton("Calculate");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double price = Double.parseDouble(cryptoPriceText.getText());
					double six = Double.parseDouble(sixMonthText.getText());
					double three = Double.parseDouble(threeMonthText.getText());
					double oneMonth = Double.parseDouble(oneMonthText.getText());
					double oneWeek = Double.parseDouble(oneWeekText.getText());
					double oneDay = Double.parseDouble(oneDayText.getText());
					
					double prediction = six * 0.5 + three * 0.2 + oneMonth * 0.15 + oneWeek * 0.1 + oneDay * 0.05;
					prediction = Math.floor(prediction * 100) / 100;
					double predictionPrice = price + price * prediction / 100;
					predictionPrice = Math.floor(predictionPrice * 100) / 100;
					
					if(prediction >= 0)
					{
						buttonLabel.setText(cryptoNameText.getText()+" is predicted to go up "+prediction+"% ("+predictionPrice+"$) in the coming weeks/months");
					}
					else
					{
						buttonLabel.setText(cryptoNameText.getText()+" is predicted to go down "+prediction+"% ("+predictionPrice+"$) in the coming weeks/months");
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
