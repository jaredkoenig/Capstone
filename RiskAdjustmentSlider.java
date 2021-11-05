import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class RiskAdjustmentSlider {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Risk adjustment slider");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        			
        			if(risk == 0)
        			{
        				text1.setText("In order to have 0 risk and a 100% guarantee on a set interest rate per year, you must put 100% of your investing money into stablecoin and stake");
        				text2.setText("all of it for up to a guaranteed 14% APR return on investment. This is the only cryptocurrency investment that truly has 0 risk.");
        			}
        			if(risk == 25)
        			{
        				text1.setText("With a 25% risk tolerance, 75% of your investment should be a guaranteed rate with stablecoin.");
        				text2.setText("12.5% of your investment should be Bitcoin, and 12.5% of your investment should be Ethereum.");
        			}
        			if(risk == 50)
        			{
        				text1.setText("With a 50% risk tolerance, 50% of your investment should be a guaranteed rate with stablecoin.");
        				text2.setText("12.5% Bitcoin, and 12.5% Ethereum. 25% of your investment should be altcoins (BNB, ATOM, CRO, DOGE, SHIBA, etc.)");
        			}
        			if(risk == 75)
        			{
        				text1.setText("With a 75% risk tolerance, 25% of your investment should be a guaranteed rate with stablecoin.");
        				text2.setText("12.5% Bitcoin, and 12.5% Ethereum. 50% of your investment should be altcoins (BNB, ATOM, CRO, DOGE, SHIBA, etc.)");
        			}
        			if(risk == 100)
        			{
        				text1.setText("With a 100% risk tolerance, none of your investment should be in stablecoin.");
        				text2.setText("12.5% should be in Bitcoin, and 12.5% Ethereum. 75% of your investment should be altcoins (BNB, ATOM, CRO, DOGE, SHIBA, etc.)");
        			}
        			
        		}
        		catch(Exception ex)
        		{
        			
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
		grid.setLayout(new GridLayout(2,0));
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

}
