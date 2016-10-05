package com.jtizz.NavigationController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.CSUSM.testTaker.UI.CustomPage;

/**
 * @author Justin
 * @description Runs an example Application with the NavigationController Implementation.
 *
 */
public class ExampleDriver extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new ExampleDriver();

	}
	
	public ExampleDriver(){
		this.setSize(750, 500);
		this.setTitle("Testing Application");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Add the navigation Controller
		NavigationController nc = new NavigationController();
		this.add(nc);
		
		this.setVisible(true);
		
		//Now, add a few sample views, each with a label indicating the page number
		for(int i = 0; i <= 5; i++){
			JPanel testPanel = new JPanel();
			testPanel.setBackground(new Color(25, 251, i*5));
			testPanel.add(new JLabel("Label: " + (i+1)));
			nc.displayView(testPanel);
		}
		
		CustomPage newPage = new CustomPage(CustomPage.PanelType.THREE_BUTTON_TYPE);
		newPage.setName("Testing a 3 Btn");
		nc.displayView(newPage);
		
		//Count all the views currently shown
		System.out.println("View Shown in container: " + nc.getComponentCount());
		for(Component a : nc.getComponents()){
			System.out.println("Component Name: " + a.getName());
		}
	}

}