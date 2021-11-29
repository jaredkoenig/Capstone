import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JButton;

/**
 * @author Jared Koenig
 * 
 *	Welcome to CryptoCalculator! CryptoCalculator is an aggregation of
 *	complex calculators related to making money with cryptocurrency.
 *	There is a potential profit calculator which helps users to determine
 *	possible profits/losses based on predictions of possible outcomes.
 *	There is a stablecoin multi click calculator that determines profits
 *	from stablecoin investments year by year. There is a stablecoin single
 *	Click calculator that instantly calculates many years of compound interest
 *	with one click. There is a required to stake calculator that tells a user
 *	how much is required to stake of a given cryptocurrency to make X amount per
 *	day, week, month, and/or year. Conversely, there is a staked earnings calculator,
 *	which tells the user how much of a given cryptocurrency is being made based on how
 *	much is already staked per day, week, month, and/or year. There is a risk adjustment
 *	slider which helps a potential investor prepare to invest based on a cost/benefit
 *	analysis. Finally, there is a price predictor that uses past trends of a given
 *	cryptocurrency to predict the potential future price of any given cryptocurrency.
 */

public class CryptoCalculator {
	static JFrame f = new JFrame("Welcome to CryptoCalculator!");
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

		JButton profit = new JButton("Pontential Profit Calculator");
		profit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Potential Profit Calculator");
				JPanel panel = new JPanel();
				frame.setVisible(true);
				frame.setLocation(300, 100);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

				JLabel cryptoOwned = new JLabel("Please enter the amount of cryptocurrency owned");
				panel.add(cryptoOwned);

				JTextField cryptoOwnedText = new JTextField();
				panel.add(cryptoOwnedText);

				JLabel cryptoGains = new JLabel("Please enter the possible percentage gain");
				panel.add(cryptoGains);

				JTextField cryptoGainsText = new JTextField();
				panel.add(cryptoGainsText);

				JLabel cryptoLoss = new JLabel("Please enter the possible percentage loss");
				panel.add(cryptoLoss);

				JTextField cryptoLossText = new JTextField();
				panel.add(cryptoLossText);

				JLabel buttonLabel = new JLabel("Click the button to perform the calculation");
				panel.add(buttonLabel);

				JButton button = new JButton("Calculate");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							double price = Double.parseDouble(cryptoPriceText.getText());
							double owned = Double.parseDouble(cryptoOwnedText.getText());
							double gains = Double.parseDouble(cryptoGainsText.getText());
							double loss = Double.parseDouble(cryptoLossText.getText());

							double totalGain = (price * owned) + (price * owned * gains / 100.0);
							double totalLoss = (price * owned) - (price * owned * loss / 100.0);

