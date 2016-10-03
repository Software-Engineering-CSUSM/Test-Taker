package com.jtizz.NavigationController;

import javax.swing.JFrame;

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
		this.setSize(500, 500);
		this.setTitle("Testing Application");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Add the navigation Controller
		NavigationController nc = new NavigationController();
		this.add(nc);
		
		
		this.setVisible(true);
	}

}
