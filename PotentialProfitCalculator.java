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

public class PotentialProfitCalculator {
	static JFrame f = new JFrame("Practice");
	static JPanel panel = new JPanel();

	public static void main(String[] args)
	{
		f.setVisible(true);
		f.setLocation(300, 100);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout grid = new GridLayout(6,2);
		f.setContentPane(panel);
		
        panel.setLayout(grid);
        panel.setBackground(Color.CYAN);
        
        JLabel cryptoName = new JLabel("Please enter the name of the cryptocurrency");
        panel.add(cryptoName);
        
        JTextField cryptoNameText = new JTextField();
        panel.add(cryptoNameText);
        
        JLabel cryptoPrice = new JLabel("Please enter the price the cryptocurrency was bought at");
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

		f.pack();
		f.setSize(800, 500);
        

	}
}
