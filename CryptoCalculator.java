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

public class CryptoCalculator {
	static JFrame f = new JFrame("Required to Stake Calculator");
	static JPanel panel = new JPanel();
	static int year = 1;

	public static void main(String[] args) {
		f.setVisible(true);
		f.setLocation(300, 100);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout grid = new GridLayout(3, 2);
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
				
				GridLayout grid = new GridLayout(6,2);
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

		        			double totalGain = (price*owned)+(price*owned*gains/100.0);
		        			double totalLoss = (price*owned)-(price*owned*loss/100.0);
		        			
		        			buttonLabel.setText(cryptoNameText.getText()+" could be worth between $"+totalLoss+" and $"+totalGain);
		        		}
		        		catch(Exception ex)
		        		{
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

				JLabel button2Label = new JLabel("Click the button to perform the calculation once (compound interest)");
				panel.add(button2Label);

				JButton button2 = new JButton("Calculate compound interest");
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

				String[] timeframes = {"day","week","month","year"};
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
							String choice = (String)box.getSelectedItem();
							if(choice.equals("day"))
							{
								double price = Double.parseDouble(cryptoPriceText.getText());
								double percentage = Double.parseDouble(cryptoPercentageText.getText());
								double desired = Double.parseDouble(cryptoEarningsText.getText());
								
								double total = desired*365/(percentage/100);
								double money = Math.floor(price*total*100) / 100;
								buttonLabel.setText("In order to earn "+desired+" "+cryptoNameText.getText()+" per day, you must stake "+total+cryptoNameText.getText()+"($"+money+")");
							}
							else if(choice.equals("week"))
							{
								double price = Double.parseDouble(cryptoPriceText.getText());
								double percentage = Double.parseDouble(cryptoPercentageText.getText());
								double desired = Double.parseDouble(cryptoEarningsText.getText());
								
								double total = desired*52/(percentage/100);
								double money = Math.floor(price*total*100) / 100;
								buttonLabel.setText("In order to earn "+desired+" "+cryptoNameText.getText()+" per week, you must stake "+total+cryptoNameText.getText()+"($"+money+")");
							}
							else if(choice.equals("month"))
							{
								double price = Double.parseDouble(cryptoPriceText.getText());
								double percentage = Double.parseDouble(cryptoPercentageText.getText());
								double desired = Double.parseDouble(cryptoEarningsText.getText());
								
								double total = desired*12/(percentage/100);
								double money = Math.floor(price*total*100) / 100;
								buttonLabel.setText("In order to earn "+desired+" "+cryptoNameText.getText()+" per month, you must stake "+total+cryptoNameText.getText()+"($"+money+")");
							}
							else if(choice.equals("year"))
							{
								double price = Double.parseDouble(cryptoPriceText.getText());
								double percentage = Double.parseDouble(cryptoPercentageText.getText());
								double desired = Double.parseDouble(cryptoEarningsText.getText());
								
								double total = desired/(percentage/100);
								double money = Math.floor(price*total*100) / 100;
								buttonLabel.setText("In order to earn "+desired+" "+cryptoNameText.getText()+" per year, you must stake "+total+cryptoNameText.getText()+"($"+money+")");
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
			
			
		});
		panel.add(earnings);
		
		JButton risk = new JButton("Risk Adjustment Slider");
		risk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
			
		});
		panel.add(risk);

		f.pack();
		f.setSize(1000, 500);

	}
}
