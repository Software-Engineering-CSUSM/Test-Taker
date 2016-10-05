package com.jtizz.NavigationController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.CSUSM.testTaker.UI.*;

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
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Add the navigation Controller
		NavigationController nc = new NavigationController();
		this.add(nc, BorderLayout.CENTER);
		
		this.setVisible(true);
		
		SideMenu sm = new SideMenu(new String[]{"Home", "Courses", "Study Tools", "Statistics"});
		this.add(sm, BorderLayout.WEST);
		
		CustomPage newPage = new CustomPage(CustomPage.PanelType.LOGO_ONLY_TYPE, "https://github.com/Software-Engineering-CSUSM/Test-Taker/blob/master/Team%20Graphics/Test_Taker_LogoOption3.png?raw=true");
		newPage.setName("Testing a Logo");
		nc.displayView(newPage);
		
		CustomPage testingTwo = new CustomPage(CustomPage.PanelType.TWO_BUTTON_TYPE);
		testingTwo.setName("Testing 2 Paneles");
		nc.setInitialView(testingTwo);
		testingTwo.currentActions[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CustomPage thirdPage = new CustomPage(CustomPage.PanelType.THREE_BUTTON_TYPE);
				thirdPage.setName("Testing a 3 Btn");
				nc.displayView(thirdPage);
			}
		});
		

		PageManager pm = new PageManager(SideMenu.menuOptionButtons, new CustomPage[]{newPage, testingTwo}, 0);
		
		
		//Count all the views currently shown
		System.out.println("View Shown in container: " + nc.getComponentCount());
		for(Component a : nc.getComponents()){
			System.out.println("Component Name: " + a.getName());
		}
	}

}