							buttonLabel.setText(cryptoNameText.getText() + " could be worth between $" + totalLoss
									+ " and $" + totalGain);
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

		});
		panel.add(profit);

		JButton stableMulti = new JButton("Stablecoin Multi Click Calculator");
		stableMulti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Stablecoin Compound Interest Calculator");
				JPanel panel = new JPanel();
				frame.setVisible(true);
				frame.setLocation(300, 100);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

				JLabel button2Label = new JLabel(
						"Click the button to perform the calculation once (compound interest)");
				panel.add(button2Label);

				JButton button2 = new JButton("Calculate compound interest");
				button2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							double staked = Double.parseDouble(cryptoStakedText.getText());
							double interest = Double.parseDouble(cryptoInterestText.getText());

							double totalGain = (staked) + (staked * interest / 100.0);
							totalGain = Math.floor(totalGain * 100) / 100;

							button2Label.setText(
									"Your stablecoin will be worth $" + totalGain + " after " + year + " year(s).");
							year++;

							cryptoStakedText.setText(totalGain + "");
						} catch (Exception ex) {
							buttonLabel.setText("Invalid input");
							System.out.println(ex);
						}
					}
				});
				panel.add(button2);

				frame.pack();
				frame.setSize(1000, 500);
			}

		});
		panel.add(stableMulti);

		JButton stableSingle = new JButton("Stablecoin Single Click Calculator");
		stableSingle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Stablecoin Compound Interest Calculator");
				JPanel panel = new JPanel();

				frame.setVisible(true);
				frame.setLocation(300, 100);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

							for (int i = 0; i < years; i++) {
								totalGain = (staked) + (staked * interest / 100.0);
								totalGain = Math.floor(totalGain * 100) / 100;
								staked = totalGain;
							}

							button2Label.setText(
									"Your stablecoin will be worth $" + totalGain + " after " + years + " year(s).");

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

		});
		panel.add(stableSingle);

		JButton required = new JButton("Required to Stake Calculator");
		required.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Required to Stake Calculator");
				JPanel panel = new JPanel();
				frame.setVisible(true);
				frame.setLocation(300, 100);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

				String[] timeframes = { "day", "week", "month", "year" };
				JComboBox box = new JComboBox(timeframes);
				panel.add(box);

				JLabel cryptoEarnings = new JLabel("Please enter the desired earnings in the timeframe");
				panel.add(cryptoEarnings);

				JTextField cryptoEarningsText = new JTextField();
				panel.add(cryptoEarningsText);

				JLabel buttonLabel = new JLabel("Click the button to perform the calculation");
				panel.add(buttonLabel);

				JButton button = new JButton("Calculate");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String choice = (String) box.getSelectedItem();
							if (choice.equals("day")) {
								double price = Double.parseDouble(cryptoPriceText.getText());
								double percentage = Double.parseDouble(cryptoPercentageText.getText());
								double desired = Double.parseDouble(cryptoEarningsText.getText());

								double total = desired * 365 / (percentage / 100);
								double money = Math.floor(price * total * 100) / 100;
								buttonLabel.setText("In order to earn " + desired + " " + cryptoNameText.getText()
										+ " per day, you must stake " + total + cryptoNameText.getText() + "($" + money
										+ ")");
							} else if (choice.equals("week")) {
								double price = Double.parseDouble(cryptoPriceText.getText());
								double percentage = Double.parseDouble(cryptoPercentageText.getText());
								double desired = Double.parseDouble(cryptoEarningsText.getText());

								double total = desired * 52 / (percentage / 100);
								double money = Math.floor(price * total * 100) / 100;
								buttonLabel.setText("In order to earn " + desired + " " + cryptoNameText.getText()
										+ " per week, you must stake " + total + cryptoNameText.getText() + "($" + money
										+ ")");
							} else if (choice.equals("month")) {
								double price = Double.parseDouble(cryptoPriceText.getText());
								double percentage = Double.parseDouble(cryptoPercentageText.getText());
								double desired = Double.parseDouble(cryptoEarningsText.getText());

								double total = desired * 12 / (percentage / 100);
								double money = Math.floor(price * total * 100) / 100;
								buttonLabel.setText("In order to earn " + desired + " " + cryptoNameText.getText()
										+ " per month, you must stake " + total + cryptoNameText.getText() + "($"
										+ money + ")");
							} else if (choice.equals("year")) {
								double price = Double.parseDouble(cryptoPriceText.getText());
								double percentage = Double.parseDouble(cryptoPercentageText.getText());
								double desired = Double.parseDouble(cryptoEarningsText.getText());

								double total = desired / (percentage / 100);
								double money = Math.floor(price * total * 100) / 100;
								buttonLabel.setText("In order to earn " + desired + " " + cryptoNameText.getText()
										+ " per year, you must stake " + total + cryptoNameText.getText() + "($" + money
										+ ")");
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

		});
		panel.add(required);

		JButton earnings = new JButton("Staked Earnings Calculator");
		earnings.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Staked Earnings Calculator");
				JPanel panel = new JPanel();

				frame.setVisible(true);
				frame.setLocation(300, 100);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

				String[] timeframes = { "day", "week", "month", "year" };
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
							String choice = (String) box.getSelectedItem();
							if (choice.equals("day")) {
								double price = Double.parseDouble(cryptoPriceText.getText());
								double percentage = Double.parseDouble(cryptoPercentageText.getText());
								double staked = Double.parseDouble(cryptoStakedText.getText());

								double total = staked / 365 * (percentage / 100);
								double money = Math.floor(price * total * 100) / 100;
								buttonLabel.setText("You are earning " + total + " " + cryptoNameText.getText()
										+ " per day " + "($" + money + ")");
							} else if (choice.equals("week")) {
								double price = Double.parseDouble(cryptoPriceText.getText());
								double percentage = Double.parseDouble(cryptoPercentageText.getText());
								double desired = Double.parseDouble(cryptoStakedText.getText());

								double total = desired / 52 * (percentage / 100);
								double money = Math.floor(price * total * 100) / 100;
								buttonLabel.setText("You are earning " + total + " " + cryptoNameText.getText()
										+ " per week " + "($" + money + ")");
							} else if (choice.equals("month")) {
								double price = Double.parseDouble(cryptoPriceText.getText());
								double percentage = Double.parseDouble(cryptoPercentageText.getText());
								double desired = Double.parseDouble(cryptoStakedText.getText());

								double total = desired / 12 * (percentage / 100);
								double money = Math.floor(price * total * 100) / 100;
								buttonLabel.setText("You are earning " + total + " " + cryptoNameText.getText()
										+ " per month " + "($" + money + ")");
							} else if (choice.equals("year")) {
								double price = Double.parseDouble(cryptoPriceText.getText());
								double percentage = Double.parseDouble(cryptoPercentageText.getText());
								double desired = Double.parseDouble(cryptoStakedText.getText());

								double total = desired * (percentage / 100);
								double money = Math.floor(price * total * 100) / 100;
								buttonLabel.setText("You are earning " + total + " " + cryptoNameText.getText()
										+ " per year " + "($" + money + ")");
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

		});
		panel.add(earnings);

		JButton risk = new JButton("Risk Adjustment Slider");
		risk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Risk adjustment slider");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setLocation(300, 100);
				frame.setSize(1000, 500);

				JPanel panel = new JPanel();
				panel.setLayout(new GridLayout(3, 0));
				JSlider slider = new JSlider();

				slider.setMajorTickSpacing(25);
				slider.setMinorTickSpacing(25);
				slider.setSnapToTicks(true);
				slider.setPaintTicks(true);
				slider.setPaintLabels(true);
				slider.setBackground(Color.CYAN);

				Hashtable position = new Hashtable();
				position.put(0, new JLabel("0% risk tolerance"));
				position.put(25, new JLabel("25%"));
				position.put(50, new JLabel("50%"));
				position.put(75, new JLabel("75%"));
				position.put(100, new JLabel("100% risk tolerance"));

				slider.setLabelTable(position);
				panel.add(slider);

				JLabel text1 = new JLabel("Move the slider to your risk tolerance and click calculate");
				JLabel text2 = new JLabel("");

				JButton button = new JButton("Calculate");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int risk = slider.getValue();

							if (risk == 0) {
								text1.setText(
										"In order to have 0 risk and a 100% guarantee on a set interest rate per year, you must put 100% of your investing money into stablecoin and stake");
								text2.setText(
										"all of it for up to a guaranteed 14% APR return on investment. This is the only cryptocurrency investment that truly has 0 risk.");
							}
							if (risk == 25) {
								text1.setText(
										"With a 25% risk tolerance, 75% of your investment should be a guaranteed rate with stablecoin.");
								text2.setText(
										"12.5% of your investment should be Bitcoin, and 12.5% of your investment should be Ethereum.");
							}
							if (risk == 50) {
								text1.setText(
										"With a 50% risk tolerance, 50% of your investment should be a guaranteed rate with stablecoin.");
								text2.setText(
										"12.5% Bitcoin, and 12.5% Ethereum. 25% of your investment should be altcoins (BNB, ATOM, CRO, DOGE, SHIBA, etc.)");
							}
							if (risk == 75) {
								text1.setText(
										"With a 75% risk tolerance, 25% of your investment should be a guaranteed rate with stablecoin.");
								text2.setText(
										"12.5% Bitcoin, and 12.5% Ethereum. 50% of your investment should be altcoins (BNB, ATOM, CRO, DOGE, SHIBA, etc.)");
							}
							if (risk == 100) {
								text1.setText(
										"With a 100% risk tolerance, none of your investment should be in stablecoin.");
								text2.setText(
										"12.5% should be in Bitcoin, and 12.5% Ethereum. 75% of your investment should be altcoins (BNB, ATOM, CRO, DOGE, SHIBA, etc.)");
							}

						} catch (Exception ex) {

						}
					}
				});
				panel.add(button);
				JPanel grid = new JPanel();
				JPanel firstPanel = new JPanel();
				firstPanel.setBackground(Color.CYAN);
				firstPanel.setLayout(new FlowLayout());
				JPanel secondPanel = new JPanel();
				secondPanel.setBackground(Color.CYAN);
				secondPanel.setLayout(new FlowLayout());
				grid.setLayout(new GridLayout(2, 0));
				firstPanel.add(text1);
				secondPanel.add(text2);
				grid.add(firstPanel);
				grid.add(secondPanel);
				panel.add(grid);

				panel.setBackground(Color.CYAN);
				grid.setBackground(Color.CYAN);
				frame.add(panel);
				frame.setVisible(true);

			}

		});
		panel.add(risk);

		JButton predictor = new JButton("Price Predictor");
		predictor.addActionListener(new ActionListener() {
			JFrame frame = new JFrame("Price Predictor");
			JPanel panel = new JPanel();

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				frame.setLocation(300, 100);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

							double prediction = six * 0.5 + three * 0.2 + oneMonth * 0.15 + oneWeek * 0.1
									+ oneDay * 0.05;
							prediction = Math.floor(prediction * 100) / 100;
							double predictionPrice = price + price * prediction / 100;
							predictionPrice = Math.floor(predictionPrice * 100) / 100;

							if (prediction >= 0) {
								buttonLabel.setText(cryptoNameText.getText() + " is predicted to go up " + prediction
										+ "% (" + predictionPrice + "$) in the coming weeks/months");
							} else {
								buttonLabel.setText(cryptoNameText.getText() + " is predicted to go down " + prediction
										+ "% (" + predictionPrice + "$) in the coming weeks/months");
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
				panel = new JPanel();

			}
		});

		panel.add(predictor);

		f.pack();
		f.setSize(1000, 500);

	}
}
