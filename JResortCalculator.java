// a small interactive calculator to price a room Exercise on pgs 745-748
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JResortCalculator extends JFrame implements ItemListener
{


	// instance variables for this class
	final int BASE_PRICE = 200;
	final int WEEKEND_PREMIUM = 100;
	final int BREAKFAST_PREMIUM = 20;
	final int GOLF_PREMIUM = 75;
	int totalPrice = BASE_PRICE;

	JCheckBox weekendBox = new JCheckBox("Weekend premium $" + WEEKEND_PREMIUM, false);
	JCheckBox breakfastBox = new JCheckBox("Breakfast premium $" + BREAKFAST_PREMIUM, false);
	JCheckBox golfBox = new JCheckBox("Golf premium $" + GOLF_PREMIUM, false);
	JLabel resortLabel = new JLabel ("Resort Price Calculator");
	JLabel optionExplainLabel = new JLabel ("Base Price for a room is $" + BASE_PRICE);
	JLabel optionExplainLabel2 = new JLabel("Check off any add-ons you wish.");
	JLabel priceLabel = new JLabel("The price for your stay in is:");
	JTextField totPriceField = new JTextField(4);

// custom constructor for this class
	public JResortCalculator()
	{
		super("Resort Price Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		add(resortLabel);
		add(optionExplainLabel);
		add(optionExplainLabel2);
		add(weekendBox);
		add(breakfastBox);
		add(golfBox);
		add(priceLabel);
		add(totPriceField);

		// when app loads, set the totalPrice into the field
		totPriceField.setText("$" + totalPrice);

		// add event listeners to the checkbox
		weekendBox.addItemListener(this);
		breakfastBox.addItemListener(this);
		golfBox.addItemListener(this);	
	}

	// Event handling method
	@Override
	public void itemStateChanged(ItemEvent event)
	{
		Object source = event.getSource();
		int select = event.getStateChange();

		// IF statement that decides which checkbox was the source of the ItemEvent
		if(source == weekendBox)
		{
			// now that we know the source, decide if the check box is selected or not
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += WEEKEND_PREMIUM;
			}
			else
			{
				totalPrice -= WEEKEND_PREMIUM;
			}
		}
		else if(source == breakfastBox)
		{
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += BREAKFAST_PREMIUM;
			}
			else
			{
				totalPrice -= BREAKFAST_PREMIUM;
			}
		}
		else
		{
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += GOLF_PREMIUM;
			}
			else
			{
				totalPrice -= GOLF_PREMIUM;
			}
				
		}

		totPriceField.setText("$" + totalPrice);
  	}

	public static void main(String[] args) 
	{
		JResortCalculator aFrame = new JResortCalculator();
		aFrame.setSize(420, 240);
		aFrame.setVisible(true);		
	}
} 