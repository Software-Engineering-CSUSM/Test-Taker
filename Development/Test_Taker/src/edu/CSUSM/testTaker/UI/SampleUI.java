package edu.CSUSM.testTaker.UI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Justin Goulet
 * @dateCreated Sept 26, 2016
 * 
 * @classFunctions To demonstrate a basic UI functionality and to showcase key ideas that we will be using in the project
 * 
 *
 */


public class SampleUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6436758832628389649L;
	private static final int STATUS_BAR_HEIGHT = 10;
	public static JLabel helloWorldLabel;
	public static SampleUI.ChangeWelcomeLabel buttonAction;

	public static void main(String[] args){
		JFrame sampleFrame = new JFrame("Hello World Again");		//Sets the title of the frame
		sampleFrame.setSize(500, 200);								//Sets the size of the frame
		sampleFrame.setLocationRelativeTo(null);					//Positions the frame in the center of the screen
		sampleFrame.setLayout(new GridLayout(1,2));				//Sets the layout of the panel to a grid layout (Columns, Rows)
		sampleFrame.setLayout(null);								//Allows us to specify coordinates of objects
		sampleFrame.setVisible(true);								//Shows the frame on the screen
		//sampleFrame.setResizable(false);							//Blocks the frame from being resized by the user
		sampleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Forces the application to close when the 'X' is tapped in the top bar
		
		//Create a JPanel
		JPanel samplePanel = new JPanel();							//Creates a new Panel to hold content within the frame
		samplePanel.setBounds(0,0, 
				sampleFrame.getWidth(),								//Sets the (x-coor, y-coor, width, height) of the object
				sampleFrame.getHeight() -STATUS_BAR_HEIGHT);		//Note that the status bar is 20pt 
		samplePanel.setBackground(Color.WHITE);						//Sets the background color of the panel
		sampleFrame.add(samplePanel);								//Adds the panel to the main frame
		
		//Sample Button
		JButton sampleButton = new JButton("Sample");				//Creates a sample button with a specified title
		sampleButton.setBounds(15, 25, 180, 30);					//Sets the (x-coor, y-coor, width, height) of the object
		sampleButton.setBackground(Color.RED);						//Sets the background color of the button
		sampleButton.setOpaque(true);								//Allows the background color to be shown
		samplePanel.add(sampleButton);								//Adds the button to the panel
		
		JButton sampleButton2 = new JButton();						//Creates a sample button without a title
		sampleButton2.setBackground(Color.RED);						//Sets the background color of the button
		sampleButton2.setOpaque(true);								//Allows the background color to be shown
		sampleButton2.setText("Hello world2");						//Sets the title of the button
		sampleButton2.setBounds(85, 95, 150, 30);					//Sets the (x-coor, y-coor, width, height) of the object
		samplePanel.add(sampleButton2);								//Adds the button to the panel
		
		JButton sample3 = new JButton("Click Me!");					//Creates a sample button with a specified title
		sample3.setBounds(125, 125, 100, 30);						//Sets the (x-coor, y-coor, width, height) of the object
		buttonAction = new ChangeWelcomeLabel();					//Instantiates a reference to the inner, private class
		sample3.addActionListener(buttonAction);					//Adds an action to the button
		samplePanel.add(sample3);									//Adds the button to the panel
		
		helloWorldLabel = new JLabel("Hello World");				//Creates a new label with a specified title
		helloWorldLabel.setBounds(									//Sets the (x-coor, y-coor, width, height) of the object
				sampleFrame.getWidth()/2, 							//Note that it is by origin, not center
				0, 							
				sampleFrame.getWidth() - 10, 
				30);
		samplePanel.add(helloWorldLabel);							//Adds the label to the frame
		
		sampleFrame.repaint();										//Redraws the panel to hold the buttons and label
	}
	
	private static class ChangeWelcomeLabel implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("Action Found: " + e.getActionCommand());
			helloWorldLabel.setText(((helloWorldLabel.getText()).equals("Hello World")) ? "You did it!" : "Hello World");
		}
	}
	

}

